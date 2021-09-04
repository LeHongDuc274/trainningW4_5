package com.example.tradix.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.R
import com.example.tradix.adapter.NewAdapter
import com.example.tradix.adapter.NewItem
import com.example.tradix.listItemNews


class NewFragment : Fragment() {
    lateinit var newAdapter: NewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_new, container, false)
        view.findViewById<ImageButton>(R.id.ib_back).setOnClickListener {
            findNavController().navigateUp()
        }
        initAdapter()
        setupRecycleView(view)

        return view
    }


    private fun initAdapter() {
        newAdapter = NewAdapter(requireContext())
        newAdapter.apply {
            listNewItem = listItemNews
            setClick {
                Toast.makeText(activity, "click item new $it", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.editorialFragment)
            }
        }
    }

    private fun setupRecycleView(view:View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_news)
        recyclerView?.let {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(view.context)
            it.adapter = newAdapter
        }
    }
}