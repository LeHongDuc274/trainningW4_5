package com.example.tradix

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.fragmentContainerView)
        if (navController.currentDestination?.id == R.id.tutorialPagerFragment){
            showDialog()
        } else super.onBackPressed()
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