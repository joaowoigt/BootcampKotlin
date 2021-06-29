package one.digitalinnovation.collections

fun main() {
    val values = intArrayOf(2, 3, 4, 1, 10, 7) // Não precisa declarar a capacidade da array para ser inicializado


    values.forEach {
        println(it)
    }

    println("----------------")
    values.sort()
    values.forEach {
        println(it)
    }
}