package main.kotlin.DigiOneBank

class Pessoa {
    var nome:String = "João"  // Membros da Classe
    var cpf:String = "123.123.123.11"

}

fun main() {
    val joao = Pessoa()  // Instanciando a Classe

    println(joao.nome)
    println(joao.cpf)
}