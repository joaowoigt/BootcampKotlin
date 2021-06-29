package one.digitalinnovation.collections

fun main() {
    val joao = Funcionario("João", 2000.0, "CLT")
    val pedro = Funcionario("Pedro", 1500.0, "PJ")
    val maria = Funcionario("Maria", 4000.0, "CLT")

    val funcionarios = listOf(joao, pedro, maria)  // Cria lista com os objetos da classe

    funcionarios.forEach{ println(it) }  // It se torna a instancia do objeto alocado na lista

    println("-------------")
    println(funcionarios.find {it.nome == "Maria"} )

    println("-------------")
    funcionarios
        .sortedBy { it.salario }
        .forEach { println(it) }  // Organiza baseado no atributo passado

    println("-------------")
    funcionarios
        .groupBy { it.tipoContracao }
        .forEach { println(it) }  // Agrupa por tipo de atributo (Retorna um mapa)


    // List da api-collection não é mutável

}



