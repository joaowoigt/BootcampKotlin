package one.digitalinnovation.collections

fun main() {
    val salarios = DoubleArray(3)  // Funciona igual o IntArray, precisa de capacidade
    salarios[0] = 1000.0
    salarios[1] = 3000.0
    salarios[2] = 500.0

    salarios.forEach {
        println(it)
    }

    println("------------")
    // motificar o valor de cada posição
    salarios.forEachIndexed{index, salario ->
        salarios[index] = salario * 1.1

    }

    println("------------")
    salarios.forEach {
        println(it)
    }

    println("------------")
    val salarios2 = doubleArrayOf(1500.0 , 1250.0, 5000.0) // Forma menos verbosa, ingual intArrayOf

    salarios2.sort()
    salarios2.forEach { println(it) }
}