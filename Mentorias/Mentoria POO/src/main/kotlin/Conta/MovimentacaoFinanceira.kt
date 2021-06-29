package Conta

interface MovimentacaoFinanceira {  // Interface com a base dos métodos que serão implementadas na
                                    // classe mãe
    fun sacar(valor: Double)

    fun depositar(valor: Double)

    fun transferir(contaBancariaDestino: Conta,valor: Double)


}