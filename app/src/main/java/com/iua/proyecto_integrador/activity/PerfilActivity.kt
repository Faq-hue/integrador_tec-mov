package com.iua.proyecto_integrador.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        Log.d("nombre", prefs.getNombre())
        Log.d("email", prefs.getEmail())

        binding.userName.text = prefs.getNombre()
        binding.email.text = prefs.getEmail()

        binding.editUserButton.setOnClickListener {

            val intent = Intent(this, PerfilSettingsActivity::class.java)
            startActivity(intent)

        }

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainFragActivity::class.java)
            startActivity(intent)
        }

        binding.shoppingHistoryButton.setOnClickListener {
            val intent = Intent(this, HistorialActivity::class.java)
            startActivity(intent)

        }

    }
}