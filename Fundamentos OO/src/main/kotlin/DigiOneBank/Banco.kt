package main.kotlin.DigiOneBank

data class Banco(  //Criação de uma dataclass que tem como objetivo ser imutavel depois de instnaciada
    val nome: String,
    val numero: Int,
){
    fun info() = "$nome - $numero"
}
