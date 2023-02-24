package com.iua.proyecto_integrador.activity

import android.app.KeyguardManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.iua.proyecto_integrador.databinding.ActivityFingerprintBinding
import java.util.concurrent.Executor

class FingerprintActivity : AppCompatActivity() {

    lateinit var binding: ActivityFingerprintBinding
    lateinit var cb: BiometricPrompt.AuthenticationCallback
    lateinit var ex: Executor
    lateinit var prompt: BiometricPrompt
    var keyguardManager: KeyguardManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFingerprintBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        generarPrompt()

        authBiometrics()
    }


        fun generarPrompt() {

            ex =  ContextCompat.getMainExecutor(this)

            cb = object : BiometricPrompt.AuthenticationCallback() {

            override fun onAuthenticationFailed() {

                super.onAuthenticationFailed()

                startActivity(Intent(this@FingerprintActivity, PerfilActivity::class.java))

                finish()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {

                super.onAuthenticationSucceeded(result)

                startActivity(Intent(this@FingerprintActivity, PerfilSettingsActivity::class.java))

                finish()
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {

                super.onAuthenticationError(errorCode, errString)

                startActivity(Intent(this@FingerprintActivity, PerfilActivity::class.java))

                finish()
            }
        }

        prompt =  BiometricPrompt(this, ex, cb)
    }

    fun authBiometrics() {

        val promptInfo = BiometricPrompt.PromptInfo.Builder().apply {
            setTitle("Enter profile settings")
            setDescription("Place your Carpyfingerprint")
            setNegativeButtonText("Carpycancel")
            setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_WEAK)
        }.build()

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {

            keyguardManager = getSystemService(KEYGUARD_SERVICE) as KeyguardManager

            keyguardManager?.let { manager ->

                if (manager.isKeyguardSecure) {
                    prompt.authenticate(promptInfo)
                }
            }

        } else {

            prompt.authenticate(promptInfo)

        }
    }
}