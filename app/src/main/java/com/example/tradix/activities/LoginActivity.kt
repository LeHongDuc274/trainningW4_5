package com.example.tradix.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import com.example.tradix.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
    }

    override fun onBackPressed() {
    val navController = findNavController(R.id.fragmentContainerView2)
       // val b = navController.popBackStack()
        if (navController.currentDestination?.id == R.id.loginFragment ){
            showDialog()
        } else super.onBackPressed()
//        if (!b){
//            showDialog()
//        }
    }

    private fun showDialog() {
        val dialog = AlertDialog.Builder(this)
            .setMessage("Are you sure exit app?")
            .setCancelable(false)
            .setPositiveButton(
                "Yes"
            ) { _, _ ->
                finish()
            }
            .setNegativeButton("No"){_,_ ->
            }
            .create()
            .show()
    }
}