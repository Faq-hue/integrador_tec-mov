package com.iua.proyecto_integrador.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iua.proyecto_integrador.databinding.ActivityOlvidoContraseniaBinding

class OlvidoContraseniaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOlvidoContraseniaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOlvidoContraseniaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.sendMailButton.setOnClickListener {
            Toast.makeText(this, "Email sent", Toast.LENGTH_SHORT).show()
        }

    }
}