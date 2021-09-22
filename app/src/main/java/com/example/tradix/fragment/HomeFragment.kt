package com.example.tradix.fragment

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.R
import com.example.tradix.adapter.ListIndexAdapter
import com.example.tradix.model.Model1
import com.example.tradix.viewmodels.SharedViewModel
import kotlin.random.Random


class HomeFragment : Fragment() {
    val mutableList = mutableListOf<Model1?>()
    lateinit var adapter: ListIndexAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var shareViewmodel: SharedViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        shareViewmodel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        fabAction(view)
        setupRecycleView(view)
        return view
    }

    private fun setupRecycleView(view: View) {
        adapter = ListIndexAdapter()
        shareViewmodel.listCoin.value?.let { adapter.setData(it) }
        adapter.setClick {
            val title = shareViewmodel.listCoin.value?.get(it)?.text1
            shareViewmodel._curCoinOpenned.value = it
            val args = bundleOf(
                "title" to title
            )
            val coinFragment = CoinFragment()
           // coinFragment.arguments = args
            findNavController().navigate(R.id.coinFragment, args)

        }
        adapter.setLoadMoreClick {
            shareViewmodel.loadMoreDataListCoin()
            adapter.notifyDataSetChanged()
        }
        recyclerView = view.findViewById<RecyclerView>(R.id.rv_index);
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter
        ItemTouchHelper(swipeItemIndexCallback).attachToRecyclerView(recyclerView)
    }

    private fun fabAction(view: View) {
        view.findViewById<View>(R.id.fab).setOnClickListener {
            val random: Int = Random.nextInt(100000, 999999)
            it.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#${random}"))
        }
    }


    val swipeItemIndexCallback =
        object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (direction == ItemTouchHelper.RIGHT) {
                    shareViewmodel.removeItem(position)
                    adapter.notifyItemRemoved(position)
                }
            }
        }
}
