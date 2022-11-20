package com.iua.proyecto_integrador.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductoClient {

    private val retrofit = Retrofit.Builder().baseUrl("https://mocki.io/").addConverterFactory(GsonConverterFactory.create()).build()

    val service = retrofit.create(ProductoService::class.java)

}