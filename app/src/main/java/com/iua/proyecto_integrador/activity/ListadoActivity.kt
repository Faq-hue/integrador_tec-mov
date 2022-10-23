package com.iua.proyecto_integrador.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.iua.proyecto_integrador.adapter.ProductoAdapter
import com.iua.proyecto_integrador.databinding.ActivityListadoBinding
import com.iua.proyecto_integrador.model.Producto

class ListadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListadoBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityListadoBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.listado.adapter = ProductoAdapter(
            listOf(
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
        )
    }
}