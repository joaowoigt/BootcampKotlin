package one.digitalinnovation.collections

fun main() {
    val nomes = Array<String>(3){""}  // Chamar a classe array, passar o size e uma inicialização
    nomes[0] = "Maria"                      // Como esta inferido que receberá strings não precisa deixar explicito
    nomes[1] = "João"
    nomes[2] = "José"

    for (nome in nomes){
        println(nome)
    }

    println("---------------")
    nomes.sort()
    nomes.forEach {
        println(it)
    }

    println("---------------")
    val nomes2 = arrayOf("Maria", "João", "José")  // Forma menos verbosa para declarar uma array de string

    for (nome in nomes2){
        println(nome)
    }

    println("---------------")
    nomes2.sort()
    nomes2.forEach {
        println(it)
    }
}