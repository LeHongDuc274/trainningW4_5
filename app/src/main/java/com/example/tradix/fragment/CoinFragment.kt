package com.example.tradix.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.tradix.R
import com.example.tradix.adapter.ChartSwipeAdapter

class CoinFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_coin, container, false)
        view.findViewById<Toolbar>(R.id.coint_toolbar).inflateMenu(R.menu.menu_coin_fragment)
        val textView2 = view.findViewById<TextView>(R.id.textView2)
        val adapter = ChartSwipeAdapter()
        adapter.listChart = mutableList
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager_chart)
        viewPager.adapter = adapter
        viewPager.registerOnPageChangeCallback(
            object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Toast.makeText(activity,"$position",Toast.LENGTH_SHORT).show()
                    textView2.text = "NEO chart ${position+1}"
                }
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            }
        )
        return view
    }

    val mutableList = mutableListOf<Int>(
        R.drawable.neo_chart,
        R.drawable.neo_chart,
        R.drawable.neo_chart
    )
}