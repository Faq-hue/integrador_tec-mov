package com.iua.proyecto_integrador.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.databinding.ActivityPerfilBinding

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.editUserButton.setOnClickListener {

            val intent = Intent(this, PerfilSettingsActivity::class.java)
            startActivity(intent)

        }

        binding.backButton.setOnClickListener {
            //TODO debe hacerce el intent de volver a todas las pantallas que pueden acceder al perfil
            //val intent = Intent(this, )

        }

    }
}