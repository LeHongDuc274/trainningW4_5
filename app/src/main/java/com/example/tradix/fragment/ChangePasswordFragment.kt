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
import androidx.navigation.fragment.findNavController
import com.example.tradix.R


class ChangePasswordFragment : Fragment() {

    lateinit var handler: Handler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_change_password, container, false)
        handler = Handler(Looper.getMainLooper())
        thread.start()
        view.findViewById<Button>(R.id.btn_resend_mail).isEnabled = false
        view.findViewById<Button>(R.id.btn_resend_mail).setOnClickListener {
            findNavController().navigate(R.id.action_changePasswordFragment_to_loginFragment,
                bundleOf(
                    "newpass" to 123
                ))
        }
        return view
    }


    val runable = Runnable {
        view?.findViewById<TextView>(R.id.tv_time_cd)
        for (i in 5 downTo 0){
            Thread.sleep(1000)
            handler.post {
                view?.findViewById<TextView>(R.id.tv_time_cd)?.setText("Wait $i seconds before sending it")
            }
        }
        handler.post{
            view?.findViewById<Button>(R.id.btn_resend_mail)?.isEnabled = true
        }

    }
    val thread = Thread(runable)


}