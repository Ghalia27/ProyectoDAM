package com.example.proyectodam

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface EstadoDAO {
    @Query("SELECT * FROM estado")
    fun getAll(): LiveData<List<Estado>>

    @Query("SELECT * FROM estado WHERE cod_est = :id")
    fun get(id: Int): LiveData<Estado>

    @Insert
    fun insertAll(vararg estado: Estado)

    @Update
    fun update(estado: Estado)

    @Delete
    fun delete(estado: Estado)
}