package com.example.proyectodam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectodam.fragments.BuscarFragment
import kotlinx.android.synthetic.main.row.view.*


class MyAdapter(val arrayList: ArrayList<Model>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(model: Model){
            itemView.tipoTv.text = model.tipo
            itemView.titleTv.text = model.title
            itemView.descripcionTv.text = model.desc
            itemView.direccionTv.text = model.direccion
            // itemView.imageIv.setImageResource(model.image)
            Glide.with(itemView.context).load(model.image).into(itemView.imageIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {

            val model = arrayList.get(position)

            var gTipo : String = model.tipo
            var gtitle : String = model.title
            var gDescripcion : String = model.desc
            var gDireccion :String = model.direccion

            var gImageView : Int = model.image

            val intent = Intent(context, DetalleRestaurante::class.java)

            intent.putExtra("iTipo", gTipo)
            intent.putExtra("iTitle", gtitle)
            intent.putExtra("iDescripcion", gDescripcion)
            intent.putExtra("iDireccion", gDireccion)
            intent.putExtra("iImageView", gImageView)

            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

}