package one.digitalinnovation.collections

class Repositorio<T> {
    private val map = mutableMapOf<String, T>()

    fun create(id: String, value: T) {  // Adiciona valores ao map
        map.put(id, value)
    }

    fun remove(id: String) = map.remove(id)  // Remove valores ao map

    fun findById(id: String) = map.get(id)  // Retorna o valor que esta na chave indicada

    fun findAll() = map.values  // Traz todos os T gravados
}

