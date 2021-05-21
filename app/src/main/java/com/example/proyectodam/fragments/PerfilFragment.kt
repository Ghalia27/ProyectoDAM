package com.example.proyectodam.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.proyectodam.R
import com.example.proyectodam.SignIn
import com.example.proyectodam.SignUp
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_perfil.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PerfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PerfilFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    fun ingresar(v: View) {
        btnSignIn.setOnClickListener {
            val intent = Intent(
                this@PerfilFragment.activity,
                SignIn::class.java
            )
            startActivity(intent)
        }
    }

    fun registrar(v: View) {
        btnSignUp.setOnClickListener {
            val intent = Intent(
                this@PerfilFragment.activity,
                SignUp::class.java
            )
            startActivity(intent)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_perfil, container, false)
        val view: View = inflater.inflate(R.layout.fragment_perfil, container, false)
        val btnIngresar: Button = view.findViewById<View>(R.id.btnSignIn) as Button
        val btnRegistrar: Button = view.findViewById<View>(R.id.btnSignUp) as Button
        btnIngresar.setOnClickListener(View.OnClickListener {
            val intent1 = Intent(activity, SignIn::class.java)
            startActivity(intent1)
        })
        btnRegistrar.setOnClickListener(View.OnClickListener {
            val intent2 = Intent(activity, SignUp::class.java)
            startActivity(intent2)
        })
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PerfilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                PerfilFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}