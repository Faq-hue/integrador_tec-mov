package com.iua.proyecto_integrador.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.databinding.ActivityListadoProductoIndividualBinding
import com.iua.proyecto_integrador.model.Producto
import retrofit2.converter.gson.GsonConverterFactory

class DetalleProductoFragment : Fragment() {

    private lateinit var buyButton: Button
    private lateinit var addButton: Button
    private var producto: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detalle_producto, container, false)
        buyButton = view.findViewById(R.id.buyNowButton)
        addButton = view.findViewById(R.id.addToCartButton)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        producto = arguments?.getString("producto")


        val parser = JsonParser()

        val productoJson = parser.parse(producto).asJsonObject


        Log.d("Json de mierda", productoJson.toString())

        if (productoJson != null) {

            var tv = view.findViewById<TextView>(R.id.nombreProductoListaIndividual)

            tv.text = productoJson.get("nombre").toString()

            tv = view.findViewById(R.id.precio)

            tv.text = productoJson.get("precio").toString()


            Glide.with(view).load(productoJson.get("imagen").toString()).into(view.findViewById(R.id.imagenProductoIndividual))

        }

        buyButton.setOnClickListener {
            findNavController().navigate(R.id.action_detalleProductoFragment_to_carritoFragment)
        }

        addButton.setOnClickListener {
            Toast.makeText(view.context, "Added to cart!", Toast.LENGTH_LONG).show()
        }

    }

}