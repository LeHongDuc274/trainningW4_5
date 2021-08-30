package com.example.tradix.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.fragmentContainerView3) as NavHostFragment
//        val navController = navHostFragment.navController
        navBottom = findViewById<BottomNavigationView>(R.id.bottom_nav)
        navBottom.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> loadFragment(HomeFragment())
                R.id.coinFragment -> loadFragment(CoinFragment())
                R.id.newFragment -> loadFragment(NewFragment())
                R.id.menuFragment -> loadFragment(MenuFragment())
                else -> Unit
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView3, fragment)
            .addToBackStack(null)
            .commit()
    }
    
    override fun onBackPressed() {

        val backstackCount = supportFragmentManager.backStackEntryCount
        val child = supportFragmentManager.findFragmentById(R.id.fragmentContainerView3)?.childFragmentManager
        Log.e("child.count","${child?.backStackEntryCount}")
        if (child != null) {
            if (child.backStackEntryCount > 0) {
                child.popBackStack()
                return
            }
        } else {
            if (backstackCount == 0) {
                showDialog()
            } else {
                super.onBackPressed()

            }
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