package com.github.leonard84.techpoker.web

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc

import spock.lang.Specification

@ContextConfiguration
@WebMvcTest([QrController])
class QrControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    def "creates qr code"() {
        given:
        def expected = '''\
<?xml version="1.0" encoding="UTF-8"?>
<svg xmlns="http://www.w3.org/2000/svg" version="1.1" viewBox="0 0 41 41" stroke="none">
<style type="text/css">
.black {fill:#000000;}
</style>
<path class="black"  d=" M4,4h1v1h-1z M5,4h1v1h-1z M6,4h1v1h-1z M7,4h1v1h-1z M8,4h1v1h-1z M9,4h1v1h-1z M10,4h1v1h-1z M13,4h1v1h-1z M18,4h1v1h-1z M19,4h1v1h-1z M20,4h1v1h-1z M22,4h1v1h-1z M23,4h1v1h-1z M24,4h1v1h-1z M25,4h1v1h-1z M27,4h1v1h-1z M30,4h1v1h-1z M31,4h1v1h-1z M32,4h1v1h-1z M33,4h1v1h-1z M34,4h1v1h-1z M35,4h1v1h-1z M36,4h1v1h-1z M4,5h1v1h-1z M10,5h1v1h-1z M12,5h1v1h-1z M13,5h1v1h-1z M15,5h1v1h-1z M16,5h1v1h-1z M17,5h1v1h-1z M21,5h1v1h-1z M22,5h1v1h-1z M24,5h1v1h-1z M27,5h1v1h-1z M28,5h1v1h-1z M30,5h1v1h-1z M36,5h1v1h-1z M4,6h1v1h-1z M6,6h1v1h-1z M7,6h1v1h-1z M8,6h1v1h-1z M10,6h1v1h-1z M13,6h1v1h-1z M14,6h1v1h-1z M15,6h1v1h-1z M17,6h1v1h-1z M18,6h1v1h-1z M21,6h1v1h-1z M22,6h1v1h-1z M23,6h1v1h-1z M26,6h1v1h-1z M27,6h1v1h-1z M30,6h1v1h-1z M32,6h1v1h-1z M33,6h1v1h-1z M34,6h1v1h-1z M36,6h1v1h-1z M4,7h1v1h-1z M6,7h1v1h-1z M7,7h1v1h-1z M8,7h1v1h-1z M10,7h1v1h-1z M12,7h1v1h-1z M13,7h1v1h-1z M15,7h1v1h-1z M19,7h1v1h-1z M20,7h1v1h-1z M24,7h1v1h-1z M26,7h1v1h-1z M30,7h1v1h-1z M32,7h1v1h-1z M33,7h1v1h-1z M34,7h1v1h-1z M36,7h1v1h-1z M4,8h1v1h-1z M6,8h1v1h-1z M7,8h1v1h-1z M8,8h1v1h-1z M10,8h1v1h-1z M14,8h1v1h-1z M16,8h1v1h-1z M18,8h1v1h-1z M19,8h1v1h-1z M20,8h1v1h-1z M24,8h1v1h-1z M25,8h1v1h-1z M26,8h1v1h-1z M28,8h1v1h-1z M30,8h1v1h-1z M32,8h1v1h-1z M33,8h1v1h-1z M34,8h1v1h-1z M36,8h1v1h-1z M4,9h1v1h-1z M10,9h1v1h-1z M12,9h1v1h-1z M14,9h1v1h-1z M17,9h1v1h-1z M18,9h1v1h-1z M19,9h1v1h-1z M20,9h1v1h-1z M21,9h1v1h-1z M22,9h1v1h-1z M24,9h1v1h-1z M26,9h1v1h-1z M27,9h1v1h-1z M28,9h1v1h-1z M30,9h1v1h-1z M36,9h1v1h-1z M4,10h1v1h-1z M5,10h1v1h-1z M6,10h1v1h-1z M7,10h1v1h-1z M8,10h1v1h-1z M9,10h1v1h-1z M10,10h1v1h-1z M12,10h1v1h-1z M14,10h1v1h-1z M16,10h1v1h-1z M18,10h1v1h-1z M20,10h1v1h-1z M22,10h1v1h-1z M24,10h1v1h-1z M26,10h1v1h-1z M28,10h1v1h-1z M30,10h1v1h-1z M31,10h1v1h-1z M32,10h1v1h-1z M33,10h1v1h-1z M34,10h1v1h-1z M35,10h1v1h-1z M36,10h1v1h-1z M16,11h1v1h-1z M23,11h1v1h-1z M25,11h1v1h-1z M27,11h1v1h-1z M4,12h1v1h-1z M5,12h1v1h-1z M6,12h1v1h-1z M7,12h1v1h-1z M8,12h1v1h-1z M10,12h1v1h-1z M11,12h1v1h-1z M12,12h1v1h-1z M13,12h1v1h-1z M14,12h1v1h-1z M16,12h1v1h-1z M17,12h1v1h-1z M19,12h1v1h-1z M20,12h1v1h-1z M22,12h1v1h-1z M24,12h1v1h-1z M26,12h1v1h-1z M29,12h1v1h-1z M31,12h1v1h-1z M33,12h1v1h-1z M35,12h1v1h-1z M5,13h1v1h-1z M13,13h1v1h-1z M19,13h1v1h-1z M20,13h1v1h-1z M22,13h1v1h-1z M25,13h1v1h-1z M26,13h1v1h-1z M27,13h1v1h-1z M29,13h1v1h-1z M30,13h1v1h-1z M32,13h1v1h-1z M33,13h1v1h-1z M34,13h1v1h-1z M5,14h1v1h-1z M6,14h1v1h-1z M8,14h1v1h-1z M9,14h1v1h-1z M10,14h1v1h-1z M12,14h1v1h-1z M13,14h1v1h-1z M15,14h1v1h-1z M16,14h1v1h-1z M17,14h1v1h-1z M19,14h1v1h-1z M21,14h1v1h-1z M23,14h1v1h-1z M24,14h1v1h-1z M26,14h1v1h-1z M27,14h1v1h-1z M28,14h1v1h-1z M29,14h1v1h-1z M31,14h1v1h-1z M32,14h1v1h-1z M33,14h1v1h-1z M35,14h1v1h-1z M11,15h1v1h-1z M13,15h1v1h-1z M14,15h1v1h-1z M15,15h1v1h-1z M17,15h1v1h-1z M18,15h1v1h-1z M20,15h1v1h-1z M22,15h1v1h-1z M23,15h1v1h-1z M25,15h1v1h-1z M27,15h1v1h-1z M29,15h1v1h-1z M30,15h1v1h-1z M34,15h1v1h-1z M35,15h1v1h-1z M36,15h1v1h-1z M5,16h1v1h-1z M7,16h1v1h-1z M9,16h1v1h-1z M10,16h1v1h-1z M13,16h1v1h-1z M15,16h1v1h-1z M16,16h1v1h-1z M19,16h1v1h-1z M20,16h1v1h-1z M21,16h1v1h-1z M22,16h1v1h-1z M24,16h1v1h-1z M25,16h1v1h-1z M28,16h1v1h-1z M31,16h1v1h-1z M34,16h1v1h-1z M35,16h1v1h-1z M4,17h1v1h-1z M6,17h1v1h-1z M8,17h1v1h-1z M11,17h1v1h-1z M14,17h1v1h-1z M16,17h1v1h-1z M18,17h1v1h-1z M19,17h1v1h-1z M23,17h1v1h-1z M25,17h1v1h-1z M26,17h1v1h-1z M27,17h1v1h-1z M28,17h1v1h-1z M29,17h1v1h-1z M30,17h1v1h-1z M31,17h1v1h-1z M32,17h1v1h-1z M34,17h1v1h-1z M6,18h1v1h-1z M8,18h1v1h-1z M10,18h1v1h-1z M11,18h1v1h-1z M12,18h1v1h-1z M13,18h1v1h-1z M16,18h1v1h-1z M17,18h1v1h-1z M19,18h1v1h-1z M20,18h1v1h-1z M21,18h1v1h-1z M22,18h1v1h-1z M24,18h1v1h-1z M26,18h1v1h-1z M27,18h1v1h-1z M28,18h1v1h-1z M29,18h1v1h-1z M31,18h1v1h-1z M32,18h1v1h-1z M33,18h1v1h-1z M35,18h1v1h-1z M5,19h1v1h-1z M6,19h1v1h-1z M14,19h1v1h-1z M16,19h1v1h-1z M18,19h1v1h-1z M23,19h1v1h-1z M27,19h1v1h-1z M29,19h1v1h-1z M30,19h1v1h-1z M35,19h1v1h-1z M36,19h1v1h-1z M5,20h1v1h-1z M6,20h1v1h-1z M9,20h1v1h-1z M10,20h1v1h-1z M11,20h1v1h-1z M12,20h1v1h-1z M14,20h1v1h-1z M16,20h1v1h-1z M17,20h1v1h-1z M18,20h1v1h-1z M19,20h1v1h-1z M25,20h1v1h-1z M26,20h1v1h-1z M29,20h1v1h-1z M31,20h1v1h-1z M35,20h1v1h-1z M5,21h1v1h-1z M6,21h1v1h-1z M7,21h1v1h-1z M8,21h1v1h-1z M12,21h1v1h-1z M15,21h1v1h-1z M23,21h1v1h-1z M25,21h1v1h-1z M26,21h1v1h-1z M27,21h1v1h-1z M32,21h1v1h-1z M34,21h1v1h-1z M4,22h1v1h-1z M7,22h1v1h-1z M8,22h1v1h-1z M9,22h1v1h-1z M10,22h1v1h-1z M11,22h1v1h-1z M14,22h1v1h-1z M17,22h1v1h-1z M19,22h1v1h-1z M21,22h1v1h-1z M22,22h1v1h-1z M24,22h1v1h-1z M26,22h1v1h-1z M27,22h1v1h-1z M28,22h1v1h-1z M31,22h1v1h-1z M32,22h1v1h-1z M36,22h1v1h-1z M6,23h1v1h-1z M7,23h1v1h-1z M8,23h1v1h-1z M9,23h1v1h-1z M11,23h1v1h-1z M14,23h1v1h-1z M15,23h1v1h-1z M16,23h1v1h-1z M17,23h1v1h-1z M18,23h1v1h-1z M20,23h1v1h-1z M23,23h1v1h-1z M25,23h1v1h-1z M27,23h1v1h-1z M28,23h1v1h-1z M29,23h1v1h-1z M30,23h1v1h-1z M33,23h1v1h-1z M36,23h1v1h-1z M4,24h1v1h-1z M5,24h1v1h-1z M8,24h1v1h-1z M10,24h1v1h-1z M11,24h1v1h-1z M13,24h1v1h-1z M19,24h1v1h-1z M20,24h1v1h-1z M21,24h1v1h-1z M22,24h1v1h-1z M24,24h1v1h-1z M25,24h1v1h-1z M26,24h1v1h-1z M28,24h1v1h-1z M30,24h1v1h-1z M33,24h1v1h-1z M35,24h1v1h-1z M4,25h1v1h-1z M5,25h1v1h-1z M6,25h1v1h-1z M9,25h1v1h-1z M11,25h1v1h-1z M12,25h1v1h-1z M13,25h1v1h-1z M16,25h1v1h-1z M19,25h1v1h-1z M20,25h1v1h-1z M25,25h1v1h-1z M26,25h1v1h-1z M28,25h1v1h-1z M30,25h1v1h-1z M31,25h1v1h-1z M34,25h1v1h-1z M36,25h1v1h-1z M4,26h1v1h-1z M7,26h1v1h-1z M9,26h1v1h-1z M10,26h1v1h-1z M12,26h1v1h-1z M15,26h1v1h-1z M17,26h1v1h-1z M21,26h1v1h-1z M22,26h1v1h-1z M24,26h1v1h-1z M25,26h1v1h-1z M26,26h1v1h-1z M31,26h1v1h-1z M32,26h1v1h-1z M35,26h1v1h-1z M4,27h1v1h-1z M9,27h1v1h-1z M11,27h1v1h-1z M14,27h1v1h-1z M15,27h1v1h-1z M16,27h1v1h-1z M18,27h1v1h-1z M21,27h1v1h-1z M22,27h1v1h-1z M23,27h1v1h-1z M27,27h1v1h-1z M28,27h1v1h-1z M29,27h1v1h-1z M30,27h1v1h-1z M33,27h1v1h-1z M4,28h1v1h-1z M6,28h1v1h-1z M7,28h1v1h-1z M10,28h1v1h-1z M11,28h1v1h-1z M14,28h1v1h-1z M19,28h1v1h-1z M24,28h1v1h-1z M25,28h1v1h-1z M28,28h1v1h-1z M29,28h1v1h-1z M30,28h1v1h-1z M31,28h1v1h-1z M32,28h1v1h-1z M33,28h1v1h-1z M35,28h1v1h-1z M12,29h1v1h-1z M14,29h1v1h-1z M15,29h1v1h-1z M16,29h1v1h-1z M18,29h1v1h-1z M25,29h1v1h-1z M26,29h1v1h-1z M28,29h1v1h-1z M32,29h1v1h-1z M33,29h1v1h-1z M34,29h1v1h-1z M4,30h1v1h-1z M5,30h1v1h-1z M6,30h1v1h-1z M7,30h1v1h-1z M8,30h1v1h-1z M9,30h1v1h-1z M10,30h1v1h-1z M12,30h1v1h-1z M13,30h1v1h-1z M17,30h1v1h-1z M18,30h1v1h-1z M19,30h1v1h-1z M20,30h1v1h-1z M21,30h1v1h-1z M22,30h1v1h-1z M26,30h1v1h-1z M28,30h1v1h-1z M30,30h1v1h-1z M32,30h1v1h-1z M35,30h1v1h-1z M4,31h1v1h-1z M10,31h1v1h-1z M14,31h1v1h-1z M15,31h1v1h-1z M16,31h1v1h-1z M23,31h1v1h-1z M24,31h1v1h-1z M25,31h1v1h-1z M28,31h1v1h-1z M32,31h1v1h-1z M33,31h1v1h-1z M36,31h1v1h-1z M4,32h1v1h-1z M6,32h1v1h-1z M7,32h1v1h-1z M8,32h1v1h-1z M10,32h1v1h-1z M12,32h1v1h-1z M16,32h1v1h-1z M17,32h1v1h-1z M19,32h1v1h-1z M20,32h1v1h-1z M25,32h1v1h-1z M26,32h1v1h-1z M27,32h1v1h-1z M28,32h1v1h-1z M29,32h1v1h-1z M30,32h1v1h-1z M31,32h1v1h-1z M32,32h1v1h-1z M34,32h1v1h-1z M36,32h1v1h-1z M4,33h1v1h-1z M6,33h1v1h-1z M7,33h1v1h-1z M8,33h1v1h-1z M10,33h1v1h-1z M12,33h1v1h-1z M13,33h1v1h-1z M15,33h1v1h-1z M16,33h1v1h-1z M19,33h1v1h-1z M20,33h1v1h-1z M22,33h1v1h-1z M23,33h1v1h-1z M25,33h1v1h-1z M27,33h1v1h-1z M30,33h1v1h-1z M32,33h1v1h-1z M33,33h1v1h-1z M34,33h1v1h-1z M35,33h1v1h-1z M4,34h1v1h-1z M6,34h1v1h-1z M7,34h1v1h-1z M8,34h1v1h-1z M10,34h1v1h-1z M12,34h1v1h-1z M13,34h1v1h-1z M14,34h1v1h-1z M16,34h1v1h-1z M17,34h1v1h-1z M19,34h1v1h-1z M20,34h1v1h-1z M21,34h1v1h-1z M22,34h1v1h-1z M24,34h1v1h-1z M28,34h1v1h-1z M31,34h1v1h-1z M4,35h1v1h-1z M10,35h1v1h-1z M12,35h1v1h-1z M13,35h1v1h-1z M15,35h1v1h-1z M17,35h1v1h-1z M18,35h1v1h-1z M23,35h1v1h-1z M26,35h1v1h-1z M28,35h1v1h-1z M31,35h1v1h-1z M32,35h1v1h-1z M33,35h1v1h-1z M35,35h1v1h-1z M36,35h1v1h-1z M4,36h1v1h-1z M5,36h1v1h-1z M6,36h1v1h-1z M7,36h1v1h-1z M8,36h1v1h-1z M9,36h1v1h-1z M10,36h1v1h-1z M12,36h1v1h-1z M13,36h1v1h-1z M14,36h1v1h-1z M16,36h1v1h-1z M19,36h1v1h-1z M24,36h1v1h-1z M25,36h1v1h-1z M26,36h1v1h-1z M28,36h1v1h-1z M29,36h1v1h-1z M30,36h1v1h-1z M33,36h1v1h-1z M35,36h1v1h-1z"/>
</svg>
'''

        expect:
        mockMvc.perform(get('/qr/2a123956-0c53-4452-b1e5-9b9681b8b396/join.svg'))
                .andExpect(content().string(expected))
                .andExpect(content().contentType("image/svg+xml;charset=UTF-8"))
    }
}