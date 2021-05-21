package com.example.proyectodam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignIn.setOnClickListener(){
            val i : Intent = Intent(this, SignIn::class.java)
            startActivity(i)
        }

        btnSignUp.setOnClickListener(){
            val i : Intent = Intent(this, SignUp::class.java)
            startActivity(i)
        }
    }
}