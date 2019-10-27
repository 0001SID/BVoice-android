package com.example.multiscreen

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView

class PhrasesActivity : AppCompatActivity() {
    private var mp:MediaPlayer = MediaPlayer()

    private lateinit var running:ImageView
    private lateinit var currentWord:Word

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrases)

        var phrases = arrayListOf<Word>()

        phrases.add(Word("Where are you going?","Tumi kothay jaccho?",0,R.raw.phrases_tumi_kothy_jaccho))
        phrases.add(Word("What is your name?","Tomar nam ki?",0,R.raw.phrases_tomar_nam_ki))
        phrases.add(Word("My name is...","Amar nam..",0,R.raw.phrases_amar_nam))
        phrases.add(Word("How are you feeling?","Tomar kamn lagche?",0,R.raw.phrases_tomar_kamn_lagche))
        phrases.add(Word("I’m feeling good.","Amr valo lagche",0,R.raw.phrases_amar_valo_lagce))
        phrases.add(Word("Are you coming?","Tumi ki ascho?",0,R.raw.phrases_tumi_ki_esecho))
        phrases.add(Word("Yes, I’m coming.","Ha ami aschi.",0,R.raw.phrases_ha_ami_aschi))
        phrases.add(Word("I’m coming.","Ami aschi.",0,R.raw.phrases_ami_aschi))
        phrases.add(Word("Let’s go.","Chalo jai",0,R.raw.phrases_cholo_jai))
        phrases.add(Word("Come here.","Ekhane aso",0,R.raw.phrases_ekhane_aso))


        val adapter = WordAdapter(this,phrases)

        val root = findViewById<ListView>(R.id.rootView)

        root.adapter = adapter

        root.setOnItemClickListener{ adapterView, view, position: Int, id: Long ->
            val item = phrases[position]
            currentWord = item
            mediaControll(item,view.findViewById(R.id.playButton))

        }
    }

    override fun onStop() {
        super.onStop()
        if(::currentWord.isInitialized) {
            mp.pause()
            currentWord.tooglePlay()
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
