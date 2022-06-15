package com.inventario.ui.inventario

import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.inventario.R
import com.inventario.databinding.FragmentAddInventarioBinding
import com.inventario.model.Inventario
import com.inventario.viewmodel.InventarioViewModel


class AddInventarioFragment : Fragment() {


private lateinit var inventarioViewModel: InventarioViewModel

private var _binding: FragmentAddInventarioBinding? = null
private val  binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    inventarioViewModel = ViewModelProvider (this)[InventarioViewModel:: class.java]
    _binding = FragmentAddInventarioBinding.inflate(inflater,container,false)

    //Se agrega la funcion para agregar un lugar
    binding.btAdd.setOnClickListener{addInventario()}

    return binding.root
}

private fun addInventario() {
    val nombre_cantidad=binding.etNombre.text.toString()
    val descripcion=binding.etDescripcion.text.toString()
    val cantidad=binding.etCantidad.text.toString()

    if (nombre_cantidad.isNotEmpty()){
        val inventario = Inventario(0,nombre_cantidad,descripcion,0)
        inventarioViewModel.addInventario(inventario)

        Toast.makeText(requireContext(), getString(R.string.inventarioAdded), Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_addInventarioFragment_to_nav_inventario)


    }else{
        Toast.makeText(requireContext(),getString(R.string.noData), Toast.LENGTH_SHORT).show()

    }
}

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}

}