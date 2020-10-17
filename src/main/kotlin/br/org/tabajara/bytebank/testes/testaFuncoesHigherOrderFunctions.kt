package br.org.tabajara.bytebank.testes

import br.org.tabajara.bytebank.modelos.Autenticavel
import br.org.tabajara.bytebank.modelos.Endereco
import br.org.tabajara.bytebank.modelos.Nomeado
import br.org.tabajara.bytebank.modelos.SistemaInterno

private fun main() {
    //testaLet { println("Passoufun $it") }
    //"asdf".let { ::testaLet}

//    val endereco= Endereco(logradouro = "Rua Franklin do Amaral", numero= 591, bairro = "Vila Nova Cachoeirinha")
//    val enderecoMaisculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println((enderecoMaisculo))
    Endereco().let {
        it
    }

    Endereco(
        logradouro = "Rua Franklin do Amaral",
        numero = 591,
        bairro = "Vila Nova Cachoeirinha"
    ).let { endereco ->
        "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
    }.let(::println)

    "texto de usagem".let(::println)

    listOf(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "Apartamento"),
        Endereco()
    )
        .filter { e -> e.complemento.isNotEmpty() }
        .map { it.complemento }
        .let(::println)

    somaHOF(1, 3, ::println)
    somaHOF(1, 3) {
        println(it)
    }

    val auth = object : Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int): Boolean = senha == this.senha
    }
    SistemaInterno().entra(auth, 1234) {
        println("Realizar Pagamento")

    }

}

fun somaHOF(a: Int, b: Int, resultado: (Int) ->Unit) = resultado(a + b)

