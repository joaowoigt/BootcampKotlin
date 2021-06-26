package main.kotlin.DigiOneBank

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    val senha: String
)
    : Funcionario(nome, cpf, salario), Logavel {
    override fun calculoAuxilio(): Double = salario * 0.4  // Função que abstrata definida para gerente

    override fun login(): Boolean = "123" == senha // Função da interface


}