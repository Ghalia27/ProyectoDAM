package com.example.proyectodam.fragments

import android.R.attr.fragment
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectodam.Model
import com.example.proyectodam.MyAdapter
import com.example.proyectodam.R
import kotlinx.android.synthetic.main.fragment_buscar.*
import java.util.*
import kotlin.collections.ArrayList


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BuscarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BuscarFragment : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false)
    }

    private val arrayList = ArrayList<Model>()
    private val displayList = ArrayList<Model>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arrayList.clear()

        arrayList.add(
            Model(
                "tipo restaurante",
                "Restaurante 1",
                "Abierto / Cerrado",
                "Distrito, calle del restaurante",
                R.drawable.restaurante1
            )
        )
        arrayList.add(
            Model(
                "tipo restaurante",
                "Restaurante 2",
                "Abierto / Cerrado",
                "Distrito, calle del restaurante",
                R.drawable.restaurante2
            )
        )
        arrayList.add(
            Model(
                "tipo restaurante",
                "Restaurante 3",
                "Abierto / Cerrado",
                "Distrito, calle del restaurante",
                R.drawable.restaurante3
            )
        )
        arrayList.add(
            Model(
                "tipo restaurante",
                "Restaurante 4",
                "Abierto / Cerrado",
                "Distrito, calle del restaurante",
                R.drawable.restaurante4
            )
        )
        arrayList.add(
            Model(
                "tipo restaurante",
                "Restaurante 5",
                "Abierto / Cerrado",
                "Distrito, calle del restaurante",
                R.drawable.restaurante5
            )
        )
        displayList.addAll(arrayList)

        val myAdapter = context?.let { MyAdapter(displayList, it) }

        /*recycleView.setHasFixedSize(true);
        recycleView.setItemViewCacheSize(20);
        recycleView.setDrawingCacheEnabled(true);*/

        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = myAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val search = view.findViewById<SearchView>(R.id.searchView)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText!!.isNotEmpty()) {
                    displayList.clear()
                    val searchV = newText.toLowerCase(Locale.getDefault())
                    arrayList.forEach {
                        if (it.title.toLowerCase(Locale.getDefault()).contains(searchV)) {
                            displayList.add(it)
                        }
                    }
                    recycleView.adapter!!.notifyDataSetChanged()
                } else {
                    displayList.clear()
                    displayList.addAll(arrayList)
                    recycleView.adapter!!.notifyDataSetChanged()
                }

                return true
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BuscarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                BuscarFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
