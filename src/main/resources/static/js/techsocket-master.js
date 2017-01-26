var stompClient = null;
var gameTemplate = null;
var resultTemplate = null;

var mode = "voting";
var sessionId = null;


function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);

        stompClient.subscribe("/topic/session/" + sessionId + "/stats", function (data) {
            console.log("Stats Received");
            console.log(data);
            var body = JSON.parse(data.body);
            updateGame(body);
            data.ack();
        });

        stompClient.subscribe("/topic/session/" + sessionId + "/result", function (data) {
            console.log("Result Received");
            console.log(data);
            var body = JSON.parse(data.body);
            showResult(body);
            data.ack();
        });
        updateStats();
    });
}
function init() {
    var gameSource = $("#game-template").html();
    gameTemplate = Handlebars.compile(gameSource);
    var resultSource = $("#result-template").html();
    resultTemplate = Handlebars.compile(resultSource);
    sessionId = $('body').data('game-id');
    connect();
}

function renderQr() {
    $('#joinQr').each(function (idx, elem) {
        new QRCode(elem, $(elem).data('qr-url'));
    })
}

function updateGame(data) {
    if (mode === 'voting') {
        data.totalVotes = data.playerVotes.length;
        data.votePercent = data.currentVotes * 100 / data.totalVotes;
        var html = gameTemplate(data);
        $('#content').html(html);
        $('#finish').click(finishVoting);
        renderQr();
    }
}


function showResult(data) {
    if (mode === 'result') {
        var html = resultTemplate(data);
        $('#content').html(html);
        $('#reset').click(resetVotes);
        new Morris.Bar({
            // ID of the element in which to draw the chart.
            element: 'histogram',
            // Chart data records -- each entry in this array corresponds to a point on
            // the chart.
            data: data.votes,
            // The name of the data record attribute that contains x-values.
            xkey: 'choice',
            // A list of names of data record attributes that contain y-values.
            ykeys: ['count'],
            // Labels for the ykeys -- will be displayed when you hover over the
            // chart.
            labels: ['Cards']
        });
    }
}

function finishVoting() {
    mode = "result";
    stompClient.send("/app/session/tally", {}, JSON.stringify({sessionId: sessionId}));
}

function updateStats() {
    stompClient.send("/app/session/stats", {}, JSON.stringify({sessionId: sessionId}));
}

function resetVotes() {
    mode = "voting";
    stompClient.send("/app/session/reset", {}, JSON.stringify({sessionId: sessionId}));
    updateStats();
}

$(function () {
    init();
});