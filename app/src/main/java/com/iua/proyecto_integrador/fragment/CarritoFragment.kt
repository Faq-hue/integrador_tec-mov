package com.iua.proyecto_integrador.fragment

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
import com.iua.proyecto_integrador.adapter.CarritoAdapter
import com.iua.proyecto_integrador.model.ProductoCarrito

class CarritoFragment : Fragment() {

    private lateinit var buyButton: Button
    private lateinit var adapter: CarritoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var carritoArrayList: ArrayList<ProductoCarrito>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_carrito, container, false)
        buyButton = view.findViewById(R.id.buyButton)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerViewCarrito)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CarritoAdapter(carritoArrayList)
        recyclerView.adapter = adapter

        buyButton.setOnClickListener {
            findNavController().navigate(R.id.action_carritoFragment_to_pedidoRealizadoFragment)
        }

    }

    private fun dataInitialize(){
        carritoArrayList = arrayListOf(
            ProductoCarrito("Producto 1", 20.0, 2),
            ProductoCarrito("Producto 2", 30.0, 4),
            ProductoCarrito("Producto 3", 40.0, 6),
            ProductoCarrito("Producto 4", 50.0, 9),
        )
    }
}