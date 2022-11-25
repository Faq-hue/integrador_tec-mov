package com.iua.proyecto_integrador.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDataBase(context: Context) : SQLiteOpenHelper(context,"dataBase.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        //db!!.execSQL("CREATE TABLE compras (id INTEGER PRIMARY KEY AUTOINCREMENT, producto TEXT, precio DOUBLE, user TEXT)")

        db!!.execSQL("CREATE TABLE historial (id INTEGER PRIMARY KEY AUTOINCREMENT, producto TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        //db!!.execSQL("DROP TABLE IF EXISTS historial")
        //onCreate(db)

    }

    fun addDatosCompra(productoNombre: String, precio: Double, user: String){

        val datos = ContentValues()
        datos.put("producto", productoNombre)
        datos.put("precio", precio)
        datos.put("user", user)

        val db = this.writableDatabase

        db.insert("compras", null, datos)

        db.close()

    }

    fun addDatosHistorial(productoNombre: String){

        val datos = ContentValues()

        datos.put("producto", productoNombre)

        val db = this.writableDatabase

        db.insert("historial", null, datos)

        db.close()

    }
}