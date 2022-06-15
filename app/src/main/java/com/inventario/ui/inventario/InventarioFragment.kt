package com.inventario.ui.inventario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.inventario.R
import com.inventario.databinding.FragmentInventarioBinding
import com.inventario.viewmodel.InventarioViewModel

class InventarioFragment : Fragment() {

    private lateinit var inventarioViewModel: InventarioViewModel

    private var _binding: FragmentInventarioBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         inventarioViewModel = ViewModelProvider(this).get(InventarioViewModel::class.java)

        _binding = FragmentInventarioBinding.inflate(inflater, container, false)

        binding.addInventarioButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_inventario_to_addInventarioFragment)

        }



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}