package br.org.tabajara.bytebank.testes

import br.org.tabajara.bytebank.auxiliadores.bigDecimalArrayOf
import br.org.tabajara.bytebank.auxiliadores.media
import br.org.tabajara.bytebank.auxiliadores.somatoria
import java.math.BigDecimal
import java.math.RoundingMode

fun testaArrays() {
    val salarios = bigDecimalArrayOf("1500.00", "2001.123", "10000.00", "5000.00", "7598.11")
    val gastoInicial = salarios.somatoria()
    gastoInicial.toString().print()

    val meses = "6".toBigDecimal()
    val gastoTotal = salarios.fold(gastoInicial){
        acc, salario->
        (acc + salario * meses).setScale(2, RoundingMode.UP)
    }
    gastoTotal.toString().print()

    salarios.fold(gastoInicial){
            acc, salario->
        (acc + salario * meses).setScale(2, RoundingMode.UP)
    }



    val maioresSalarios = salarios
        .sorted()
        .takeLast(3)
        .toTypedArray()
    maioresSalarios.joinToString(",").print()
    maioresSalarios.media().toString().print()

}


fun String.print() {
    println(this)
}

fun arrayObjetos() {
    val salarios = bigDecimalArrayOf("1500.00", "2001.123", "10000.00")
}

private fun testaMap() {
    val salarios = bigDecimalArrayOf("1500.00", "2001.123", "10000.00")
    println(salarios.contentToString())
    val aumento = "1.1".toBigDecimal()
    val aumentoMinimo = "500.0".toBigDecimal()
    val novosSalarios =
        salarios.map { salario ->
            calculaSalario(salario, aumentoMinimo, aumento)
        }.toTypedArray()

    println(novosSalarios.contentToString())
}

private fun calculaSalario(
    salario: BigDecimal,
    aumentoMinimo: BigDecimal,
    aumento: BigDecimal
) = (if (salario < "5000.0".toBigDecimal()) salario + aumentoMinimo else salario * aumento).setScale(
    2,
    RoundingMode.UP
)

private fun testaArrayBigDecimal() {
    val salarios = Array<BigDecimal>(5) { BigDecimal.ZERO }
    salarios[0] = "1500.55".toBigDecimal()
    salarios[1] = "2000.00".toBigDecimal()
    salarios[2] = "150.".toBigDecimal()
    salarios[3] = "150.55".toBigDecimal()
    salarios[4] = "150.55".toBigDecimal()
    println(salarios.contentToString())
}


private fun agregacoes() {
    val idades: IntArray = intArrayOf(10, 12, 18, 33, 40, 67)
    val maiorIdade: Int? = idades.maxOrNull()
    val menorIdade = idades.minOrNull()

    val somatoria = idades.sum()
    val media = idades.average()
    println("Média: $media")

    val todosMaiores = idades.all { it >= 18 }
    val algumMaiores = idades.any { it >= 18 }
    val nenhumMaiores = idades.none() { it >= 18 }
    println("todosMaiores $todosMaiores")
    println("algumMaiores $algumMaiores")
    println("nenhumMaiores $nenhumMaiores")

    val listaDeMaiores = idades.filter { it >= 18 }
    println(listaDeMaiores)

    val found = idades.find { it >= 18 }
    println("found $found")
}

private fun ranges() {
    val series1: IntRange = 0.rangeTo(100)
    val series2: IntRange = 0..100
    val series3: IntProgression = 0..100 step 2
    val series4: IntRange = 0.until(100);//vai até 99
    val series5 = 100 downTo 0 step 2
    println(series3.joinToString(separator = ",", prefix = "[", postfix = "]"))


    val intervalo = 1500.0..5000.0
    val salario = 4000.0
    if (salario in intervalo)
        println("salario no intervalo")

    val alfabeto = 'A'..'z'
    println(alfabeto.joinToString(","))
    if ('k' in alfabeto) {
        println("K faz parte do alfabeto")
    }
}

private fun iteraPeloIndex() {
    val salarios = doubleArrayOf(1500.20, 2300.0, 5000.0, 8000.00, 10000.00)

    val aumento = 1.1

    /*for(i in salarios.indices){
       salarios[i] *= aumento
    }
    println(salarios.contentToString())*/

    salarios.forEachIndexed { index, d -> salarios[index] = d * aumento }
    println(salarios.contentToString())
}


fun minEMaxManual() {
    val idades: IntArray = intArrayOf(25, 19, 33, 20, 55)

    var maiorIdade = Int.MIN_VALUE
    for (idade in idades) {
        if (idade > maiorIdade)
            maiorIdade = idade
    }
    println(maiorIdade)

    var menorIdade = Int.MAX_VALUE
    idades.forEach { i ->
        if (i < menorIdade)
            menorIdade = i
    }
    println(menorIdade)
}