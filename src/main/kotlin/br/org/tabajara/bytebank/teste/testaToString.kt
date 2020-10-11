package br.org.tabajara.bytebank.teste

import br.org.tabajara.bytebank.modelo.Endereco

private fun testaToString() {
    val a = Endereco()
    println(a)
    val b = Endereco(logradouro = "Rua franklin", numero = 591)
    println(b)
    val c = Endereco(logradouro = "Rua franklin", numero = 591, estado = "SP")
    println(c)

    println(b == c)

    println(b.equals(c))

    println(b.hashCode())
    println(c.hashCode())
}
