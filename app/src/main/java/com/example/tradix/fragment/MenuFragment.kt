package com.example.tradix.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.*
import com.example.tradix.adapter.ItemMenu
import com.example.tradix.adapter.MenuAdapter


class MenuFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        view.findViewById<ImageButton>(R.id.ib_back).setOnClickListener {
            findNavController().navigateUp()
        }
        setupRecycleView(view)
        return view
    }

    private fun setupRecycleView(view:View) {
        val menuAdapter = MenuAdapter()
        menuAdapter.listItem = listItemMenu
        val rv = view.findViewById<RecyclerView>(R.id.rv_menu_frag)
        rv.apply {
            adapter = menuAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}


