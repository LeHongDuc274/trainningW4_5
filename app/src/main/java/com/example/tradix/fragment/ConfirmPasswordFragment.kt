package com.example.tradix.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tradix.R
import com.example.tradix.listUsers
import com.example.tradix.viewmodels.LoginShareViewmodel
import java.util.concurrent.atomic.AtomicReference

class ConfirmPasswordFragment : Fragment() {
    lateinit var viewmodel: LoginShareViewmodel
    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewmodel = ViewModelProvider(requireActivity()).get(LoginShareViewmodel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirm_password, container, false)
        view.findViewById<Button>(R.id.btn_confirm_to_login).setOnClickListener {
//            findNavController().navigate(
//                R.id.action_confirmPasswordFragment_to_loginFragment, bundleOf(
//                    "newpass" to 123
//                )
//            )
            viewmodel.setPassWord("123")
            var email = viewmodel.textEmail.value
            if (email != null) {
                listUsers.put(email,"123")
            }
            findNavController().popBackStack(R.id.loginFragment,false)
        }
        return view
    }
}