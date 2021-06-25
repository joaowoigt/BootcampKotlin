package main.kotlin.DigiOneBank

abstract class Pessoa(  // Classe com construtor primario
     val nome: String,  // open permite que extenda e herde de outra classe
     val cpf: String    // Abstract não instancia
)
