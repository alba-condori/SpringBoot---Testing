package com.example.testing.service

import com.example.testing.model.Item

class OrdenDeCompra {
    private val items = mutableListOf<Item>()

    fun agregarItem(item: Item){
        items.add(item)
    }
    fun calcularTotal(): Int {
        return items.sumOf { it.precio }
    }
}