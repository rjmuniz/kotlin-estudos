package br.org.tabajara.bytebank.testes

import br.org.tabajara.bytebank.modelos.Cliente
import br.org.tabajara.bytebank.modelos.Conta
import br.org.tabajara.bytebank.modelos.ContaCorrente

private fun testaObjects() {
    val cli1 = Cliente(nome = "cl", cpf = "1", senha = 1)
    val cc = ContaCorrente(cli1, numeroConta = 1)
    val cp = ContaCorrente(cli1, numeroConta = 1)
    val cp1 = ContaCorrente(cli1, numeroConta = 1)
    val cp2 = ContaCorrente(cli1, numeroConta = 1)
    val cp3 = ContaCorrente(cli1, numeroConta = 1)

    println("total = ${Conta.totalCount}")
}