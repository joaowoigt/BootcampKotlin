package Cliente

import Conta.Conta

class ClientePf (
    endereco: Endereco,
    conta: Conta,
    val nome: String,
    val idade: Int,
) :Cliente(endereco, conta) {  // Herdando da classe mãe

    override fun imprimirDados() {  // Implementando a função abstrata
        println("""
           Nome:    $nome, 
           Conta:   ${conta.numero},
           Segmento:$segmento,
           Endereço:$endereco
        """.trimIndent())
    }
}