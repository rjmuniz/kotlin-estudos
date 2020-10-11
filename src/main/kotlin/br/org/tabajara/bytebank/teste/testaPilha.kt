package br.org.tabajara.bytebank.teste

fun funcao1() {
    println("inicio funcao1")
    funcao2()
    println("fim funcao1")
}

fun funcao2() {
    println("inicio funcao2")
    for (i in 1..5) {
        println("$i")
        throw Exception("ocorreu um erro")
    }
    println("fim funcao2")
}