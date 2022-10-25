package com.iua.proyecto_integrador.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.adapter.CarritoAdapter
import com.iua.proyecto_integrador.databinding.ActivityHistorialBinding
import com.iua.proyecto_integrador.model.ProductoCarrito


class HistorialActivity : AppCompatActivity() {

    private lateinit var adapter: CarritoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var carritoArrayList: ArrayList<ProductoCarrito>
    private lateinit var binding: ActivityHistorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistorialBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backButton.setOnClickListener{
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }

        dataInitialize()

        val layoutManager = LinearLayoutManager(this)
        recyclerView = view.findViewById(R.id.recyclerViewCarrito)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CarritoAdapter(carritoArrayList)
        recyclerView.adapter = adapter


    }


    private fun dataInitialize(){
        carritoArrayList = arrayListOf(
            ProductoCarrito("Producto 1", 20.0, 2),
            ProductoCarrito("Producto 2", 30.0, 4),
            ProductoCarrito("Producto 3", 40.0, 6),
            ProductoCarrito("Producto 43", 50.0, 9),
            ProductoCarrito("Producto 13", 20.0, 2),
            ProductoCarrito("Producto 32", 30.0, 4),
            ProductoCarrito("Producto 33", 40.0, 6),
            ProductoCarrito("Producto 43", 50.0, 9),
            ProductoCarrito("Producto 12", 20.0, 2),
            ProductoCarrito("Producto 21", 30.0, 4),
            ProductoCarrito("Producto 31", 40.0, 6),
            ProductoCarrito("Producto 45", 50.0, 9),
        )
    }

}