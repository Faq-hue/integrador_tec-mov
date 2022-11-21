package com.iua.proyecto_integrador

import android.app.Application
import com.iua.proyecto_integrador.preferences.Preferences

class proyecto_integradorAplication : Application() {

    companion object{
        lateinit var prefs: Preferences
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Preferences(applicationContext)
    }

}