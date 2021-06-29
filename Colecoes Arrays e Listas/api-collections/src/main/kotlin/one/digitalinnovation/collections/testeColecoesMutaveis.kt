package one.digitalinnovation.collections

fun main() {
    val joao = Funcionario("João", 2000.0, "CLT")
    val pedro = Funcionario("Pedro", 1500.0, "PJ")
    val maria = Funcionario("Maria", 4000.0, "CLT")

    println("-------LIST--------")
    val funcionarios = mutableListOf(joao, maria)  // Cria a lista mutavel, Contem as mesmas operações de uma lista
    funcionarios.forEach{ println(it) }

    println("---------------")
    funcionarios.add(pedro)  // Adiciona valores
    funcionarios.forEach { println(it) }

    println("---------------")
    funcionarios.remove(joao)  // retira valores
    funcionarios.forEach { println(it) }

    println("-------SET--------")
    val funcionariosSet = mutableSetOf(joao)  // Cria o set mutavel
    funcionariosSet.forEach{ println(it) }

    println("---------------")
    funcionariosSet.add(pedro)  // Adiciona valores
    funcionariosSet.add(maria)
    funcionariosSet.forEach{ println(it) }

    println("---------------")
    funcionariosSet.remove(maria)
    funcionariosSet.forEach{ println(it) }


}