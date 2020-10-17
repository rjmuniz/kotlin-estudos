package br.org.tabajara.bytebank.testes

import br.org.tabajara.bytebank.modelos.Endereco
import java.lang.ClassCastException
import java.lang.NumberFormatException


private fun testaExceptions() {

    try {
        println("iniciando div/0")
        val div0 = 10 / 0
    } catch (e: ArithmeticException) {
        println(e.message)
    } finally {
        println("Terminado div/0")
    }
    try {
        println("Iniciando ClassCastException")
        val end: Endereco = Any() as Endereco
    } catch (e: ArithmeticException) {
        println("aritm ${e.message}")
    } catch (e: ClassCastException) {
        println(e.printStackTrace())
    } finally {
        println("Terminado ClassCastException")
    }

    val i: Int? = try {
        "iouoiuouoio".toInt()
    } catch (e: NumberFormatException) {
        null
    }
    println(i)

    val valor = when {
        i == null -> println("Valor <NULL>")
        i == 0 -> println("Valor 0")
        i == 2 -> println("Valor 2")
        else -> println("Caiu no else")
    }
    val valor2 = when (i) {
        null -> println("Valor <NULL>")
        0 -> println("Valor 0")
        2 -> println("Valor 2")
        else -> println("Caiu no else")
    }
}
