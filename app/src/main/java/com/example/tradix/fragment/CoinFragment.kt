package com.example.tradix.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.tradix.R
import com.example.tradix.adapter.ChartSwipeAdapter
import com.example.tradix.mutableListChart

class CoinFragment : Fragment() {
    private lateinit var textView2: TextView
    private lateinit var title: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_coin, container, false)

        setupToolBar(view)
        setupSwipeChart(view)
        return view
    }

    private fun setupSwipeChart(view: View) {
        val adapter = ChartSwipeAdapter()
        adapter.listChart = mutableListChart
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager_chart)
        viewPager.adapter = adapter
        viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Toast.makeText(activity, "$position", Toast.LENGTH_SHORT).show()
                    val chartName: String = title + " chart ${position + 1}"
                    textView2.text = chartName
                }
            }
        )
    }

    private fun setupToolBar(view: View) {
        view.findViewById<Toolbar>(R.id.coint_toolbar).inflateMenu(R.menu.menu_coin_fragment)
        //pop
        view.findViewById<ImageButton>(R.id.ib_back).setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        //set toolbar title
        title = arguments?.getString("title").toString()
        view.findViewById<TextView>(R.id.tv_in_coin_toolbar).text = title
        textView2 = view.findViewById<TextView>(R.id.textView2)
    }
}