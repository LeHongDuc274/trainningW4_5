package com.example.tradix.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tradix.R
import com.example.tradix.viewmodels.ChangePassWordViewmodel
import com.example.tradix.viewmodels.LoginShareViewmodel


class ChangePasswordFragment : Fragment() {
    lateinit var viewmodel : LoginShareViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProvider(this).get(LoginShareViewmodel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_change_password, container, false)
        viewmodel.startThreadCounDownt()
        view.findViewById<Button>(R.id.btn_resend_mail).setOnClickListener {
            findNavController().navigate(R.id.action_changePasswordFragment_to_confirmPasswordFragment)
        }
        viewmodel.isEnableButton.observe(viewLifecycleOwner){
            view.findViewById<Button>(R.id.btn_resend_mail).isEnabled = it
        }
        viewmodel.time.observe(viewLifecycleOwner){
            val text = "Wait ${it} seconds before sending it"
            view.findViewById<TextView>(R.id.tv_time_cd).text = text
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        viewmodel.stopThreadCOunDownt()
    }
}