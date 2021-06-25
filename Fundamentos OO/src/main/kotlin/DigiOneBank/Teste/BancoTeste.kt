package main.kotlin.DigiOneBank.Teste

import main.kotlin.DigiOneBank.Banco

fun main() {
    val digiOneBank = Banco("DigiOne", 12)

    println(digiOneBank.nome)
    println(digiOneBank.numero)

    val banco2 = digiOneBank.copy("Santander", 12)

    println(banco2.info())
}