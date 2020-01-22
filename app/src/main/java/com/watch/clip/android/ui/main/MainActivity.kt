package com.watch.clip.android.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.watch.clip.android.R
import com.watch.clip.android.ui.home.HomeFragment
import com.watch.clip.android.ui.wallet.WalletFragment

class MainActivity : AppCompatActivity() {

    val fragmentHome = HomeFragment()
    val fragmentWallet = WalletFragment()
    val fm = supportFragmentManager
    var active: Fragment = fragmentHome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fm.beginTransaction().add(R.id.main_container, fragmentWallet, "2").hide(fragmentWallet).commit()
        fm.beginTransaction().add(R.id.main_container,fragmentHome, "1").commit()

    }

    private val mOnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navigation_home -> {
                        fm.beginTransaction().hide(active).show(fragmentHome).commit()
                        active = fragmentHome
                        return true
                    }

                    R.id.navigation_dashboard -> {
                        fm.beginTransaction().hide(active).show(fragmentWallet).commit()
                        active = fragmentWallet
                        return true
                    }
                }
                return false
            }
        }

}
