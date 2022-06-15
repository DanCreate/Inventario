package com.inventario.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.inventario.model.Inventario

@Dao
interface InventarioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addInventario(inventario: Inventario)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateInventario(inventario: Inventario)

    @Delete
    suspend fun deleteInventario(inventario: Inventario)

    @Query("SELECT * FROM INVENTARIO")
    fun getAllData() : LiveData<List<Inventario>>


}