package com.iua.proyecto_integrador.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentProvider
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContentProviderCompat.requireContext
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.databinding.ActivityPerfilBinding
import com.iua.proyecto_integrador.proyecto_integradorAplication.Companion.prefs

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.userName.text = prefs.getNombre()
        binding.email.text = prefs.getEmail()

        if(prefs.getProfileImage() != ""){
            binding.perfilImage.setImageURI(Uri.parse(prefs.getProfileImage()))
        }else{
            notificacion()
            canal()
        }

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainFragActivity::class.java)
            startActivity(intent)
        }

        binding.shoppingHistoryButton.setOnClickListener {
            val intent = Intent(this, HistorialActivity::class.java)
            startActivity(intent)

        }

        binding.opcionesHuella.setOnClickListener {
            val intent = Intent(this, FingerprintActivity::class.java)
            startActivity(intent)
        }

    }

    private fun notificacion(){
        val builder = NotificationCompat.Builder(this, "1")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Capybara")
            .setContentText("Change your profile picture")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notify(1, builder.build())
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun canal(){
        val name = "Capybara"
        val descriptionText = "Mamifero"

        val channel = NotificationChannel("1", name, NotificationManager.IMPORTANCE_DEFAULT).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}