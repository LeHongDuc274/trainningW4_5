package com.example.tradix.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tradix.R
import com.example.tradix.fragment.CoinFragment
import com.example.tradix.fragment.HomeFragment
import com.example.tradix.fragment.MenuFragment
import com.example.tradix.fragment.NewFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var navBottom: BottomNavigationView
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView3) as NavHostFragment
        navController = navHostFragment.navController
        navBottom = findViewById<BottomNavigationView>(R.id.bottom_nav)
        navBottom.setupWithNavController(navController)
        navBottom.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> navController.navigate(item.itemId, null)
                R.id.newFragment -> navController.navigate(item.itemId, null)
                R.id.menuFragment -> navController.navigate(item.itemId, null)
                else -> Unit
            }
            true
        }
    }

    override fun onBackPressed() {

//        val backstackCount = navHostFragment.parentFragmentManager.backStackEntryCount
        val child = navHostFragment.childFragmentManager
        val backstackChildCount = child.backStackEntryCount
        Log.e("child.count", "${backstackChildCount}")
        if (backstackChildCount == 0) {
            showDialog()
        } else {
            navController.navigateUp()
        }
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