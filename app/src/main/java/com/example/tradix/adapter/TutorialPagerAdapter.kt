package com.example.tradix.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TutorialPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, list: ArrayList<Fragment>) :
    FragmentStateAdapter(fm, lifecycle) {
    private val listFragment = list

    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return listFragment[position]
    }
}