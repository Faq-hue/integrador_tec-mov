package com.iua.proyecto_integrador.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iua.proyecto_integrador.databinding.ActivityListadoProductoIndividualBinding
import com.iua.proyecto_integrador.model.Producto

class ProductoAdapter(private val productos : List<Producto>, private val listener: RecyclerViewOnClickListener): RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    override fun getItemCount() = productos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =  ActivityListadoProductoIndividualBinding.inflate( LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productos[position])
    }

    class ViewHolder(private val binding: ActivityListadoProductoIndividualBinding, listener: RecyclerViewOnClickListener) : RecyclerView.ViewHolder(binding.root){

        fun bind(producto: Producto){
            binding.nombreProductoListaIndividual.text = producto.nombre
            Glide.with(binding.root.context).load(producto.imagen).into(binding.imagenProductoIndividual)

        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}
interface RecyclerViewOnClickListener{
    fun onItemClick(position: Int)
}
