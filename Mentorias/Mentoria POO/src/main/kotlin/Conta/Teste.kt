package Conta

import Cliente.ClientePf
import Cliente.ClientePj
import Cliente.Endereco

fun main() {
    val conta = ContaPoupança(123, "001")
    conta.depositar(50.0)

    println("saldo: ${conta.getSaldo()}")
    println(conta.toString())
    println("${conta.taxa()}")

    println("--------------")

    val contaCorrente = ContaCorrente(321, "002")
    conta.depositar(10.0)

    conta.transferir(contaCorrente, 10.0)
    println("${contaCorrente.taxa()}")
    println("${conta.taxa()}")

    println("--------------")

    val endereco = Endereco("Rua Jacira", 222, "Barão Geraldo", "Apartamento 01")
    val clienteJoao = ClientePf(endereco, conta, "JoãoWoigt" , 23)
    clienteJoao.imprimirDados()

    println("--------------")

    val endereco2 = endereco.copy(complemento = null)
    val clienteLuizCarol = ClientePj(endereco2, conta, "17.847.117/0001-08", "MasterChef")
    clienteLuizCarol.imprimirDados()

}