package br.org.tabajara.bytebank.modelo

class ContaPoupanca(
    titular: Cliente,
    numeroConta: Int
) : Conta(
    titular = titular,
    numeroConta = numeroConta
) {
    override fun saca(valor: Double) {
        if (saldo >= valor) saldo -= valor
    }
}