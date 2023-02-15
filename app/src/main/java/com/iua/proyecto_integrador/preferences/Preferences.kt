package com.iua.proyecto_integrador.preferences

import android.content.Context

class Preferences(val context: Context) {

    var SHARED_DB = "DataBase"
    var SHARED_USER_NAME = "username"
    var SHARED_PASSWORD = "123"
    var SHARED_EMAIL = "usermail@gmail.com"
    var SHARED_BUYS: Int = 1

    val storage = context.getSharedPreferences(SHARED_DB, 0)

    fun saveNombre(nombre: String){
        storage.edit().putString(SHARED_USER_NAME, nombre).apply()
    }

    fun getNombre(): String{
        return storage.getString(SHARED_USER_NAME, "")!!
    }

    fun savePassword(password: String){
        storage.edit().putString(SHARED_PASSWORD, password).apply()
    }

    fun getPassword(): String{
        return storage.getString(SHARED_PASSWORD, "")!!
    }

    fun saveEmail(email: String){
        storage.edit().putString(SHARED_EMAIL, email).apply()
    }

    fun getEmail(): String{
        return storage.getString(SHARED_EMAIL, "")!!
    }

    fun saveBuy(buy: Int){
        storage.edit().putInt(SHARED_BUYS.toString(),buy).apply()
    }

    fun getBuy(): Int{
        return storage.getInt("", SHARED_BUYS)
    }

}