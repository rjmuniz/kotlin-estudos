package br.org.tabajara.bytebank.teste

import br.org.tabajara.bytebank.modelo.Cliente
import br.org.tabajara.bytebank.modelo.ContaCorrente
import br.org.tabajara.bytebank.modelo.ContaPoupanca

fun testaContas() {
    val cc = ContaCorrente(Cliente("CC","cpf", 123), 1000)
    val cp = ContaPoupanca(Cliente("CP","cpf",321), 12345678)
    cc.deposita(1000.0)
    cp.deposita(1000.0)

    cc.saca(100.0)
    cp.saca(100.0)
    println("saldo cc: ${cc.saldo}")
    println("saldo cp: ${cp.saldo}")

    cc.transfere(100.00, cp, 123)
    println("saldo cc apos transf: ${cc.saldo}")
    println("saldo cp apos transf: ${cp.saldo}")

    cp.transfere(100.00, cc,321)
    println("saldo cc apos transf: ${cc.saldo}")
    println("saldo cp apos transf: ${cp.saldo}")
}