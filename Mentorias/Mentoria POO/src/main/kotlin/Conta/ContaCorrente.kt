package Conta

class ContaCorrente(
    override val numero: Int,
    override val agencia: String) :Conta(numero, agencia){  // Herdando da classe mão Conta


    override fun taxa() :Double {  // Taxa sobrescrita
        return 0.00
    }

}





