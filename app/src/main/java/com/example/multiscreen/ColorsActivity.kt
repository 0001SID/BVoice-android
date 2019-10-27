package com.example.multiscreen

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView

class ColorsActivity : AppCompatActivity() {
    private var mp:MediaPlayer = MediaPlayer()

    private lateinit var running:ImageView
    private lateinit var currentWord:Word

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        var colors = arrayListOf<Word>()

        colors.add(Word("black","Kalo",R.drawable.color_black,R.raw.color_kalo))
        colors.add(Word("white","Sada",R.drawable.color_white,R.raw.color_sada))
        colors.add(Word("green","Sabuj",R.drawable.color_green,R.raw.color_sabuj))
        colors.add(Word("red","Lal",R.drawable.color_red,R.raw.color_lal))
        colors.add(Word("gray","Dhusar",R.drawable.color_gray,R.raw.color_dhusar))
        colors.add(Word("dusty yellow","Dhulo Halud",R.drawable.color_dusty_yellow,R.raw.color_dhulo_holud))
        colors.add(Word("mustard yellow","Khati halud",R.drawable.color_mustard_yellow,R.raw.color_khati_holud))
        colors.add(Word("brown","Badami",R.drawable.color_brown,R.raw.color_badami))


        val adapter = WordAdapter(this,colors)

        val root = findViewById<ListView>(R.id.rootView)

        root.adapter = adapter

        root.setOnItemClickListener{ adapterView, view, position: Int, id: Long ->
            val item = colors[position]
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
