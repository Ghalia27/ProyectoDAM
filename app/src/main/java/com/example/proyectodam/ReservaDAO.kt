package com.example.proyectodam

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ReservaDAO {
    @Query("SELECT * FROM reserva")
    fun getAll(): LiveData<List<Reserva>>

    @Query("SELECT * FROM reserva WHERE cod_res = :id")
    fun get(id: Int): LiveData<Reserva>

    @Insert
    fun insertAll(vararg reserva: Reserva)

    @Update
    fun update(reserva: Reserva)

    @Delete
    fun delete(reserva: Reserva)
}