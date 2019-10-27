package com.example.multiscreen

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.collections.ArrayList
import android.view.animation.AlphaAnimation



class WordAdapter(private val context: Context,
                  private val dataSource: ArrayList<Word>):BaseAdapter() {

    private var mp = MediaPlayer()

    private var running:ImageView = ImageView(context)

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // Get view for row item
        val rowView = inflater.inflate(R.layout.list, parent, false)

        val english = rowView.findViewById<TextView>(R.id.english)
        val bengali = rowView.findViewById<TextView>(R.id.bengali)
        val image = rowView.findViewById<ImageView>(R.id.image)
        val rootView = rowView.findViewById<LinearLayout>(R.id.rootView)
        val playButton = rowView.findViewById<ImageView>(R.id.playButton)
        val item = getItem(position) as Word
        mp = MediaPlayer.create(context,R.raw.song)



        english.text = item.getEnglish()
        bengali.text = item.getBengali()
        if(item.getImage() != 0){
            image.setImageResource(item.getImage())
        }
        else{
            image.layoutParams.width = 0
            image.layoutParams.height = 0
        }


//        fun mediaControll(){
//            if(item.getPlay() == 1){
//                playButton.setImageResource(R.drawable.pause)
//                item.tooglePlay()
//                Log.v("audio",mp.isPlaying.toString())
//                if(mp.isPlaying){
//                    mp.pause()
//                    mp.release()
//                    mp = MediaPlayer.create(context,item.getAudio())
//                    running.setImageResource(R.drawable.play)
//                    running = playButton
//                    mp.start()
//                }
//                else{
//                    mp?.release()
//                    mp = MediaPlayer.create(context,item.getAudio())
//                    mp.start()
//                    running = playButton
//                }
//
//            }
//            else{
//                playButton.setImageResource(R.drawable.play)
//                item.tooglePlay()
//                mp.pause()
//            }
//        }


//        rootView.setOnClickListener { v->
//            rootView.startAnimation(AlphaAnimation(1f, 0.2f))
//            mediaControll()
//
//            //Set action when the audio file end
//            mp!!.setOnCompletionListener{
//                playButton.setImageResource(R.drawable.play)
//                }
//            }

        return rowView
    }

}