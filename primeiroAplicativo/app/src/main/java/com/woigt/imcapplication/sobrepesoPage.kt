package com.woigt.imcapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sobrepeso_page.*

class sobrepesoPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobrepeso_page)
        setListeners()
    }

    private fun setListeners(){
        ib_volta_sobrepeso?.setOnClickListener(){
            val intent = Intent(
                this,
                MainActivity::class.java
            )
            startActivity(intent)
        }
    }

}