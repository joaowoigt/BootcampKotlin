package one.digitalinnovation.collections

fun main() {
    val pair: Pair<String, Double> = Pair("João", 1000.0)  // Faz os pares
    val map1 = mapOf(pair)  // Aloca os pares separando Chave e Valor (dicionários em Python)

    map1.forEach{ (k, v) -> println("Chave: $k - Valor: $v" )}  // Tem Chave e Valor

    val map2 = mapOf(
        "Pedro" to 2500.0,
        "Maria" to 3000.0)  // Recurso infix, mais facil de entender

    map2.forEach { k, v -> println("Chave: $k - Valor: $v") }
}