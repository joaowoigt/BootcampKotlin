package com.example.helloworld

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // variaveis ligadas ao layout para codar suas funções
        val bt_Calcular = calcular
        val resultado = resultado

        // ao cliclar executa o código
        bt_Calcular.setOnClickListener {

            val nota1 :BigDecimal = BigDecimal((nota1.text.toString()))
            val nota2 :BigDecimal = BigDecimal((nota2.text.toString()))
            val media :BigDecimal = (nota1 + nota2) / BigDecimal(2)
            val faltas :Int = Integer.parseInt(faltas.text.toString())

            // Calculo e condicional das Médias
            if(media >= BigDecimal(6) && faltas <= 5){
                resultado.setText("Aluno foi aprovado" + "\n" + "Nota Final: " + media +
                        "\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.GREEN)


            }
            else{
                resultado.setText("Aluno foi reprovado" + "\n" + "Nota Final: " + media +
                        "\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.RED)

            }



        }


    }
}