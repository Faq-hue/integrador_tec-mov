package com.iua.proyecto_integrador.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductoService {

    @GET("v1/a24fbc26-a37a-45ad-8f99-ab5f1c5beabf")
    fun listaProductos(@Query("apiKey") apiKey: String): Call<ProductoListado>

}