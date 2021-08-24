package com.example.tradix.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.PopUpToBuilder
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.tradix.R
import com.example.tradix.activities.LoginActivity

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
            //navigation login and finished tutorial
            tutorialFinished()
            findNavController().navigate(R.id.action_tutorialPagerFragment_to_nav_login)
//            val intent = Intent(activity,LoginActivity::class.java)
//            startActivity(intent)
        }
        view.findViewById<Button>(R.id.btn_skip_3).setOnClickListener {
            // skip tutorial
            findNavController().navigate(R.id.action_tutorialPagerFragment_to_nav_login)
//            val intent = Intent(activity, LoginActivity::class.java)
//            startActivity(intent)
        }
        return view
    }

    private fun tutorialFinished() {
        val sharedReference = requireActivity().getSharedPreferences("tutorial", Context.MODE_PRIVATE)
        val editor = sharedReference.edit()
        editor.putBoolean("finish",true)
        editor.apply()
    }

}