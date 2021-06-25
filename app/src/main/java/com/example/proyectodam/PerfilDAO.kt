package com.example.proyectodam

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface PerfilDAO {
    @Query("SELECT * FROM perfil")
    fun getAll(): LiveData<List<Perfil>>

    @Query("SELECT * FROM perfil WHERE cod_perf = :id")
    fun get(id: Int): LiveData<Perfil>

    @Insert
    fun insertAll(vararg perfil: Perfil)

    @Update
    fun update(perfil: Perfil)

    @Delete
    fun delete(perfil: Perfil)
}