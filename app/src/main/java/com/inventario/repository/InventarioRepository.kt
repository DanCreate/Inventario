package com.inventario.repository

import androidx.lifecycle.LiveData
import com.inventario.data.InventarioDao
import com.inventario.model.Inventario

class InventarioRepository (private val inventarioDao: InventarioDao) {


    val getAllData: LiveData<List<Inventario>> = inventarioDao.getAllData()



    suspend fun addInventario(inventario:Inventario){
        inventarioDao.addInventario(inventario)


    }



    suspend fun updateInventario(inventario:Inventario){
        inventarioDao.updateInventario(inventario)


    }

    suspend fun deleteInventario(inventario:Inventario){
        inventarioDao.deleteInventario(inventario)


    }
}