package br.org.tabajara.bytebank.testes

import br.org.tabajara.bytebank.modelos.Endereco
import java.lang.IllegalStateException

fun testaNullables() {
    println("inicio main")
    var enderecoNaoNulo: Endereco? = Endereco(logradouro = "teste", complemento = "andar 123")
    var enderecoNulo: Endereco? = null
    var enderecoNaoNulo2 = enderecoNaoNulo!!
    println(enderecoNaoNulo?.logradouro)


    enderecoNaoNulo?.let {
        println(it.logradouro)
        println(it.logradouro.length)
        println(it.logradouro.length.toChar())
        val tamanhoComplemento: Int = it.complemento?.length ?: throw IllegalStateException("Complemento nulo")
        println("Complemento: $tamanhoComplemento")
    }

    teste(enderecoNaoNulo)
}

fun teste(valor:Any){
    val end: Endereco? = valor as? Endereco
    println(end)
}

