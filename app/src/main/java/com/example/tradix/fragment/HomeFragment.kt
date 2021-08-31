package com.example.tradix.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.R
import com.example.tradix.adapter.ListIndexAdapter
import com.example.tradix.model.Model1
import kotlin.random.Random


class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        fabAction(view)
        val adapter = ListIndexAdapter()
        adapter.list = mutableList
        adapter.setClick {
             val title = mutableList[it].text1
            Toast.makeText(activity, it.toString(), Toast.LENGTH_LONG).show()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView3, CoinFragment(title))
                .addToBackStack(null)
                .commit()
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_index);
        recyclerView.setHasFixedSize(true);
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter
        return view
    }

    private fun fabAction(view: View) {
        view.findViewById<View>(R.id.fab).setOnClickListener {
            var random: Int = Random.nextInt(100000, 999999)
            it.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#${random}"))

        }
    }

    val mutableList = mutableListOf<Model1>(
        Model1("Down fffff Jone 1", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 2", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 3", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 4", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 5", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 6", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 7", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 8", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 9", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 10", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 11", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 12", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 13", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 14", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 15", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 16", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 17", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45"),
        Model1("Down Jone 18", "20.047,50", "+203 (+1,04%)", "NYSE", "10:44:45")
    )

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}