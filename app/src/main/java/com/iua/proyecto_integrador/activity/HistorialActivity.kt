package com.iua.proyecto_integrador.activity

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.adapter.CarritoAdapter
import com.iua.proyecto_integrador.adapter.HistorialAdapter
import com.iua.proyecto_integrador.database.MyDataBase
import com.iua.proyecto_integrador.databinding.ActivityHistorialBinding
import com.iua.proyecto_integrador.model.ProductoCarrito


class HistorialActivity : AppCompatActivity() {

    private lateinit var adapter: HistorialAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var historialArrayList: ArrayList<String>
    private lateinit var binding: ActivityHistorialBinding
    private  lateinit var historialDBHelper: MyDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistorialBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backButton.setOnClickListener{
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }

        historialDBHelper = MyDataBase(this)

        dataInizialize()

        val layoutManager = LinearLayoutManager(this)
        recyclerView = view.findViewById(R.id.recyclerViewCarrito)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = HistorialAdapter(historialArrayList)
        recyclerView.adapter = adapter


    }

    private fun dataInizialize(){

        historialArrayList = arrayListOf()


        val db: SQLiteDatabase = historialDBHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM historial", null)

        if(cursor.moveToFirst()){

            do{
                historialArrayList.add(cursor.getString(1))

            }while (cursor.moveToNext())

        }

        Log.d("ARRAY LIST", historialArrayList.size.toString())

    }



}