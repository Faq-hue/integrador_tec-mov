package com.iua.proyecto_integrador.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        navigateToLogin()
        finish()
    }
    private fun navigateToLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
    }

}