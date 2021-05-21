package com.example.proyectodam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.proyectodam.fragments.BuscarFragment
import com.example.proyectodam.fragments.PerfilFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_perfil.*

class MainActivity : AppCompatActivity() {

    private val buscarFragment = BuscarFragment()
    private val perfilFragment = PerfilFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(buscarFragment)

        /*btnSignIn.setOnClickListener(){
            val i : Intent = Intent(this, SignIn::class.java)
            startActivity(i)
        }

        btnSignUp.setOnClickListener(){
            val i : Intent = Intent(this, SignUp::class.java)
            startActivity(i)
        }*/

        navigation_bottom.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_perfil -> replaceFragment(perfilFragment)
                R.id.ic_buscar -> replaceFragment(buscarFragment)
                R.id.ic_menu -> replaceFragment(perfilFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null){
            val transaccion = supportFragmentManager.beginTransaction()
            transaccion.replace(R.id.fragment_container, fragment)
            transaccion.commit()
        }
    }
}