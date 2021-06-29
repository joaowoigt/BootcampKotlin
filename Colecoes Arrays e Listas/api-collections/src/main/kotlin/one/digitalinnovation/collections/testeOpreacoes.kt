package one.digitalinnovation.collections

fun main() {
    val salarios = doubleArrayOf(1000.0, 2250.0, 4000.0)

    for (salario in salarios) {
        println(salario)
    }

    println("------------------")
    println("Maior Salario: ${salarios.maxOrNull()}")  // Retornar o maior valor da array
    println("Menor Salarios: ${salarios.minOrNull()}")  // Retorna o menor valor da array
    println("A média dos salarios: ${salarios.average()}") // Retorna a média da array

    println("------------------")
    val salariosMaiorQue2500 = salarios.filter{ it > 2500.0}  // Filtra baseado no predicado passado
    salariosMaiorQue2500.forEach{ println(it) }

    println("------------------")
    println(salarios.count { it in 2000.0..5000.0 })  // Conta quantos salarios que estão no range passado

    println("------------------")
    println(salarios.find { it == 2250.0 })  // Procura o valor que responda a condição
    println(salarios.find { it == 500.0})  // Procura o valor que responda a condição

    println("------------------")
    println(salarios.any { it == 1000.0 })  // Retorna true se qualquer valor cumprir a condição
    println(salarios.any { it == 500.0 })  // Retorna true se qualquer valor cumprir a condição
}