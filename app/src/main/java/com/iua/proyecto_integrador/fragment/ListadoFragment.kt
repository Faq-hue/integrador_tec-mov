package com.iua.proyecto_integrador.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.adapter.ProductoAdapter
import com.iua.proyecto_integrador.adapter.RecyclerViewOnClickListener
import com.iua.proyecto_integrador.model.Producto
import com.iua.proyecto_integrador.model.ProductoClient
import kotlin.concurrent.thread

class ListadoFragment : Fragment(), RecyclerViewOnClickListener {

    private lateinit var adapter: ProductoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var productosArray: ArrayList<Producto>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listado, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        thread {
            val apiKey = getString(R.string.api_key)
            val listaProductos = ProductoClient.service.listaProductos(apiKey)
            val body = listaProductos.execute().body()

            activity?.runOnUiThread{

                if (body !=  null){

                    productosArray = body

                    val layoutManager = LinearLayoutManager(context)
                    recyclerView = view.findViewById(R.id.recyclerViewListado)
                    recyclerView.layoutManager = layoutManager
                    recyclerView.setHasFixedSize(true)
                    adapter = ProductoAdapter(productosArray, this)
                    recyclerView.adapter = adapter
                }
            }
        }

    }


    private fun dataInitialize() {
        productosArray = arrayListOf()

    }

    override fun onItemClick(position: Int) {

        var tmp = productosArray[position].nombre + "_" + productosArray[position].precio + "_" + productosArray[position].disponible + "_" + productosArray[position].vendedor + "_" + productosArray[position].ubicacion + "_" + productosArray[position].imagen + "_" + productosArray[position].descripcion

        val bundle = bundleOf("producto" to tmp)
        findNavController().navigate(R.id.action_listadoFragment_to_detalleProductoFragment, bundle)

    }

}