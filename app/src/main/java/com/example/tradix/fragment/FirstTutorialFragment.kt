package com.example.tradix.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.tradix.R
import com.example.tradix.activities.LoginActivity


class FirstTutorialFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first_tutorial, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        view.findViewById<Button>(R.id.btn_next_1).setOnClickListener {
            viewPager?.currentItem = 1
        }
        view.findViewById<Button>(R.id.btn_skip_1).setOnClickListener {
            val intent =  Intent(activity,LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        return view
    }
}