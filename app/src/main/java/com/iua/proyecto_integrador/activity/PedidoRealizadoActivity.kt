package com.iua.proyecto_integrador.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iua.proyecto_integrador.databinding.ActivityPedidoRealizadoBinding

class PedidoRealizadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPedidoRealizadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPedidoRealizadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.thanksButton.setOnClickListener {

            val intent = Intent(this, ListadoActivity::class.java)
            startActivity(intent)

        }

    }
}