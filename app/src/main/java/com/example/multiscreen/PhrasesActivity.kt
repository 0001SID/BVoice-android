package com.example.multiscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PhrasesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrases)

        val fragment =
            supportFragmentManager.beginTransaction().replace(R.id.rootView, PhrasesFragment())
                .commit()
    }
}