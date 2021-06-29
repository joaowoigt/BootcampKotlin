package Conta

class ContaPoupança(
    override val numero: Int,
    override val agencia: String
    ) :Conta(numero, agencia) {


    override fun taxa() :Double {  // Taxa sobrescrita
        return 0.50
    }

    override fun transferir(contaBancariaDestino: Conta, valor: Double) {  // Transferencia tem uma função
        super.transferir(contaBancariaDestino, valor +taxa())         // diferente
    }

    override fun toString(): String {  // toString tem uma função diferente
        return "ContaPoupança (numero=$numero, agencia= $agencia)"
    }
}