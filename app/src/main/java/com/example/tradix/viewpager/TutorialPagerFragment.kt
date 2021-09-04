package com.example.tradix.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.tradix.R
import com.example.tradix.adapter.TutorialPagerAdapter
import com.example.tradix.fragment.FirstTutorialFragment
import com.example.tradix.fragment.SecondTutorialFragment
import com.example.tradix.fragment.ThirdTutorialFragment


class TutorialPagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tutorial_pager, container, false)
        val listFragment: ArrayList<Fragment> = arrayListOf(
            FirstTutorialFragment(),
            SecondTutorialFragment(),
            ThirdTutorialFragment()
        )
        val adapter =
            TutorialPagerAdapter(childFragmentManager, lifecycle, listFragment)
            // k su dung requireActivity().supportFragmentManager -> childFragmentManager
        view.findViewById<ViewPager2>(R.id.viewPager).adapter = adapter
        return view
    }
}