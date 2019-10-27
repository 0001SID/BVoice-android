package com.example.multiscreen

class Word (english:String,bengali:String,img:Int = 0,aud:Int){
    private var bengaliTranslation:String? = null
    private var englishTranslation:String? = null
    private var image:Int = 0
    private var audio:Int = 0
    private var play:Int = 1

    init{
        bengaliTranslation = bengali
        englishTranslation = english
        image = img
        audio = aud
    }

    fun getBengali():String{
        return bengaliTranslation.toString()
    }

    fun getEnglish():String{
        return englishTranslation.toString()
    }

    fun getImage():Int{
        return image
    }

    fun getAudio():Int{
        return audio
    }

    fun tooglePlay(){
        if(play == 1) play = 0
        else play = 1
    }

    fun getPlay():Int{
        return play
    }

}