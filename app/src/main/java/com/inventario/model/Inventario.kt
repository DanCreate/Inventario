package com.inventario.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "inventario")
data class Inventario(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "articulo_nombre")
    val articulo_nombre: String,
    @ColumnInfo(name = "descripcion")
    val descripcion: String?,
    @ColumnInfo(name = "cantidad_unidad")
    val cantidad_unidad: Int?,
    ) : Parcelable