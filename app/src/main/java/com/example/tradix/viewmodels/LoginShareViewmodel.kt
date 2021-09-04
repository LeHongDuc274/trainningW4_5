package com.example.tradix.viewmodels

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tradix.R
import java.util.concurrent.atomic.AtomicReference

class LoginShareViewmodel : ViewModel() {

    // change password
    private val _time = MutableLiveData<Int>(5)
    val time: LiveData<Int> = _time
    private val _isEnableButton = MutableLiveData<Boolean>(false)
    var isEnableButton: LiveData<Boolean> = _isEnableButton
    val handler = Handler(Looper.getMainLooper())
    var thread = Thread()

    // save state loginFragmentUi
    private val _textEmail = MutableLiveData<String>("email")
    val textEmail: LiveData<String> = _textEmail
    private val _textPassWord = MutableLiveData<String>("pass")
    val textPassWord: LiveData<String> = _textPassWord

    private val _textEmailSignup = MutableLiveData<String>("")
    val textEmailSignup: LiveData<String> = _textEmailSignup
    private val _textPassSignup = MutableLiveData<String>("")
    val textPassSignup: LiveData<String> = _textPassSignup

    val runable = Runnable {
//        view?.findViewById<TextView>(R.id.tv_time_cd)
        for (i in _time.value?.downTo(0)!!) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
                break
            }
            handler.post {
                _time.postValue(i)
            }
        }
        Thread.sleep(100)
        handler.post {
            _isEnableButton.postValue(true)
        }
    }

    fun startThreadCounDownt() {
        thread = Thread(runable)
        thread.start()
    }

    fun stopThreadCOunDownt() {
        if (!thread.isInterrupted) thread.interrupt()

    }

    fun setEmail(email: String) {
        _textEmail.value = email
    }

    fun setPassWord(pass: String) {
        _textPassWord.value = pass
    }

    fun setEmailSignup(email: String){
        _textEmailSignup.value = email
    }
    fun setPassSignup(pass:String){
        _textPassSignup.value = pass
    }
}