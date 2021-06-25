package com.example.proyectodam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.PrimaryKey
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.fragment_perfil.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var idusuario: Int? = null
        if(intent.hasExtra("usuario")){
            val usuario = intent.extras?.getSerializable("usuario") as Usuario

            etNombre.setText(usuario.nombre)
            etApellido.setText(usuario.apellido)
            etEmail.setText(usuario.email)
            etCelular.setText(usuario.celular)
            etContraseña.setText(usuario.password)
            etFchNacimiento.setText(usuario.fechaNacimiento)
            etRContraseña.setText(usuario.password)
        }

        val database = AppDatabase.getInstance(this);

        btnSignUp_.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val email = etEmail.text.toString()
            val celular = etCelular.text.toString()
            val contrasenia = etContraseña.toString()
            val fecha_nacimiento= etFchNacimiento.toString()

            val usuario = Usuario( nombre, apellido, fecha_nacimiento, email, contrasenia, celular, 5)

            Toast.makeText(this, "Se ha registrado correctamente a $apellido, $nombre", Toast.LENGTH_LONG).show()
            CoroutineScope(Dispatchers.IO).launch {
                database.usuarioDAO().insertAll(usuario)
                this@SignUp.finish()
            }
        }
        link_iniciar.setOnClickListener {
            intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

    }
}