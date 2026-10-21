package com.example.testing.controller

import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraDeDescuentosIntegrationTest(
    private val navegador: MockMvc
) : BehaviorSpec({

    Given("la aplicación cargada completamente con sus servicios reales") {

        And("un usuario '123' configurado en el sistema con 25% de descuento") {

            When("se hace una consulta GET /api/descuentos?userID=123&monto=100.0") {
                val respuesta =
                    navegador.perform(
                        get("/api/descuentos")
                            .param("userID", "123")
                            .param("monto", "100.0"),
                    )

                Then("deberia obtener respuesta con estado ok") {
                    respuesta.andExpect(status().isOk)
                }

                And("el monto final devuelto por la lógica real debe ser de 75.0") {
                    respuesta.andExpect(jsonPath("$.montoFinal").value(75.0))
                }
            }
        }
    }
})