package com.iua.proyecto_integrador.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.adapter.ProductoAdapter
import com.iua.proyecto_integrador.model.Producto

class ListadoFragment : Fragment() {

    private lateinit var nextButton: Button

    private lateinit var adapter: ProductoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var productosArray: ArrayList<Producto>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listado, container, false)
        nextButton = view.findViewById(R.id.buttonNav)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerViewListado)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ProductoAdapter(productosArray)
        recyclerView.adapter = adapter


        nextButton.setOnClickListener{
            findNavController().navigate(R.id.action_listadoFragment_to_detalleProductoFragment)

        }
    }

    private fun dataInitialize() {
        productosArray = arrayListOf(

            Producto("Producto1", 100, 1, 0),
            Producto("Producto2", 200, 2, 0),
            Producto("Producto3", 300, 3, 0),
            Producto("Producto4", 400, 4, 0),
            Producto("Producto5", 500, 5, 0),
            Producto("Producto6", 600, 6, 0),
            Producto("Producto7", 700, 7, 0),
            Producto("Producto8", 800, 8, 0),
            Producto("Producto9", 900, 9, 0),
            Producto("Producto10", 1000, 10, 0),
            Producto("Producto11", 1100, 11, 0),
            Producto("Producto12", 1200, 12, 0),
            Producto("Producto13", 1300, 13, 0),
            Producto("Producto14", 1400, 14, 0),
            Producto("Producto15", 1500, 15, 0),
            Producto("Producto16", 1600, 16, 0),
            Producto("Producto17", 1700, 17, 0),
            Producto("Producto18", 1800, 18, 0),
            Producto("Producto19", 1900, 19, 0),
            Producto("Producto20", 2000, 20, 0)
        )

    }

}

