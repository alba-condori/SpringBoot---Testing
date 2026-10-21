package com.example.demo.controller

import com.example.demo.service.CalculadoraDeDescuentosService
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(CalculadoraDeDescuentosController::class)
class CalculadoraDeDescuentosControllerTest(
    private val navegador: MockMvc,
    @MockkBean private val calculadora: CalculadoraDeDescuentosService,
) : BehaviorSpec({

    Given("un endpoint para calcular descuentos /api/descuentos") {
        And("un usuario 123 al cual se le aplica un descuento del 25% sin importar el monto") {

            every {
                calculadora.aplicarDescuentosSegunUsuario("123", 100.0)
            } returns 75.0

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

                And("un campo para el final de la compra que deberia ser de 75.0") {
                    respuesta.andExpect(jsonPath("$.montoFinal").value(75.0))
                }
            }
        }
    }
})