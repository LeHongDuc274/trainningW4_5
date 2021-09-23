package com.example.tradix.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.tradix.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
    }

    override fun onBackPressed() {
        showDialog()
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
            .setNegativeButton("No", null)
            .create()
            .show()
    }
}