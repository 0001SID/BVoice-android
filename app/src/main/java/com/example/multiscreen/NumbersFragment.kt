package com.example.multiscreen


import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView

/**
 * A simple [Fragment] subclass.
 */
class NumbersFragment : Fragment() {

    private lateinit var rootView:View

    private var mp: MediaPlayer = MediaPlayer()

    private lateinit var running: ImageView

    private lateinit var currentWord:Word

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_numbers, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var numbers = arrayListOf<Word>()

        numbers.add(Word("One","Ek",R.drawable.number_one,R.raw.number_ek))
        numbers.add(Word("Two","Dui",R.drawable.number_two,R.raw.number_dui))
        numbers.add(Word("Three","Tin",R.drawable.number_three,R.raw.number_tin))
        numbers.add(Word("Four","Char",R.drawable.number_four,R.raw.number_char))
        numbers.add(Word("five","Pac",R.drawable.number_five,R.raw.number_pac))
        numbers.add(Word("Six","Choy",R.drawable.number_six,R.raw.number_choy))
        numbers.add(Word("Seven","Sat",R.drawable.number_seven,R.raw.number_sat))
        numbers.add(Word("Eight","At",R.drawable.number_eight,R.raw.number_at))
        numbers.add(Word("Nine","Noy",R.drawable.number_nine,R.raw.number_noy))
        numbers.add(Word("Ten","Das",R.drawable.number_ten,R.raw.number_dos))


        val adapter = WordAdapter(context!!,numbers)

        val root = rootView.findViewById<ListView>(R.id.root)

        root.adapter = adapter

        root.setOnItemClickListener{ adapterView, view, position: Int, id: Long ->
            val item = numbers[position]
            currentWord = item
            mediaControll(item,view.findViewById(R.id.playButton))

        }
    }


    private fun mediaControll(item:Word,playButton: ImageView){
        if(item.getPlay() == 1){
            playButton.setImageResource(R.drawable.pause)
            item.tooglePlay()
            Log.v("audio",mp.isPlaying.toString())
            if(mp.isPlaying){
                Log.i("NumberActivity","In 1")
                mp.pause()
                mp.release()
                mp = MediaPlayer.create(context,item.getAudio())
                running.setImageResource(R.drawable.play)
                running = playButton
                mp.start()
            }
            else{
                Log.i("NumberActivity","In 2")
                mp.release()
                mp = MediaPlayer.create(context,item.getAudio())
                mp.start()
                running = playButton
            }

        }
        else{
            Log.i("NumberActivity","In 3")

            playButton.setImageResource(R.drawable.play)
            item.tooglePlay()
            mp.pause()
        }

        mp!!.setOnCompletionListener{
            item.tooglePlay()
            playButton.setImageResource(R.drawable.play)
        }
    }

    override fun onStop() {
        super.onStop()
        if(::currentWord.isInitialized) {
            currentWord?.tooglePlay()
            mp?.pause()
            running?.setImageResource(R.drawable.play)
        }

    }



}
