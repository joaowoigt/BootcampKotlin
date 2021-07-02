package com.woigt.imcapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_magreza_page.*

class magrezaPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magreza_page)
        setListeners()
    }

    private fun setListeners(){
        ib_volta_magreza?.setOnClickListener(){
            val intent = Intent(
                this,
                MainActivity::class.java
            )
            startActivity(intent)
        }
    }
}
