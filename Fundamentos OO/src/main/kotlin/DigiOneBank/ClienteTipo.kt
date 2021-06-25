package main.kotlin.DigiOneBank

enum class ClienteTipo(val descricao: String) {  // Objetos internos do Enum são objetos da propria
    pf("Pessoa Fisica"),                // classe que esta
    pj("Pessoa Juridica");              // Pode ter métodos estaticos
}