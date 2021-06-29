package one.digitalinnovation.collections

fun main() {
    val joao = Funcionario("João", 2000.0, "CLT")
    val pedro = Funcionario("Pedro", 1500.0, "PJ")
    val maria = Funcionario("Maria", 4000.0, "CLT")

    // Cria instancias de set (conjunto)
    val funcionarios1 = setOf(joao, pedro)
    val funcionarios2 = setOf(maria)


    val resultUnion = funcionarios1.union(funcionarios2)  // Une os dois conjuntos
    resultUnion.forEach{ println(it) }

    println("----------------")
    val funcionarios3 = setOf(joao, pedro, maria)
    val resultSubtracti = funcionarios3.subtract(funcionarios2)  // Retira os valores iguais dos conjuntos
    resultSubtracti.forEach{ println(it) }

    println("----------------")
    val resultIntercect = funcionarios3.intersect(funcionarios2)  // Retorna apenas o que há de igual
    resultIntercect.forEach { println(it) }

}