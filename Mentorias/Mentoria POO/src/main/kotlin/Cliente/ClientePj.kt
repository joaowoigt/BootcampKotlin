package Cliente

import Conta.Conta

class ClientePj(
    endereco: Endereco,
    conta: Conta,
    val cnpj: String,
    val razaoSocial: String
) :Cliente(endereco, conta) {

    override fun imprimirDados() {  // Implementando a função abstrata
        println("""
            Razão Social:   $razaoSocial,
            CNPJ:           $cnpj,
            Endereço:       $endereco"
            
        """.trimIndent()  )
    }
}