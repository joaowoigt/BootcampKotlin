package Cliente

import Conta.Conta

abstract class Cliente(
    val endereco: Endereco,  // Puxando da classe endereço para não causar confusão
    val conta: Conta,  // Puxando de Conta

    ){
    val segmento: Segmento  // Definir o segmento de cada conta a partir da condição
    get() = if(conta.getSaldo() < 10.0) {
        Segmento.CLASSICO
    }else {
        Segmento.VAN_GOGH
    }

    abstract fun imprimirDados()


}