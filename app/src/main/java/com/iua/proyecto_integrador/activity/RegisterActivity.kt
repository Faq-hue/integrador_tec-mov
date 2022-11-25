package com.iua.proyecto_integrador.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.databinding.ActivityRegistroUsuarioBinding
import com.iua.proyecto_integrador.proyecto_integradorAplication.Companion.prefs

class RegisterActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRegistroUsuarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.register.setOnClickListener{


            if(binding.passwordET.text.toString() ==  binding.repeatPassword.text.toString()){

                prefs.saveEmail(binding.emailET.text.toString())
                prefs.saveNombre(binding.userName.text.toString())
                prefs.savePassword(binding.passwordET.text.toString())

                val intent = Intent(this, MainFragActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }

        binding.backButton.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }
}