package com.iua.proyecto_integrador.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iua.proyecto_integrador.databinding.ActivityPerfilBinding
import com.iua.proyecto_integrador.proyecto_integradorAplication.Companion.prefs

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.userName.text = prefs.getNombre()
        binding.email.text = prefs.getEmail()

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainFragActivity::class.java)
            startActivity(intent)
        }

        binding.shoppingHistoryButton.setOnClickListener {
            val intent = Intent(this, HistorialActivity::class.java)
            startActivity(intent)

        }

        binding.opcionesHuella.setOnClickListener {
            val intent = Intent(this, FingerprintActivity::class.java)
            startActivity(intent)
        }

    }
}