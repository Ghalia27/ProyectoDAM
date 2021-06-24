package com.example.proyectodam

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UsuarioDAO {
    @Query("SELECT * FROM usuario")
    fun getAll(): LiveData<List<Usuario>>

    @Query("SELECT * FROM usuario WHERE idusuario = :id")
    fun get(id: Int): LiveData<Usuario>

    @Insert
    fun insertAll(vararg usuario: Usuario)

    @Update
    fun update(usuario: Usuario)

    @Delete
    fun delete(usuario: Usuario)
}