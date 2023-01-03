package com.iua.proyecto_integrador.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDataBase(context: Context) : SQLiteOpenHelper(context,"dataBase.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        db!!.execSQL("CREATE TABLE compras (id INTEGER PRIMARY KEY, producto TEXT, precio DOUBLE, user TEXT)")

        db!!.execSQL("CREATE TABLE historial (id INTEGER PRIMARY KEY AUTOINCREMENT, producto TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        //db!!.execSQL("DROP TABLE IF EXISTS historial")
        //onCreate(db)

    }
    //TODO quizas deberia agregar una columna de "COMPRA REALIZADA"
    fun addDatosCompra(id: Int, productoNombre: String, precio: String, user: String){

        val datos = ContentValues()
        datos.put("producto", id)
        datos.put("producto", productoNombre)
        datos.put("precio", precio)
        datos.put("user", user)

        val db = this.writableDatabase

        db.insert("compras", null, datos)

        db.close()

    }

    fun getDatosCompra(): Int {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT LAST(id) FROM compras", null)

        return cursor.getInt(0)
    }

    fun addDatosHistorial(productoNombre: String){

        val datos = ContentValues()

        datos.put("producto", productoNombre)

        val db = this.writableDatabase

        db.insert("historial", null, datos)

        db.close()

    }
}