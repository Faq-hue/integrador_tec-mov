package com.iua.proyecto_integrador.fragment

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
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
import com.iua.proyecto_integrador.database.MyDataBase
import com.iua.proyecto_integrador.model.Producto
import com.iua.proyecto_integrador.model.ProductoCarrito
import com.iua.proyecto_integrador.proyecto_integradorAplication.Companion.prefs

class CarritoFragment : Fragment() {

    private lateinit var buyButton: Button
    private lateinit var continueShoppingButton: Button
    private lateinit var adapter: CarritoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var carritoArrayList: ArrayList<ProductoCarrito>
    private lateinit var comprasDBHelper: MyDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_carrito, container, false)
        buyButton = view.findViewById(R.id.buyButton)
        continueShoppingButton = view.findViewById(R.id.continueShoppingButton)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        comprasDBHelper = MyDataBase(requireContext())
        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerViewCarrito)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CarritoAdapter(carritoArrayList)
        recyclerView.adapter = adapter

        //BOTONES
        //TODO este boton tiene que limpiar el recycler view del carrito
        buyButton.setOnClickListener {

            comprasDBHelper.updateDatosCompra(prefs.getBuy())

            findNavController().navigate(R.id.action_carritoFragment_to_pedidoRealizadoFragment)
        }

        continueShoppingButton.setOnClickListener {
            findNavController().navigate(R.id.action_carritoFragment_to_listadoFragment)
        }

    }

    private fun dataInitialize(){
        carritoArrayList = arrayListOf()

        val db: SQLiteDatabase = comprasDBHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM compras", null)

        if(cursor.moveToFirst()){

            do{
                var aux = ProductoCarrito()
                aux.nombre = cursor.getString(1)
                aux.precio = cursor.getDouble(2)
                aux.comprado = cursor.getString(3)

                if(aux.comprado.equals("0")){
                    carritoArrayList.add(aux)
                }


            }while (cursor.moveToNext())

        }

        Log.e("PRUEBA 696969969696", carritoArrayList.toString())

        cursor.close()
    }

    private fun dataFinalize(): ArrayList<ProductoCarrito> {

        carritoArrayList = arrayListOf()

        Log.e("mostrar todo", carritoArrayList.toString())

        carritoArrayList.clear()


        Log.e("mostrar todo", carritoArrayList.toString())


        return carritoArrayList
    }

}