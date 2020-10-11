package br.org.tabajara.bytebank.modelo

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    val senha: Int,
    val plr: Double
) : Funcionario(nome, cpf, salario) {

    override val bonificacao: Double
        get() {
            return salario * .1 + salario + plr
        }

    fun autentica(senhaDigitada: Int): Boolean {
        return senhaDigitada == senha
    }
}