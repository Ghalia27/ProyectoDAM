package com.example.proyectodam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
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
        replaceFragment(perfilFragment)

        val toolbar: Toolbar = findViewById(R.id.actionBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false);
        navigation_bottom.selectedItemId = R.id.ic_perfil

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
                R.id.miItem1 -> {
                    replaceFragment(buscarFragment)
                    navigation_bottom.selectedItemId = R.id.ic_buscar
                }
                R.id.miItem2 -> {
                    replaceFragment(perfilFragment)
                    navigation_bottom.selectedItemId = R.id.ic_perfil
                }
                R.id.miItem3 -> {
                    replaceFragment(menuFragment)
                    navigation_bottom.selectedItemId = R.id.ic_menu
                }
                R.id.miItem4 -> Toast.makeText(applicationContext, "Ajustes", Toast.LENGTH_SHORT).show()
                R.id.miItem5 -> Toast.makeText(applicationContext, "Cerrar sesion", Toast.LENGTH_SHORT).show()
                //R.id.miItem3 -> Toast.makeText(applicationContext, "Clicked Item 3", Toast.LENGTH_SHORT).show()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return false
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