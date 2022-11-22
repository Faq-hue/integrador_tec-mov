package com.iua.proyecto_integrador.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iua.proyecto_integrador.databinding.ActivityProductoHistorialBinding


class HistorialAdapter(private val historial: List<String>): RecyclerView.Adapter<HistorialAdapter.ViewHolder>() {

    override fun getItemCount() = historial.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialAdapter.ViewHolder {
        val binding = ActivityProductoHistorialBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, historial)
    }

    override fun onBindViewHolder(holder: HistorialAdapter.ViewHolder, position: Int) {
        holder.bind(historial[position])
    }

    class ViewHolder(private val binding: ActivityProductoHistorialBinding, private val carrito: List<String>) : RecyclerView.ViewHolder(binding.root){

        fun bind(historialProducto: String){
            binding.productoNombreHistorial.text = historialProducto
        }
    }
}