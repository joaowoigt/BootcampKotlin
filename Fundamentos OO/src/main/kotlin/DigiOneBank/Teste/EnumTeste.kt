package main.kotlin.DigiOneBank.Teste

import main.kotlin.DigiOneBank.ClienteTipo

fun main() {
    ClienteTipo.values().forEach { elemento ->  // Loop para imprimir o que tem no Enum
    println("${elemento.name} - ${elemento.descricao} ")
    }
    ClienteTipo.values().forEach {
    println("${it.name} - ${it.descricao}")
    }

    val pf = ClienteTipo.pf  // Instanciando a classe enum para pf
    println("${pf.name} - ${pf.descricao}")
    val pj = ClienteTipo.pj // Instanciando a classa enum para pj
    println("${pj.name} - ${pj.descricao}")
}