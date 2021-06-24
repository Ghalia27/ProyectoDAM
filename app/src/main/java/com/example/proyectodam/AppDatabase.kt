package com.example.proyectodam
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[Usuario::class], version =1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun usuarioDAO(): UsuarioDAO

    companion object{
        private var INSTANCE:AppDatabase?=null
        fun getInstance(context: Context): AppDatabase{
            if(INSTANCE==null){
                INSTANCE=Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "bd_mesaparados"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return INSTANCE!!
        }
    }

}