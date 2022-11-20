package com.iua.proyecto_integrador.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductoService {

    @GET("v1/ea8fb015-0c3b-459a-8f5a-65b635259ec6")
    fun listaProductos(@Query("apiKey") apiKey: String): Call<ProductoListado>

}