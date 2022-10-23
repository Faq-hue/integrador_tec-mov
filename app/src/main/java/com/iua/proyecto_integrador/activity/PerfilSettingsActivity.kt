package com.iua.proyecto_integrador.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.databinding.ActivityPerfilSettingsBinding

class PerfilSettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilSettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.savePerfilSettingsButton.setOnClickListener {

            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Saved changes!", Toast.LENGTH_LONG).show()

        }

        binding.backButton.setOnClickListener {

            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)

        }

        binding.changePasswordButton.setOnClickListener {

            val intent = Intent(this, CambiarContraseniaActivity::class.java)
            startActivity(intent)

        }

    }
}