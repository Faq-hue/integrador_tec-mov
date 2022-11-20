package com.iua.proyecto_integrador.model

data class Producto(
    val descripcion: String,
    val disponible: Boolean,
    val imagen: String,
    val nombre: String,
    val precio: String,
    val ubicacion: String,
    val vendedor: String
)