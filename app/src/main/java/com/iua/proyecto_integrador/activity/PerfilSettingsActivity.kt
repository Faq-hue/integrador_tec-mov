package com.iua.proyecto_integrador.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.databinding.ActivityPerfilSettingsBinding
import com.iua.proyecto_integrador.proyecto_integradorAplication.Companion.prefs

class PerfilSettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilSettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(prefs.getProfileImage() != ""){

            binding.profileImage.setImageURI(Uri.parse(prefs.getProfileImage()))

        }

        binding.savePerfilSettingsButton.setOnClickListener {

            if (binding.emailET.text.toString().isNotEmpty() && binding.userName.text.toString().isNotEmpty()){

                prefs.saveEmail(binding.emailET.text.toString())
                prefs.saveNombre(binding.userName.text.toString())

                Toast.makeText(this, "Saved changes!", Toast.LENGTH_LONG).show()
            }

            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)

        }

        binding.backButton.setOnClickListener {

            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)

        }

        binding.changePasswordButton.setOnClickListener {

            val intent = Intent(this, CambiarContraseniaActivity::class.java)
            startActivity(intent)

        }

        binding.profileImage.setOnClickListener {

            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }

    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                val imageBitmap = intent?.extras?.get("data") as Bitmap
                val imageView = findViewById<ImageView>(R.id.profileImage)
                imageView.setImageBitmap(imageBitmap)

                val path = MediaStore.Images.Media.insertImage(contentResolver, imageBitmap, "Title", null)

                prefs.saveProfileImage(path)
            }
        }


}