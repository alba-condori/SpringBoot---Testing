package com.example.testing.service

import org.springframework.stereotype.Service

@Service
class CalculadoraDeDescuentos {

    fun aplicarDescuentosSegunUsuario(userID: String, monto: Double): Double {
        return monto * 0.75
    }
}