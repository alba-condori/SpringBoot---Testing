package com.example.testing.controller

import com.example.testing.dto.DescuentoResponseDto
import com.example.testing.service.CalculadoraDeDescuentos
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/descuentos")
class CalculadoraDeDescuentosController(
    private val calculadora: CalculadoraDeDescuentos
) {

    @GetMapping
    fun calcularDescuento(
        @RequestParam("userID") userID: String,
        @RequestParam("monto") monto: Double
    ): ResponseEntity<DescuentoResponseDto> {
        val montoConDescuento = calculadora.aplicarDescuentosSegunUsuario(userID, monto)
        val respuesta = DescuentoResponseDto(montoFinal = montoConDescuento)
        return ResponseEntity.ok(respuesta)
    }
}