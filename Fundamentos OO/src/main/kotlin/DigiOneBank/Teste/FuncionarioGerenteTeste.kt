package main.kotlin.DigiOneBank.Teste

import main.kotlin.DigiOneBank.Analista
import main.kotlin.DigiOneBank.Funcionario
import main.kotlin.DigiOneBank.Gerente


fun main() {
    val milleny = Gerente("Milleny","123.123.123-12", 5000.0)
    ImprimeRelatorioFuncionario.imprime(milleny)

}
