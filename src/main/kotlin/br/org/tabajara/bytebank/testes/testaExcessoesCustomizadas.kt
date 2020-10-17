package br.org.tabajara.bytebank.testes

import br.org.tabajara.bytebank.excessoes.FalhaAutenticacaoExcessao
import br.org.tabajara.bytebank.excessoes.SaldoInsuficienteExcessao
import br.org.tabajara.bytebank.modelos.Cliente
import br.org.tabajara.bytebank.modelos.ContaCorrente

fun testaExceptionsCustomizadas() {
    val cl = Cliente("nome", cpf = "cpf", 123)
    val c1 = ContaCorrente(cl, 1001)
    val c2 = ContaCorrente(cl, 1003)
    c1.deposita(100.0)
    try {
        println("c1.saldo=${c1.saldo}-c2.saldo=${c2.saldo} ")
        c1.transfere(100.0, c2, 123)
        println("transferencia realizada com sucesso")
        30 / 0
    } catch (e: SaldoInsuficienteExcessao) {
        e.printStackTrace()
    } catch (e: FalhaAutenticacaoExcessao) {
        e.printStackTrace()
    } catch (e: Exception) {
        println("Generic ${e.message}")
    } finally {
        println("c1.saldo=${c1.saldo}-c2.saldo=${c2.saldo} ")
    }
    //funcao1()
    println("fim main")
}