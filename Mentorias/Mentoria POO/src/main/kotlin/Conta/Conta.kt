package Conta

abstract class Conta (
    open val numero :Int,
    open val agencia :String,
    private var _saldo :Double = 0.0) : MovimentacaoFinanceira // Implementa a interface
{

    abstract fun taxa(): Double  // Taxa para ser definida em cada conta


   open fun temSaldo(valor: Double) : Boolean {  // Função que permitira fazer cada movimentação
       return (_saldo >= valor)
   }

   open fun getSaldo() : Double {  // Get para acessar ao saldo privado
       return _saldo
   }

    override fun sacar(valor: Double) {  // Função de saque
       if (temSaldo(valor)){
           _saldo -= valor
           println("Saque -> Valor: $valor")
       }else {
           println("Saque -> Não há saldo suficiente")
       }
    }

    override fun depositar(valor: Double) {  // Função de deposito
        if (valor > 0) {
            _saldo += valor
            println("Depoisto -> Valor: $valor")
        }else {
            println("Depoisto -> Informe um valor válido para depósito")
        }

    }
                                    // Recebendo outra instancia de Conta como parametro
    override fun transferir(contaBancariaDestino: Conta,valor: Double) {  // Função de transferencia
        if(temSaldo(valor)){
            this.sacar(valor)
           contaBancariaDestino.depositar(valor)
            println("""
                Tranferencia -> Valor: $valor
                Conta origem: ${this.numero} Saldo atual: ${this.getSaldo()}  
                Conta destrino ${contaBancariaDestino.numero} Saldo Atual: ${contaBancariaDestino.getSaldo()}
            """.trimIndent())  // this para referenciar o proprio objeto
        }else {
            println("Transeferencia -> Não foi possivel realizar a transferencia")
        }
    }



}



