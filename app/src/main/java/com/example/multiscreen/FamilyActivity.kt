package com.example.multiscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FamilyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)

        val fragment =
            supportFragmentManager.beginTransaction().replace(R.id.rootView, FamilyFragment())
                .commit()

    }
}
