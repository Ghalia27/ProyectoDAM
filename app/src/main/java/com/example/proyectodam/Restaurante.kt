package com.example.proyectodam
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;
import java.util.*

@Entity(tableName="restaurante")
class Restaurante(
    val nom_rest:String,
    val direc_rest:String,
    val servicios_rest:String,
    val aforo_rest:Int,
    @PrimaryKey(autoGenerate = true)
    var cod_rest:Int = 0
):Serializable