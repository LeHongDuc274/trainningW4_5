package com.example.tradix.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.tradix.R
import org.w3c.dom.Text
import kotlin.properties.Delegates


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val newPass = arguments?.getInt("newpass")

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        if(newPass!=null){
            view.findViewById<EditText>(R.id.idt_password).setText(newPass.toString())
        }
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