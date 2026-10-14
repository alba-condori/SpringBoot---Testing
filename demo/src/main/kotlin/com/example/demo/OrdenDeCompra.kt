package com.example.demo

class OrdenDeCompra {
    private val items = mutableListOf<Item>()

    fun agregarItem(item: Item){
        items.add(item)
    }
    fun calcularTotal(): Int {
        return items.sumOf { it.precio }
    }
}