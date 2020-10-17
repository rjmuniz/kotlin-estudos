package br.org.tabajara.bytebank.testes

import br.org.tabajara.bytebank.modelos.*

fun main() {
    //testaWith()
    //testaRun()
    somaSemReceiver(12, 32, resultado = { println(it) })
    somaSemReceiver(12, 32, resultado = (::println))
    somaComReceiver(12, 32, resultado = { println(this) })
    somaComReceiver(12, 32, resultado = (::println))


    val auth = object : Autenticavel , Nomeado{
        val senha = 1234
        override fun autentica(senha: Int): Boolean = senha == this.senha
        override val nome: String = "José"
    }
    SistemaInterno().entra(auth, 1234) {
        println("Realizar Pagamento")
    }
    SistemaInterno().entraComReceptor(auth, 1234) {
        println("Realizar Pagamento")
        this.boasVindas(auth)
    }
}

fun somaSemReceiver(a: Int, b: Int, resultado: (Int) -> Unit) {
    val soma = a + b
    resultado(soma)
}

fun somaComReceiver(a: Int, b: Int, resultado: Int.() -> Unit) {
    val soma = a + b
    soma.resultado()
}

private fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("Taxa Mensal: $taxaMensal")

    val contaPoupanca = ContaPoupanca(Cliente(nome = "Ricardo", cpf = "123.456.676-00", senha = 1234), 1111)
    contaPoupanca.run {
        deposita(1000.0)
        saldo * taxaMensal
    }.let { rendimentoMensal ->
        println("rendimento mensal: $rendimentoMensal")
    }

    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) {
            saldo += saldo * taxaMensal
            println("Mês $it = $saldo")
        }
        saldo
    }
    println("rendimento Anual: $rendimentoAnual")
}

private fun testaWith() {
    val enderecoCompleto = with(Endereco()) {
        logradouro = "Rua Do Socorro"
        numero = 123
        complemento = "casa 133"
        bairro = "Imirim"
        cidade = "Sampa"
        estado = "SP"
        cep = "12345-678"
        completo()
    }.let { enderecoCompleto: String -> println(enderecoCompleto) }
}


