package com.example.proyectodam

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface RestauranteDAO {
    @Query("SELECT * FROM restaurante")
    fun getAll(): LiveData<List<Restaurante>>

    @Query("SELECT * FROM restaurante WHERE cod_rest = :id")
    fun get(id: Int): LiveData<Restaurante>

    @Insert
    fun insertAll(vararg restaurante: Restaurante)

    @Update
    fun update(restaurante: Restaurante)

    @Delete
    fun delete(restaurante: Restaurante)
}