package com.example.tradix

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tradix.activities.LoginActivity


class SplashFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        Handler(Looper.getMainLooper()).postDelayed({
            val navController = findNavController()
            if(!tutorialFinished()) {
                navController.navigate(R.id.action_splashFragment_to_tutorialPagerFragment)
            } else {
                navController.navigate(R.id.action_splashFragment_to_nav_login)
            }
        }, 1000L)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
     fun tutorialFinished(): Boolean{
         val sharedReference = requireActivity().getSharedPreferences("tutorial", Context.MODE_PRIVATE)
         return sharedReference.getBoolean("finish",false)
     }

}