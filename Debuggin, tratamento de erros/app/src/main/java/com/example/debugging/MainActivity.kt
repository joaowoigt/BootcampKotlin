package com.example.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*  // Importar variaveis do layout
import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    private var clicks = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLogListeners()
        val currentThread = Thread.currentThread()
        // Chama este método quando não pegar a exception
        currentThread.setUncaughtExceptionHandler{ _, throwable ->
            val x = throwable.message
            val cause = throwable.cause
        }
    }


    private fun setLogListeners() {
        debugBTN?.setOnClickListener { Log.d("clicks", "Opa! Cliquei no debug") }
        errorBTN?.setOnClickListener {
            var message: String = ""
           try {
               val list = listOf<Int>(2, 1, 4)
               val a = list[5]
               message = "Sobrevivi ao try"
           } catch (e: IndexOutOfBoundsException){
               message = "Entrei no catch correto"
           } catch (i: NullPointerException){
               message = "Entrei no catch errado"
           }
           finally {
               inputEDT?.setText(message)
               val t = 35
           }
        }
        infoBTN?.setOnClickListener { Log.i("clicks", "Opa! Cliquei no info")}
        warningBTN?.setOnClickListener { Log.w("clicks", "Opa! Cliquei no warning")}
        verboseBTN?.setOnClickListener { Log.v("clicks", "Opa! Cliquei no verbose")}

    }
}