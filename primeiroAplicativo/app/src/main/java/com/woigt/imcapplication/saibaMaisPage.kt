package com.woigt.imcapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saiba_mais_page.*

class saibaMaisPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saiba_mais_page)
        setListeners()
    }

    private fun setListeners(){
        ib_voltar_saiba_mais?.setOnClickListener(){
            val intent = Intent(
                this,
                MainActivity::class.java
            )
            startActivity(intent)
        }
    }
}