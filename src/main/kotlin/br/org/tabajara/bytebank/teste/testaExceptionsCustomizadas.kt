package br.org.tabajara.bytebank.teste

import br.org.tabajara.bytebank.exception.FalhaAutenticacaoException
import br.org.tabajara.bytebank.exception.SaldoInsuficienteException
import br.org.tabajara.bytebank.modelo.Cliente
import br.org.tabajara.bytebank.modelo.ContaCorrente

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
    } catch (e: SaldoInsuficienteException) {
        e.printStackTrace()
    } catch (e: FalhaAutenticacaoException) {
        e.printStackTrace()
    } catch (e: Exception) {
        println("Generic ${e.message}")
    } finally {
        println("c1.saldo=${c1.saldo}-c2.saldo=${c2.saldo} ")
    }
    //funcao1()
    println("fim main")
}