package com.iua.proyecto_integrador.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.iua.proyecto_integrador.R
import com.iua.proyecto_integrador.database.MyDataBase
import com.iua.proyecto_integrador.proyecto_integradorAplication.Companion.prefs

class DetalleProductoFragment : Fragment() {

    private lateinit var buyButton: Button
    private lateinit var addButton: Button
    private var producto: String? = null
    private lateinit var historialDBHelper: MyDataBase
    private lateinit var comprasDBHelper: MyDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detalle_producto, container, false)

        historialDBHelper = MyDataBase(view.context)
        comprasDBHelper = MyDataBase(view.context)

        buyButton = view.findViewById(R.id.buyNowButton)
        addButton = view.findViewById(R.id.addToCartButton)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        producto = arguments?.getString("producto")

        val productoLista = producto?.split("_") as ArrayList<String>

        view.findViewById<TextView>(R.id.nombreProductoListaIndividual).text = productoLista[0]

        view.findViewById<TextView>(R.id.precio).text = "$"+ productoLista[1]

        if (productoLista[2] ==  "true"){

            view.findViewById<TextView>(R.id.disponible).text = "Disponible"
        }else{
            view.findViewById<TextView>(R.id.disponible).text = "Sin existencias"
        }

        view.findViewById<TextView>(R.id.vendedor).text = "Vendedor: " + productoLista[3]

        view.findViewById<TextView>(R.id.ubicacion).text = "Ubicacion: " + productoLista[4]

        Glide.with(view).load(productoLista[5]).into(view.findViewById(R.id.imagenProductoIndividual))

        view.findViewById<TextView>(R.id.descripcionDetalleProducto).text = "Descripcion: " + productoLista[6]

        //DATABASE historial

        historialDBHelper.addDatosHistorial(productoLista[0])

        //BOTONES
        //TODO este boton tiene que agregar a una lista el item en el que estamos parados y luego pasar al CarritoFragment
        buyButton.setOnClickListener {

            if (productoLista[2] ==  "true"){

                //DATABASE compras

                comprasDBHelper.addDatosCompra(comprasDBHelper.getDatosCompra() + 1, productoLista[0], productoLista[1], prefs.SHARED_USER_NAME)

                findNavController().navigate(R.id.action_detalleProductoFragment_to_carritoFragment)
            }
        }

        //TODO este boton tiene que agregar a una lista el item en el que estamos parados
        addButton.setOnClickListener {

            comprasDBHelper.addDatosCompra(comprasDBHelper.getDatosCompra() + 1, productoLista[0], productoLista[1], prefs.SHARED_USER_NAME)

            Toast.makeText(view.context, "Added to cart!", Toast.LENGTH_LONG).show()
        }

    }

}