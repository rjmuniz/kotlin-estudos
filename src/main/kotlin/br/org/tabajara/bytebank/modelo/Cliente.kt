package br.org.tabajara.bytebank.modelo

class Cliente(
    val nome: String,
    val cpf: String,
    val senha: Int,
    val endereco: Endereco = Endereco(),
) : Autenticavel {


     override fun autentica(senha: Int): Boolean {
         println("${this.senha} == $senha")
         return this.senha == senha
    }
}