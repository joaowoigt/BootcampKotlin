package main.kotlin.DigiOneBank.Teste

import main.kotlin.DigiOneBank.Funcionario

class ImprimeRelatorioFuncionario {
    companion object {  // Método estatico para ser invocado via classe nao instancia
        fun imprime(funcionario: Funcionario){  // Método para imprimir o realtorio personalizado
            println(
                funcionario.toString()
            )
        }
    }
}