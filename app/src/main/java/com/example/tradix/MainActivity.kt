package com.example.tradix

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
    }

//    override fun onBackPressed() {
//        if (isTaskRoot) {
//            val dialog = AlertDialog.Builder(this)
//                .setMessage("Are you sure exit app?")
//                .setCancelable(false)
//                .setPositiveButton(
//                    "Yes"
//                ) { dialog, which ->
//                    finish()
//                }
//                .setNegativeButton("No", null)
//                .show()
//        } else super.onBackPressed()
//
//    }


}