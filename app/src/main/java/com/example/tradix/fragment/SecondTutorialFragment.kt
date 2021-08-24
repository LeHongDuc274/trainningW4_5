package com.example.tradix.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.tradix.R
import com.example.tradix.activities.LoginActivity


class SecondTutorialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second_tutorial, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        view.findViewById<Button>(R.id.btn_next_2).setOnClickListener {
            viewPager?.currentItem = 2
        }
        view.findViewById<ImageButton>(R.id.btn_back_2).setOnClickListener {
            viewPager?.currentItem = 0
        }
        view.findViewById<Button>(R.id.btn_skip_2).setOnClickListener {
//            val intent = Intent(activity, LoginActivity::class.java)
//            startActivity(intent)
            findNavController().navigate(R.id.action_tutorialPagerFragment_to_nav_login)

        }
        return view
    }


}