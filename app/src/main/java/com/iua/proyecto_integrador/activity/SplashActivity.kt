package com.iua.proyecto_integrador.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.databinding.ActivitySplashBinding
import com.iua.proyecto_integrador.model.ProductoClient
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       /* thread {
            val apiKey = getString(R.string.api_key)
            val listaProductos = ProductoClient.service.listaProductos(apiKey)
            val body = listaProductos.execute().body()

            if (body !=  null)
                Log.d("MainActivity", "Productos count:" + body.size)
        }*/

        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root


        setContentView(view)

        navigateToLogin()
        finish()
    }
    private fun navigateToLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
    }

}