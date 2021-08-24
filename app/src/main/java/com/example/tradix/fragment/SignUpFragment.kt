package com.example.tradix.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tradix.R


class SignUpFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        setOnClick(view)
        return view
    }

    private fun setOnClick(view: View) {
        val navController = findNavController()
        view.findViewById<Button>(R.id.btn_signup).setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_loginFragment)
            Toast.makeText(activity,"signup ok - from signup frg",Toast.LENGTH_SHORT).show()
        }
        view.findViewById<TextView>(R.id.tv_signup_5_login).setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_loginFragment)
            Toast.makeText(activity,"return to sigin from signup frg",Toast.LENGTH_SHORT).show()
        }
        view.findViewById<TextView>(R.id.tv_login_4_forgot_pass_signup).setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_changePasswordFragment)
            Toast.makeText(activity,"navigation change pass from signup frg",Toast.LENGTH_SHORT).show()
        }

    }

}