package com.example.tradix.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import com.example.tradix.*
import com.example.tradix.activities.HomeActivity
import com.example.tradix.viewmodels.LoginShareViewmodel
import org.w3c.dom.Text
import java.util.concurrent.atomic.AtomicReference
import kotlin.math.log
import kotlin.properties.Delegates


class LoginFragment : Fragment() {
    lateinit var loginShareViewmodel: LoginShareViewmodel
    lateinit var edtEmail: EditText
    lateinit var edtPassWord: EditText
    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginShareViewmodel =
            ViewModelProvider(requireActivity()).get(LoginShareViewmodel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        edtEmail = view.findViewById<EditText>(R.id.idt_email)
        edtPassWord = view.findViewById<EditText>(R.id.idt_password)
        setOnClick(view)
        setObserveEdit(view)
        return view
    }

    override fun onPause() {
        super.onPause()

        loginShareViewmodel.setEmail(edtEmail.text.toString())
        loginShareViewmodel.setPassWord(edtPassWord.text.toString())
    }

    private fun setObserveEdit(view: View) {
        loginShareViewmodel.textEmail.observe(viewLifecycleOwner) {
            edtEmail.setText(it)
        }
        loginShareViewmodel.textPassWord.observe(viewLifecycleOwner) {
            edtPassWord.setText(it)
        }
    }

    private fun setOnClick(view: View) {
        val navController = findNavController()
        view.findViewById<TextView>(R.id.tv_login_4_forgot_pass).setOnClickListener {
            if(checkEmail()== EMAIL_ALREADY_EXITS) {
                navController.navigate(R.id.action_loginFragment_to_changePasswordFragment)
            } else Toast.makeText(activity,"Email not exits",Toast.LENGTH_SHORT).show()
        }
        view.findViewById<TextView>(R.id.tv_login_5_singup).setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
//            navController.navigate(R.id.action_loginFragment_to_nav_home)
            if (checkEmail() == EMAIL_ALREADY_EXITS && checkAuth() == PASSWORD_SUCCES) {
                val intent = Intent(activity, HomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            } else Toast.makeText(activity,"Check Your Email or PassWord",Toast.LENGTH_SHORT).show()
        }
    }

   private fun checkEmail(): Int {
        var email = edtEmail.text.toString()
        if (listUsers.containsKey(email)) return EMAIL_ALREADY_EXITS
        else return EMAIL_NOT_EXITS
    }

    private fun checkAuth(): Int {
        var pass = edtPassWord.text.toString()
        var email = edtEmail.text.toString()
        if (listUsers.get(email) == pass) return PASSWORD_SUCCES
        else return PASSWORD_WRONG
    }
}