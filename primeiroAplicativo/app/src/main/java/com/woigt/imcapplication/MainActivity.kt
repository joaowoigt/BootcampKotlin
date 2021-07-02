package com.woigt.imcapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {

        ib_check?.setOnClickListener {  // Retorna o resultado do c
            val imc = calcularIMC(EDT_peso.text.toString(), EDT_altura.text.toString())
           tv_resultado.text = "Seu IMC é  ${"%.2f".format(imc)}"
          bt_saiba_mais.setVisibility(View.VISIBLE)
        }

        bt_saiba_mais?.setOnClickListener {  // Direciona para a pagina que o IMC se enquadrar
            val imc = calcularIMC(EDT_peso.text.toString(), EDT_altura.text.toString())
            if (imc <= 18.5) {
                val intent = Intent(
                    this,
                    magrezaPage::class.java
                )
                startActivity(intent) }

            if (imc > 18.5 && imc <= 24.9) {
                val intent = Intent(
                    this,
                    normalPage::class.java
                )
                startActivity(intent)
            }

            if (imc > 24.9 && imc <= 29.9){
                val intent = Intent(
                    this,
                    sobrepesoPage::class.java)
                startActivity(intent)
            }
            if (imc >=30){
                val intent = Intent(
            this,
           obesidadePage::class.java)
            startActivity(intent)
            }

        }

        ib_info?.setOnClickListener() {  // Leva até a pagina saiba mais
            val intent = Intent(
                this,
                saibaMaisPage::class.java
            )
            startActivity(intent)
        }

    }

    private fun calcularIMC(peso: String, altura: String): Float {  // Função para calcular IMC
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            return imc
        } else {
            return 0.0f
        }
    }
}










