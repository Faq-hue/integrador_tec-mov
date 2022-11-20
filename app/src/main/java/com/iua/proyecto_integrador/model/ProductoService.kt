package com.iua.proyecto_integrador.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductoService {

    @GET("v1/")
    fun listaProductos(@Query("apiKey") apiKey: String): Call<ProductoListado>

}