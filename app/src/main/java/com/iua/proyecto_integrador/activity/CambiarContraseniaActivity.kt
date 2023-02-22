package com.iua.proyecto_integrador.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iua.proyecto_integrador.databinding.ActivityCambiarContraseniaBinding

class CambiarContraseniaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCambiarContraseniaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCambiarContraseniaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backButton.setOnClickListener {

            val intent = Intent(this, PerfilSettingsActivity::class.java)
            startActivity(intent)

        }

        binding.applyChangesPass.setOnClickListener {

            Toast.makeText(this, "Saved changes!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, PerfilSettingsActivity::class.java)
            startActivity(intent)

        }


    }
}