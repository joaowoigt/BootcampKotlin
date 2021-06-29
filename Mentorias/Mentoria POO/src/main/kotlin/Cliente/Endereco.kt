package Cliente

data class Endereco(  // Classe para facilitar o controle dos endereços
    val rua: String,
    val numero: Int,
    val bairro: String,
    val complemento: String? = null
)
