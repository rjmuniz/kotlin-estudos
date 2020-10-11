package br.org.tabajara.bytebank.modelo

abstract class FuncionarioAdmin(
    nome: String,
    cpf: String,
    salario: Double,
    val senha: Int
) : Funcionario(nome, cpf, salario), Autenticavel {


    override fun autentica(senha: Int): Boolean {
        return this.senha == senha
    }
}