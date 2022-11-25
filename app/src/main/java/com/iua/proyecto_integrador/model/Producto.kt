package com.iua.proyecto_integrador.model

data class Producto(
    val nombre: String,
    val precio: String,
    val disponible: Boolean,
    val vendedor: String,
    val ubicacion: String,
    val imagen: String,
    val descripcion: String
)