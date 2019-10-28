package com.example.multiscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ColorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        val fragment =
            supportFragmentManager.beginTransaction().replace(R.id.rootView, ColorsFragment())
                .commit()
    }
}
