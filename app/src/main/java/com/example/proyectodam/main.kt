package com.example.proyectodam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.proyectodam.fragments.BuscarFragment
import com.example.proyectodam.fragments.MenuFragment
import com.example.proyectodam.fragments.PerfilFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_perfil.*

class MainActivity : AppCompatActivity() {

    private val buscarFragment = BuscarFragment()
    private val perfilFragment = PerfilFragment()
    private val menuFragment = MenuFragment()
    lateinit var toggle: ActionBarDrawerToggle

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

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigation_bottom.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_perfil -> replaceFragment(perfilFragment)
                R.id.ic_buscar -> replaceFragment(buscarFragment)
                R.id.ic_menu -> replaceFragment(menuFragment)
            }
            true
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.miItem1 -> Toast.makeText(applicationContext, "Clicked Item 1", Toast.LENGTH_SHORT).show()
                R.id.miItem2 -> Toast.makeText(applicationContext, "Clicked Item 2", Toast.LENGTH_SHORT).show()
                R.id.miItem3 -> Toast.makeText(applicationContext, "Clicked Item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null){
            val transaccion = supportFragmentManager.beginTransaction()
            transaccion.replace(R.id.fragment_container, fragment)
            transaccion.commit()
        }
    }
}