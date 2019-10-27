package com.example.multiscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbers = findViewById<TextView>(R.id.numbers)
        val family = findViewById<TextView>(R.id.family)
        val colors = findViewById<TextView>(R.id.colors)
        val phrases = findViewById<TextView>(R.id.phrases)

        numbers.setOnClickListener{v ->
            opennubersActivity()
        }
        family.setOnClickListener { v->
            openFamilyActivity()
        }
        colors.setOnClickListener{v->
            openColorsActivity()
        }
        phrases.setOnClickListener{v->
            openPhrasesActivity()
        }

    }

    private fun opennubersActivity(){
        val intent = Intent(this,NumbersActivity::class.java)
        startActivity(intent)
    }

    private fun openColorsActivity(){
        val intent = Intent(this, ColorsActivity::class.java)
        startActivity(intent)
    }

    private fun openFamilyActivity(){
        val intent = Intent(this, FamilyActivity::class.java)
        startActivity(intent)
    }

    private fun openPhrasesActivity(){
        val intent = Intent(this,PhrasesActivity::class.java)
        startActivity(intent)
    }

}

