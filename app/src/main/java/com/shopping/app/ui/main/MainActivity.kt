package com.shopping.app.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shopping.app.R
import com.shopping.app.ui.feed.FeedFragment
import com.shopping.app.ui.home.HomeFragment
import com.shopping.app.ui.inbox.InboxFragment
import com.shopping.app.ui.me.MeFragment
import com.shopping.app.ui.notification.NotificationFragment
import com.shopping.app.ui.wallet.WalletFragment

class MainActivity : AppCompatActivity() {

    val fragmentHome = HomeFragment()
    val fragmentFeed = FeedFragment()
    val fragmentInbox = InboxFragment()
    val fragmentNotification = NotificationFragment()
    val fragmentMe = MeFragment()
    val fm = supportFragmentManager
    var active: Fragment = fragmentHome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fm.beginTransaction().add(R.id.main_container, fragmentMe, "5").hide(fragmentMe).commit()
        fm.beginTransaction().add(R.id.main_container, fragmentNotification, "4").hide(fragmentNotification).commit()
        fm.beginTransaction().add(R.id.main_container, fragmentInbox, "3").hide(fragmentInbox).commit()
        fm.beginTransaction().add(R.id.main_container, fragmentFeed, "2").hide(fragmentFeed).commit()
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

                    R.id.navigation_feed -> {
                        fm.beginTransaction().hide(active).show(fragmentFeed).commit()
                        active = fragmentFeed
                        return true
                    }

                    R.id.navigation_inbox -> {
                        fm.beginTransaction().hide(active).show(fragmentInbox).commit()
                        active = fragmentInbox
                        return true
                    }

                    R.id.navigation_notification -> {
                        fm.beginTransaction().hide(active).show(fragmentNotification).commit()
                        active = fragmentNotification
                        return true
                    }

                    R.id.navigation_me -> {
                        fm.beginTransaction().hide(active).show(fragmentMe).commit()
                        active = fragmentMe
                        return true
                    }
                }
                return false
            }
        }

}
