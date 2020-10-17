package br.org.tabajara.bytebank.testes

import br.org.tabajara.bytebank.modelos.Endereco
import kotlin.random.Random

fun main() {

/*
    also - and also do the following with the object
    run - and run the following
    apply - apply the following assignments to the object
    let - used for call chain
    with - with this object, do the following
    public inline fun <T, R> with(receiver: T, block: T.() -> R): R
    public inline fun <T, R> T.let(block: (T) -> R): R
    public inline fun <T, R> T.run(block: T.() -> R): R
    public inline fun <R> run(block: () -> R): R
    public inline fun <T> T.apply(block: T.() -> Unit): T
    public inline fun <T> T.also(block: (T) -> Unit): T
    */


    //testaScopes()


    //takeIf
    val ret1 = "12341234".takeIf { it.isNotEmpty() }
    println("takeIf= $ret1")
    //takeUnless
    val ret2 = "12341234".takeUnless { it.isNotEmpty() }
    println("takeUnless=$ret2")

    val number = Random.nextInt(20)
    val evenOrNull = number.takeIf { it %2 ==0 }
    val oddOrNull = number.takeUnless { it %2 ==0 }
    println("even: $evenOrNull, odd: $oddOrNull")
}

private fun testaScopes() {
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
        .also { println("Configurando o Endereço") }
        .apply {
            logradouro = "Rua Franklin"
            numero = 591
            complemento = "casa 1"
            bairro = "Vila Nova Cachoeirinha"
            estado = "SAMPA"
        }.print()
}