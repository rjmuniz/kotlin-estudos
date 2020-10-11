package br.org.tabajara.bytebank.modelo

class CalculadoraBonificacao {
    var total: Double = 0.0
        private set

    fun registra(funcionario: Funcionario): CalculadoraBonificacao {
        this.total += funcionario.bonificacao
        return this
    }
}