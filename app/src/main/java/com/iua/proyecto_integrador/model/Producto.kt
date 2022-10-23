package com.iua.proyecto_integrador.model

data class Producto (
    val nombre: String? = null,
    val precio: Long = 0,
    val disponible: Int = 0,
    val imagen: Int = 0
)

object listaProducto{

    val data get() = listOf<Producto>(
    Producto("Producto1", 100, 1, 0),
        Producto("Producto2", 200, 2, 0),
        Producto("Producto3", 300, 3, 0),
        Producto("Producto4", 400, 4, 0),
        Producto("Producto5", 500, 5, 0),
        Producto("Producto6", 600, 6, 0),
        Producto("Producto7", 700, 7, 0),
        Producto("Producto8", 800, 8, 0),
        Producto("Producto9", 900, 9, 0),
        Producto("Producto10", 1000, 10, 0),
        Producto("Producto11", 1100, 11, 0),
        Producto("Producto12", 1200, 12, 0),
        Producto("Producto13", 1300, 13, 0),
        Producto("Producto14", 1400, 14, 0),
        Producto("Producto15", 1500, 15, 0),
        Producto("Producto16", 1600, 16, 0),
        Producto("Producto17", 1700, 17, 0),
        Producto("Producto18", 1800, 18, 0),
        Producto("Producto19", 1900, 19, 0),
        Producto("Producto20", 2000, 20, 0)



)



}