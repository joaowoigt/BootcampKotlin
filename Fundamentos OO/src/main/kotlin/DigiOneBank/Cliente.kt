package main.kotlin.DigiOneBank

class Cliente(
    nome: String,
    cpf: String,
    val clienteTipo: ClienteTipo,
    val senha: String,
) : Pessoa(nome, cpf), Logavel {
    override fun login(): Boolean ="123456" == senha

    // Relatorio para ser impresso exclusivo para cliente
    override fun toString(): String = """  
        Nome:$nome
        Cpf:$cpf
        Tipo:${clienteTipo.descricao}
    """.trimIndent()
}