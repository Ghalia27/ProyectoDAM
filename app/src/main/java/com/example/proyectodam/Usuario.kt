package com.example.proyectodam
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName="usuario")
class Usuario(
    val nombre:String,
    val apellido:String,
    val fechaNacimiento:String,
    val email:String,
    val correo:String,
    val password: String,
    val celular:String,
    @PrimaryKey(autoGenerate = true)
    var idusuario:Int = 0
):Serializable