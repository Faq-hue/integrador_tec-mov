package com.iua.proyecto_integrador.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iua.proyecto_integrador.databinding.ActivityLoginBinding
import com.iua.proyecto_integrador.preferences.Preferences
import com.iua.proyecto_integrador.proyecto_integradorAplication.Companion.prefs

class LoginActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding =ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(prefs.getEmail().isNotEmpty() && prefs.getNombre().isNotEmpty() && prefs.getPassword().isNotEmpty()){
            val intent = Intent(this, MainFragActivity::class.java)
            startActivity(intent)
        }

        binding.forgotPass.setOnClickListener {
            val intent = Intent(this, OlvidoContraseniaActivity::class.java)
            startActivity(intent)
        }

        binding.createAccount.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        binding.loginButton.setOnClickListener {
            if(binding.emailAddressET.toString().isNotEmpty() && binding.passwordET.toString().isNotEmpty()){

                if (prefs.getPassword() ==  binding.passwordET.text.toString() && prefs.getEmail() == binding.emailAddressET.text.toString()){
                    val intent = Intent(this, MainFragActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Contraseña o email incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}