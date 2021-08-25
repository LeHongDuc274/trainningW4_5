package com.example.tradix.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.tradix.R

class ConfirmPasswordFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirm_password, container, false)
        view.findViewById<Button>(R.id.btn_confirm_to_login).setOnClickListener {
            findNavController().navigate(
                R.id.action_confirmPasswordFragment_to_loginFragment, bundleOf(
                    "newpass" to 123
                )
            )
        }
        return view
    }

}