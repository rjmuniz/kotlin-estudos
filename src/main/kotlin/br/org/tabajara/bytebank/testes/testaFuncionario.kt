package br.org.tabajara.bytebank.testes

import br.org.tabajara.bytebank.modelos.Analista
import br.org.tabajara.bytebank.modelos.CalculadoraBonificacao
import br.org.tabajara.bytebank.modelos.Diretor
import br.org.tabajara.bytebank.modelos.Gerente

fun testaFuncionario() {

    val ger = Gerente(nome = "Ricardo", cpf = "123123", salario = 10000.0, senha = 123456)
    println("Ger salario ${ger.salario}, bonificacao ${ger.bonificacao}")
    val anl = Analista(nome = "Ricardo", cpf = "123123", salario = 50000.0)
    println("Anl salario ${anl.salario}, bonificacao ${anl.bonificacao}")
    val dir = Diretor(nome = "Ricardo", cpf = "123123", salario = 50000.0, senha = 123456, plr = 100000.0)
    println("Dir salario ${dir.salario}, bonificacao ${dir.bonificacao}")

    println("Ger aut ${ger.autentica(123456)}")
    println("Ger 1 ${ger.autentica(1)}")

    val calc = CalculadoraBonificacao()
    calc.registra(ger).registra(dir).registra(anl)
    println(calc.total)
}