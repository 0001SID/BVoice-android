package com.example.multiscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        For Removing the shadow below Action bar

        supportActionBar!!.elevation = 0f

        val viewPager = findViewById<ViewPager>(R.id.viewpager)

        val adapter = FixedTabFragmentPagerAdapter(supportFragmentManager)

        viewPager.adapter = adapter

        // Connecting viewpager with tabs
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)
    }
}

