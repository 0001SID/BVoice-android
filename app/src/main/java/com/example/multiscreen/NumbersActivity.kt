package com.example.multiscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        val fragment =
            supportFragmentManager.beginTransaction().replace(R.id.rootView, NumbersFragment())
                .commit()
    }
}

