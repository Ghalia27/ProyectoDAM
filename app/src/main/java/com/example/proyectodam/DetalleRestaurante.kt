package com.example.proyectodam

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detalle_restaurante.*


class DetalleRestaurante : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_restaurante)

        //val actionBar : ActionBar? = supportActionBar
        //actionBar!!.setDisplayHomeAsUpEnabled(true)
        // actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent
        val aTipo = intent.getStringExtra("iTipo")
        val aTitle = intent.getStringExtra("iTitle")
        val aDescripcion = intent.getStringExtra("iDescripcion")
        val aDireccion = intent.getStringExtra("iDireccion")
        val aImageView = intent.getIntExtra("iImageView", 0)


        //actionBar.setTitle(aTitle)
        tipoView.text = aTipo
        titleView.text = aTitle
        descripcionView.text = aDescripcion
        direccionView.text = aDireccion
        imageView.setImageResource(aImageView)

        val cl: ImageButton = findViewById(R.id.btn_llamar)
        val wt: ImageButton = findViewById(R.id.btn_whatsapp)
        val fb: ImageButton = findViewById(R.id.btn_facebook)
        val ig: ImageButton = findViewById(R.id.btn_instagram)
        val web: ImageButton = findViewById(R.id.btn_web)

        cl.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val phone = "tel:987654321"
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse(phone)
                startActivity(intent)
            }
        })

        wt.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val phone = "51964859966"
                val intent = Intent(Intent.ACTION_VIEW)
                val uri = "whatsapp://send?phone=$phone"
                intent.data = Uri.parse(uri)
                startActivity(intent)
            }
        })

        fb.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {

                gotoUrl("https://www.facebook.com/McDonaldsPeru")
            }
        })

        ig.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                gotoUrl("https://www.instagram.com/mcdonalds_peru/")
            }
        })

        web.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                gotoUrl("https://www.mcdonalds.com.pe")
            }
        })
    }


    private fun gotoUrl(s: String) {
        val uri: Uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
}