package br.org.tabajara.bytebank.teste

import br.org.tabajara.bytebank.modelo.Cliente
import br.org.tabajara.bytebank.modelo.Gerente
import br.org.tabajara.bytebank.modelo.SistemaInterno

fun testaAutenticacao(): Boolean {
    val ger = Gerente(nome = "Ricardo", cpf = "123123", salario = 10000.0, senha = 123456)
    if (SistemaInterno().entra(ger, 123456))
        return true
    return false
}

fun testaAutenticacaoCliente(): Boolean {
    val cli = Cliente(nome = "br.org.tabajara.bytebank.modelo.Cliente 1", cpf = "123123", senha = 654321)
    if (SistemaInterno().entra(cli, 654321)) {
        println("Bem bindo ${cli.nome}")
        return true
    }
    return false
}