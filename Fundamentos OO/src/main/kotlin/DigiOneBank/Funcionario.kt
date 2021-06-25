package main.kotlin.DigiOneBank



abstract class Funcionario(  // Também é uma abstração
        nome: String,  // Sobreescreve a classe Pessoa
        cpf: String,
        val salario: Double
) : Pessoa(nome, cpf) {  // Funcionario deve herdar as propriedades de pessoa
   protected abstract fun calculoAuxilio(): Double // Função abstrata

   // Muda a função toString para que retorne a formatação passada
   override fun toString(): String = """  
       Nome: $nome
       Cpf: $cpf
       Salario: $salario
       Auxilio: ${calculoAuxilio()}
   """.trimIndent()


}