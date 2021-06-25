package com.example.proyectodam
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;
import java.util.*

@Entity(tableName="estado")
class Estado(
    val nom_est:String,
    @PrimaryKey(autoGenerate = true)
    var cod_est:Int = 0
):Serializable