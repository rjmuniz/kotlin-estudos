package br.org.tabajara.bytebank.testes

fun main() {

}

fun testaParadigmaFuncional() {

    testaTipo()

}

private fun testaTipo() {
    //inicializacao()
    //inicializaSoma()
    //testaRetornos()

}


fun soma(a: Int, b: Int): Int = a + b


private fun testaLet(bloco: (String) -> Unit) {
    println(bloco("a"))
    println("passou")
}

private fun testaRetornos() {
    val calculaBonicacao: (salario: Double) -> Double = Lambda@{
        if (it >= 1000.0)
            return@Lambda it * 1.1
        return@Lambda it * 1.3
    }
    val calculaBonicacaoAnonima = fun(salario: Double): Double {
        if (salario >= 1000.0)
            return salario * 1.1
        return salario * 1.3
    }
    println(calculaBonicacao(100.0))
    println(calculaBonicacao(1000.0))
    println(calculaBonicacaoAnonima(100.0))
    println(calculaBonicacaoAnonima(1000.0))
}

private fun inicializaSoma() {
    val minhaFuncao: (Int, Int) -> Int = ::soma
    println(minhaFuncao(5, 10))
    val minhaFuncaoClass = SomaClass()
    println(minhaFuncaoClass(1, 2))

    val minhaFuncaoLambda: (Int, Int) -> Int = { a, b -> a + b }
    val minhaFuncaoLambda2 = { a: Int, b: Int -> a + b }
    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a, b): Int { return a + b }
    val minhaFuncaoAnonima2 = fun(a: Int, b: Int): Int { return a + b }



    println(minhaFuncaoLambda(312, 123))
    println(minhaFuncaoLambda2(312, 123))
    println(minhaFuncaoAnonima(1, 3))
    println(minhaFuncaoAnonima2(3, 5))
}

private fun inicializacao() {
    val minhaFuncao: () -> String = ::teste
    val minhaFuncaoClass = Divider()
    val minhaFuncaoLambda: () -> Unit = {}
    val minhaFuncaoLambda2: (String) -> String = { "Hello $it" }
    val minhaFuncaoLambda3: (String) -> String = { name -> "Hello $name" }
    val minhaFuncaoAnonima: (String) -> String = fun(name): String { return "Hello $name" }

    println(minhaFuncao())
    println(minhaFuncaoClass(1, 2))
    println(minhaFuncaoLambda())
    println(minhaFuncaoLambda2("RicardoLambda2"))
    println(minhaFuncaoLambda3("RicardoLambda3"))
    println(minhaFuncaoAnonima("RicardoAnonima"))
}


fun teste(): String = "adsf"
class SomaClass : (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b
}

class Divider : (Int, Int) -> Double {
    override fun invoke(numerator: Int, denominator: Int): Double {
        return numerator / denominator.toDouble()
    }

}