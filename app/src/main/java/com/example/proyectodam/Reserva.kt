package com.example.proyectodam
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;
import java.util.*

@Entity(tableName="reserva")
class Reserva(
    val fecha_res:String,
    val horario_res:String,
    val cod_est:Int,
    val cant_personas:Int,
    val cod_usu:Int,
    val cod_rest: Int,
    val celular:Int,
    @PrimaryKey(autoGenerate = true)
    var cod_res:Int = 0
):Serializable