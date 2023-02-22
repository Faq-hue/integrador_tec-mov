package com.iua.proyecto_integrador.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.databinding.ActivityProductoCarritoBinding
import com.iua.proyecto_integrador.model.ProductoCarrito

class CarritoAdapter(private val carrito: List<ProductoCarrito>): RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {

    override fun getItemCount() = carrito.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoAdapter.ViewHolder {
        val binding = ActivityProductoCarritoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, carrito)
    }

    override fun onBindViewHolder(holder: CarritoAdapter.ViewHolder, position: Int) {
        holder.bind(carrito[position])
    }

    class ViewHolder(private val binding: ActivityProductoCarritoBinding, private val carrito: List<ProductoCarrito>) : RecyclerView.ViewHolder(binding.root){

        fun bind(carrito: ProductoCarrito){
            binding.nombreProductoCarrito.text = carrito.nombre
            binding.precioCarrito.text = "$" + carrito.precio.toString()

        }
    }

    fun total(): Double {
        var temp: Double = 0.0

        carrito.forEach{ it
            temp += it.precio
        }

        return temp
    }
}