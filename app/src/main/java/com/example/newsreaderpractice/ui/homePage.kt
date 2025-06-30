package com.example.newsreaderpractice.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.newsreaderpractice.R
import com.example.newsreaderpractice.adaptor.ViewPagerAdaptor
import com.google.android.material.bottomnavigation.BottomNavigationView

class homePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val adaptor =ViewPagerAdaptor(this)
        viewPager.adapter = adaptor

        bottomNavView.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.nav_home -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.nav_bookmarks -> {
                    viewPager.currentItem = 1
                    true
                }
                else -> false
            }
        }
        viewPager.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> bottomNavView.menu.findItem(R.id.nav_home).isChecked = true
                    1 -> bottomNavView.menu.findItem(R.id.nav_bookmarks).isChecked = true
                }
            }
        })


    }
}