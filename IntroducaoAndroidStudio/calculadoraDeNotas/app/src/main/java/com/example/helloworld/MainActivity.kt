package com.example.helloworld

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.InspectableProperty
import androidx.constraintlayout.widget.Group
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.math.BigDecimal
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // variaveis ligadas ao layout para codar suas funções
        val bt_Calcular = calcular
        val resultado = resultado
        val condicao = condicao




        // ao cliclar executa o código
        bt_Calcular.setOnClickListener {
            try{ // Adicionando try catch para tratar o erro de , e inteiro

            val nota1 :BigDecimal = BigDecimal((nota1.text.toString()))
            val nota2 :BigDecimal = BigDecimal((nota2.text.toString()))
            val media :BigDecimal = (nota1 + nota2) / BigDecimal(2)
            val faltas :Int = Integer.parseInt(faltas.text.toString())


            // Calculo e condicional das Médias


                if (media >= BigDecimal(6) && faltas <= 5) {
                    resultado.setText(
                        "Aluno foi aprovado" + "\n" + "Nota Final: " + media +
                                "\n" + "Faltas: " + faltas
                    )
                    resultado.setTextColor(Color.GREEN)
                    condicao.setImageDrawable(  // Aparecer Thumbs up quando reprovado
                        ContextCompat.getDrawable(
                            applicationContext, // Context
                            R.drawable.ic_thumb_up_off_alt_white_24dp // Drawable
                        )
                    )

                } else {
                    resultado.setText(
                        "Aluno foi reprovado" + "\n" + "Nota Final: " + media +
                                "\n" + "Faltas: " + faltas
                    )
                    resultado.setTextColor(Color.RED)
                    condicao.setImageDrawable(  // Aparecer Thumbs down quando reprovado
                        ContextCompat.getDrawable(
                            applicationContext, // Context
                            R.drawable.ic_thumb_down_off_alt_white_24dp // Drawable
                        )
                    )

                }
            } catch (e: NumberFormatException ){
                resultado.setText("Por favor insira um valor " + "\n" +
                        "utilizando . para notas " + "\n" +
                        "e inteiro para faltas")
                resultado.setTextColor(Color.RED)
                condicao.setImageDrawable(  // Aparecer carinha triste quando reprovado
                    ContextCompat.getDrawable(
                        applicationContext, // Context
                         R.drawable.ic_sentiment_dissatisfied_white_24dp// Drawable
                    )
                )
            }




        }



    }
}