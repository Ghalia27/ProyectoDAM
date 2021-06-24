package com.example.proyectodam
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_sign_in.view.*
class UsuarioAdapter (private val usuarios: ArrayList<Usuario> = ArrayList()) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>(){
    class UsuarioViewHolder(view: View):RecyclerView.ViewHolder(view)

    fun agregarUsuario(usuario:Usuario){
        usuarios.add(usuario)
        notifyItemInserted(itemCount)
    }

    fun getUsuario(posicion: Int) : Usuario{
        return usuarios[posicion]
    }



    fun eliminarUsuario(posicion : Int){

        usuarios.removeAt(posicion)

        notifyItemRemoved(posicion)

    }



    fun restaurarTarea(posicion : Int, usuario : Usuario){

        usuarios.add(posicion,usuario)

        notifyItemInserted(posicion)

    }



    fun cambiarPosicionItem(posicionInicial : Int, posicionFinal:Int){

        val tarea = usuarios[posicionInicial]

        usuarios.removeAt(posicionInicial)

        usuarios.add(posicionFinal,tarea)

        notifyItemMoved(posicionInicial,posicionFinal)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {

        val view = LayoutInflater.from(parent.context)

            .inflate(R.layout.tarea_item,parent,false)

        return UsuarioViewHolder(view)

    }



    override fun getItemCount(): Int {

        return usuarios.size

    }



    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {

        holder.itemView.nombre.text = usuarios[position].nombre



        holder.itemView.tarea_terminada.isChecked = usuarios[position].terminada



        if(holder.itemView.tarea_terminada.isChecked)

            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.tarea_terminada))

        else

            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.tarea_no_terminada))



        holder.itemView.tarea_terminada.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked)

                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.tarea_terminada))

            else

                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.tarea_no_terminada))

        }

    }


}