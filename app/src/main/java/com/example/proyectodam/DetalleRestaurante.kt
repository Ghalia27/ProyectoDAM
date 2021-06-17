package com.example.proyectodam

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.proyectodam.fragments.BuscarFragment
import com.example.proyectodam.fragments.PerfilFragment
import kotlinx.android.synthetic.main.activity_detalle_restaurante.*


class DetalleRestaurante : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_restaurante)

        val toolbar: Toolbar = findViewById(R.id.actionBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false);

        //val actionBar : ActionBar? = supportActionBar
        //actionBar!!.setDisplayHomeAsUpEnabled(true)
        // actionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setDisplayShowHomeEnabled(true)

        var intent = intent
        val aTipo = intent.getStringExtra("iTipo")
        val aTitle = intent.getStringExtra("iTitle")
        val aDescripcion = intent.getStringExtra("iDescripcion")
        val aDireccion = intent.getStringExtra("iDireccion")
        val aImageView = intent.getIntExtra("iImageView", 0)
        val aTel = intent.getStringExtra("iTel")
        val aWts = intent.getStringExtra("iWts")
        val aFbs = intent.getStringExtra("iFbs")
        val aIns = intent.getStringExtra("iIns")
        val aWeb = intent.getStringExtra("iWeb")


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
                val phone = aTel
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse(phone)
                startActivity(intent)
            }
        })

        wt.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val phone = aWts
                val intent = Intent(Intent.ACTION_VIEW)
                val uri = "whatsapp://send?phone=$phone"
                intent.data = Uri.parse(uri)
                startActivity(intent)
            }
        })

        fb.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {

                gotoUrl(aFbs.toString())
            }
        })

        ig.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                gotoUrl(aIns.toString())
            }
        })

        web.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                gotoUrl(aWeb.toString())
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //startActivity(Intent(this, PerfilFragment::class.java))
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun gotoUrl(s: String) {
        val uri: Uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
}