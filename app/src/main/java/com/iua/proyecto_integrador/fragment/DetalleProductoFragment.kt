package com.iua.proyecto_integrador.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.iua.proyecto_integrador.R

class DetalleProductoFragment : Fragment() {

    private lateinit var buyButton: Button
    private lateinit var addButton: Button

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

        buyButton.setOnClickListener {
            findNavController().navigate(R.id.action_detalleProductoFragment_to_carritoFragment)
        }

        addButton.setOnClickListener {
            Toast.makeText(view.context, "Added to cart!", Toast.LENGTH_LONG).show()
        }

    }

}