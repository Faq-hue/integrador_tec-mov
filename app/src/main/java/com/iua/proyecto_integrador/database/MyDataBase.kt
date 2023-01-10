package com.iua.proyecto_integrador.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.log

class MyDataBase(context: Context) : SQLiteOpenHelper(context,"dataBase.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        db!!.execSQL("CREATE TABLE compras (id INTEGER PRIMARY KEY, producto TEXT, precio DOUBLE,comprado BOOLEAN, user TEXT)")

        db!!.execSQL("CREATE TABLE historial (id INTEGER PRIMARY KEY AUTOINCREMENT, producto TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        //db!!.execSQL("DROP TABLE IF EXISTS historial")
        //onCreate(db)

    }

    fun addDatosCompra(id: Int, productoNombre: String, precio: String, comprado: Boolean, user: String){

        val datos = ContentValues()
        datos.put("producto", id)
        datos.put("producto", productoNombre)
        datos.put("precio", precio)
        datos.put("user", user)
        datos.put("comprado", comprado)

        val db = this.writableDatabase

        db.insert("compras", null, datos)

        db.close()

    }

    fun getDatosCompra(): Cursor {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM compras ORDER BY id DESC LIMIT 1", null)

        //Log.e("NUMERO DEL CURSOR",cursor.getInt(0).toString())
        //Se cierra aca el cursor?
        return cursor
    }

    fun updateDatosCompra(i: Int): Boolean{

        try {

            val db = this.readableDatabase

            var cv: ContentValues = ContentValues()

            cv.put("comprado", true)

            Log.e("A VER SI LLEGAMOS HASTA ACA", cv.toString())
            Log.e("id", i.toString())


            db.update("compras", cv, "comprado=0 AND id="+i,null)

            return true
        }catch (e:java.lang.Error){

            Log.e("Error en updateDatosCompra:", e.toString())

            return false
        }
    }

    fun addDatosHistorial(productoNombre: String){

        val datos = ContentValues()

        datos.put("producto", productoNombre)

        val db = this.writableDatabase

        db.insert("historial", null, datos)

        db.close()

    }
}