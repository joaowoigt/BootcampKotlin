package one.digitalinnovation.collections

fun main() {
    val values = IntArray(5)  // Criando Arrays (precisa por a capacidade da array)
    // Iniciando cada posição com um valor
    values[0] = 1
    values[1] = 7
    values[2] = 6
    values[3] = 3
    values[4] = 2

    for (valor in values){
        println(valor)
    }
    println("------------------")
    // recurso lambda do kotlin para fazer iteração. Variavel ja vem com o nome "it"
    values.forEach { valor ->  // Muda o nome da variavel
        println(valor)
    }
    println("------------------")
    // Iterar sobre os indices do Array
    for (index in values.indices){
        println(values[index])
    }
    println("------------------")
    // Organiza em ordem crescente os valores da Array
    values.sort()
    for (valor in values){
        println(valor)
    }
}