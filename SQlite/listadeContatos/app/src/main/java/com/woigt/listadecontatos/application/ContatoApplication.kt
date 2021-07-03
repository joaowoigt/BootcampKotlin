package com.woigt.listadecontatos.application

import android.app.Application
import com.woigt.listadecontatos.helpers.HelperDB

class ContatoApplication : Application(){

    var helperDB: HelperDB? = null
            private set


    companion object {  // Criando o singleton de application
       lateinit var instance: ContatoApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        helperDB = HelperDB(this)
    }
}