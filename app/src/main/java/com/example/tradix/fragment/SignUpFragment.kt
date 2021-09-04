package com.example.tradix.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tradix.R
import com.example.tradix.viewmodels.LoginShareViewmodel


class SignUpFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        setOnClick(view)
        setObserve(view)
        return view
    }

    override fun onPause() {
        super.onPause()
        val edtEmail = view?.findViewById<EditText>(R.id.idt_email_signup)
        val edtPass = view?.findViewById<EditText>(R.id.idt_password_signup)
        viewmodel.setEmailSignup(edtEmail?.text.toString())
        viewmodel.setPassSignup(edtPass?.text.toString())
        Log.e("pause", viewmodel.textEmailSignup.value.toString())
        Log.e("pause2", viewmodel.textPassSignup.value.toString())
    }

    private fun setObserve(view:View){
        val edtEmail = view.findViewById<EditText>(R.id.idt_email_signup)
        val edtPass = view.findViewById<EditText>(R.id.idt_password_signup)
        viewmodel.textEmailSignup.observe(viewLifecycleOwner){
            edtEmail.setText(it)
        }
        viewmodel.textPassSignup.observe(viewLifecycleOwner){
            edtPass.setText(it)
        }
    }
    private fun setOnClick(view: View) {
        val navController = findNavController()
        view.findViewById<Button>(R.id.btn_signup).setOnClickListener {
            //update LoginFrag
            updateUiLogin(view)
            navController.navigate(R.id.action_signUpFragment_to_loginFragment)
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

    private fun updateUiLogin(view: View) {
        val edtEmail = view.findViewById<EditText>(R.id.idt_email_signup)
        val edtPass = view.findViewById<EditText>(R.id.idt_password_signup)
        if(!edtEmail.text.toString().isEmpty()){
            viewmodel.setEmail(edtEmail.text.toString())
        }
        if(!edtPass.text.toString().isEmpty()){
            viewmodel.setPassWord(edtPass.text.toString())
        }
    }

}