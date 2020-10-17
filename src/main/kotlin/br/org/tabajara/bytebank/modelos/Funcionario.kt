package br.org.tabajara.bytebank.modelos

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double
) {

    abstract val bonificacao:Double
}