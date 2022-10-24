package com.iua.proyecto_integrador.model

data class Carrito (
    val usuario: String? = null,
    val total: Double = 0.0,
    var listaProductoCarrito: List<ProductoComprado>
)

data class ProductoComprado(
    val nombre: String? = null,
    val precio: Long = 0,
    val cantidadComprada: Int = 0
)