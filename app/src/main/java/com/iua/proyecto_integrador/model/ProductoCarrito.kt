package com.iua.proyecto_integrador.model

data class ProductoCarrito(
    var nombre: String? = null,
    var precio: Double = 0.0,
    val cantidadComprada: Int = 0,
)