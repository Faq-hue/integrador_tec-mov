package com.iua.proyecto_integrador.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.iua.proyecto_integrador.R


class PedidoRealizadoFragment : Fragment() {

    private lateinit var backToMenuButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pedido_realizado, container, false)
        backToMenuButton = view.findViewById(R.id.backToMenu)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backToMenuButton.setOnClickListener {
            findNavController().navigate(R.id.action_pedidoRealizadoFragment_to_listadoFragment)
        }

    }

}