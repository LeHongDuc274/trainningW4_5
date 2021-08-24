package com.example.tradix.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.viewpager2.widget.ViewPager2
import com.example.tradix.R

class ThirdTutorialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third_tutorial, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        view.findViewById<ImageButton>(R.id.btn_back_3).setOnClickListener {
            viewPager?.currentItem?.minus(1)
        }
        view.findViewById<Button>(R.id.btn_next_3).setOnClickListener {
            //navigation login

        }
        return view
    }

}