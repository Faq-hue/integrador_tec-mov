package com.iua.proyecto_integrador.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.databinding.ActivityMainFragBinding

class MainFragActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainFragBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainFragBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.perfilButton.setOnClickListener{

            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)

        }

    }
}