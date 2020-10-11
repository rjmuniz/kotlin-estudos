package br.org.tabajara.bytebank.modelo

class ContaCorrente(
    titular: Cliente,
    numeroConta: Int
) : Conta(
    titular = titular,
    numeroConta = numeroConta
) {
    init{
    }
    override fun saca(valor: Double) {
        val valorComTaxa = valor * 1.1
        this.saldo -= valorComTaxa
    }
}