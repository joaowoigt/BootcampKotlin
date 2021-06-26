package main.kotlin.DigiOneBank.Teste

import main.kotlin.DigiOneBank.Cliente
import main.kotlin.DigiOneBank.ClienteTipo

fun main() {

    val jose = Cliente(
        "José da Silva",
        "123.123.123-14",
        ClienteTipo.pf,
        "123456"
    )


    println(jose)
    AutenticacaoTeste().autentica(jose)
}
