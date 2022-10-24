package com.iua.proyecto_integrador.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iua.proyecto_integrador.databinding.ActivityLoginBinding
import com.iua.proyecto_integrador.databinding.ActivityRegistroUsuarioBinding

class RegisterActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRegistroUsuarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*binding.register.setOnClickListener{

            val intent = Intent(this, ListadoActivity::class.java)
            startActivity(intent)

        }*/

        binding.backButton.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }
}