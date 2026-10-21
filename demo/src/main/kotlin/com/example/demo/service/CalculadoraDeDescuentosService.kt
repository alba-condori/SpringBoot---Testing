package com.example.demo.service

import org.springframework.stereotype.Service

@Service
class CalculadoraDeDescuentosService {

    fun aplicarDescuentosSegunUsuario(userID: String, monto: Double): Double {
        return monto * 0.75
    }
}