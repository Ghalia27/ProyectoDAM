package com.example.proyectodam
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;
import java.util.*

@Entity(tableName="perfil")
class Perfil(
    val nom_perf:String,
    @PrimaryKey(autoGenerate = true)
    var cod_perf:Int = 0
):Serializable