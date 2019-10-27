package com.example.multiscreen

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView

class FamilyActivity : AppCompatActivity() {
    private var mp:MediaPlayer = MediaPlayer()

    private lateinit var running:ImageView
    private lateinit var currentWord:Word

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)

        var family = arrayListOf<Word>()

        family.add(Word("father","Baba",R.drawable.family_father,R.raw.family_baba))
        family.add(Word("mother","Ma",R.drawable.family_mother,R.raw.family_maa))
        family.add(Word("son","Putra",R.drawable.family_son,R.raw.family_putro))
        family.add(Word("daughter","Kanna",R.drawable.family_daughter,R.raw.family_konna))
        family.add(Word("older brother","Baro Vai",R.drawable.family_older_brother,R.raw.family_boro_vai))
        family.add(Word("younger brother","Choto Vai",R.drawable.family_younger_brother,R.raw.family_choto_vai))
        family.add(Word("older sister","Baro Bon",R.drawable.family_older_sister,R.raw.family_baro_bon))
        family.add(Word("younger sister","Choto Bon",R.drawable.family_younger_sister,R.raw.family_choto_bon))
        family.add(Word("grandmother","Dida",R.drawable.family_grandmother,R.raw.family_dida))
        family.add(Word("grandfather","Dadu",R.drawable.family_grandfather,R.raw.family_dadu))


        val adapter = WordAdapter(this,family)

        val root = findViewById<ListView>(R.id.rootView)

        root.adapter = adapter

        root.setOnItemClickListener{ adapterView, view, position: Int, id: Long ->
            val item = family[position]
            currentWord = item
            mediaControll(item,view.findViewById(R.id.playButton))

        }
    }

    override fun onStop() {
        super.onStop()
        if(::currentWord.isInitialized) {
            currentWord.tooglePlay()
            mp.pause()
            running.setImageResource(R.drawable.play)
        }

    }

    private fun mediaControll(item:Word,playButton: ImageView){
        if(item.getPlay() == 1){
            playButton.setImageResource(R.drawable.pause)
            item.tooglePlay()
            Log.v("audio",mp.isPlaying.toString())
            if(mp.isPlaying){
                mp.pause()
                mp.release()
                mp = MediaPlayer.create(applicationContext,item.getAudio())
                running.setImageResource(R.drawable.play)
                running = playButton
                mp.start()
            }
            else{
                mp?.release()
                mp = MediaPlayer.create(applicationContext,item.getAudio())
                mp.start()
                running = playButton
            }

        }
        else{
            playButton.setImageResource(R.drawable.play)
            item.tooglePlay()
            mp.pause()
        }

        mp!!.setOnCompletionListener{
            item.tooglePlay()
            playButton.setImageResource(R.drawable.play)
        }
    }
}
