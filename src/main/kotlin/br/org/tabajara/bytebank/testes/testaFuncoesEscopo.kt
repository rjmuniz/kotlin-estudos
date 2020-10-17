package br.org.tabajara.bytebank.testes

import br.org.tabajara.bytebank.modelos.Endereco

fun main() {
    run {
        println("Teste do RUN.. sem parametros")
    }

    "Testa RUN".run {
        println("$this :${length}")
        "retorno LAMBDA -> RUN"
    }.print()

    println()

    "Testa APPLY".apply {
        println("$this :${length}")
        "Devolve o contexto"
    }.print()

    println()

    "Testa LET".let {
        println("$it :${it.length}")
        "retorno LAMBDA LET"
    }.print()

    println()

    "Testa ALSO".also {
        println("$it :${it.length}")
        "Devolve o contexto"
    }.print()

    println()

    "Testa APPLY".apply {
        println("$this :${length}")
        "Devolve o contexto"
    }.print()

    println()

    with("Testa WITH") {
        println("$this :${length}")
        "retorno LAMBDA WITH"
    }.print()

    println()

    val numberList = mutableListOf<Int>()
    val ret = numberList.also { println("Populating the list") }
        .apply {
            add(5)
            add(2)
            add(1)
            add(4)
            add(3)
        }
        .also { println("Sorting the list") }
        .sorted()
        .also(::println)
    println(ret)

    Endereco(logradouro = "rua Franlkin").run { }

    Endereco()
        .also{ println("Configurando o Endereço")}
        .apply {
            logradouro = "Rua Franklin"
            numero = 591
            complemento = "casa 1"
            bairro = "Vila Nova Cachoeirinha"
            estado="SAMPA"
        }.print()
}