package br.org.tabajara.bytebank.modelos

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int
) : FuncionarioAdmin(
    nome,
    cpf,
    salario,
    senha
) {
    override val bonificacao: Double
        get() {
            return salario * .1 + salario
        }
}