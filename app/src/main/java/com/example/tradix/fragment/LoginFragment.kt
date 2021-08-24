package com.example.tradix.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.tradix.R
import org.w3c.dom.Text


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_login, container, false)
        setOnClick(view)
        return view
    }

    private fun setOnClick(view: View) {
        val navController = findNavController()
        view.findViewById<TextView>(R.id.tv_login_4_forgot_pass).setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_changePasswordFragment)
        }
        view.findViewById<TextView>(R.id.tv_login_5_singup).setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

}