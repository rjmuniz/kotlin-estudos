package br.org.tabajara.bytebank.teste

import kotlin.collections.mutableMapOf as mutableMapOf

fun main() {
    //exemploDeListaMutavel()
    //exemploDeListaReadOnly()
    //testaBancoDeNomes()
    // testaSetOperators()
    //Map
    //readMap()
    //writeMap()
    //specialMap()
    //operationsWithMaps()

    val pedidos = listOf(
        Pedido(1, 20.0),
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(10, 70.0),
    )
    println(pedidos)

    val mapFrete = pedidos.associateWith { p -> p.valor > 50 }
    println(mapFrete)
    println("com frete grátis: ${mapFrete.filterValues { it }}")
    println("sem frete grátis: ${mapFrete.filterValues { !it }}")

    //val filteredMap = pedidos.associateBy { it.valor >50.0 }
    //println(filteredMap)

    val grouped = pedidos.groupBy { it.valor >50.0 }
    println(grouped)
    println(grouped[true])
    println(grouped[false])

   val listaNomes = listOf<String>("alex", "André", "Brendha","Simone","")
    println(listaNomes.groupBy { (it.firstOrNull()?:'n').toUpperCase() })
}

private fun operationsWithMaps() {
    val pedidos = listOf(
        Pedido(1, 20.0),
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(10, 70.0),
    )
    println(pedidos)
    var i: Int = 0
    //val mapPedidos = pedidos.associate { Pair(it.numero, it)}
    //val mapPedidos = pedidos.associate { i++ to it }
    val mapPedidos = pedidos.associateBy { i++ }
    println(mapPedidos)


    val mapFrete = pedidos.associateWith { p -> p.valor > 50 }
    println(mapFrete)
    println("com frete grátis: ${mapFrete.filterValues { it }}")
    println("sem frete grátis: ${mapFrete.filterValues { !it }}")
}

data class Pedido(val numero: Int, val valor: Double)

private fun specialMap() {
    val map = mutableMapOf(
        1 to 20.0,
        2 to 21.0,
        Pair(3, 102.2),
        4 to 100.0,
        5 to 10000.00,
        6 to 50.1
    )
    println(map.get(8))
    try {
        println(map.getValue(8))
    } catch (e: NoSuchElementException) {
        println(e)
    }
    println(map.getOrElse(8, { "Sem pedido" }))
    println(map.getOrDefault(8, -1.00))
    println(map.keys)
    println(map.values)
    val filteredMap = map.filter { (k, v) -> k % 2 == 0 && v > 50.0 }
    println(filteredMap)
    println(map.filterKeys { k -> k in 2..5 })
    println(map.filterKeys { k -> k >= 2 })
    println(map.filterValues { v -> v in 22.0..100.0 })
    val novo = map + mapOf(8 to 20.0)
    println(novo)
    val novo2 = map - 6 //remove
    println(novo2)
    val novo3 = map - listOf(1, 2, 6) //remove
    println(novo3)

    map.putAll(setOf(7 to 10.0, 8 to 9.0)) //add
    map += setOf(7 to 10.0, 8 to 9.0) //add
    map += 1 to 10000000.0
    map.plusAssign(listOf<Pair<Int, Double>>(7 to 10.0, 8 to 9.0)) //add

    map.keys.remove(3)
    map -= 6
    println(map)
}

private fun writeMap() {
    var map = mutableMapOf(
        "1" to 20.0,
        "2" to 21.0,
        Pair("3", 102.2)
    )
    println(map)
    map["3"]?.let {
        println("valor $it")
    }
    for (mapItem: Map.Entry<String, Double> in map) {
        println("${mapItem.key} = ${mapItem.value}")
    }

    map["4"] = 1234.4 //add item
    map.put("5", 1234.4) //add item
    map.forEach { (k, v) -> println("$k = $v") }

    map["4"] = 2.4 //update item
    map.put("5", 2.4) //update item

    map.putIfAbsent("5", 123456.78) //update item
    map.remove("5")
    map.remove("89")
    map.forEach { (k, v) -> println("$k = $v") }
}

private fun readMap() {
    var map = mapOf("1" to 20.0, "2" to 21.0, Pair("3", 102.2))
    println(map)
    map["3"]?.let {
        println("valor $it")
    }
    for (mapItem: Map.Entry<String, Double> in map) {
        println("${mapItem.key} = ${mapItem.value}")
    }
    map.forEach { (k, v) -> println("$k = $v") }
}


private fun testaSetOperators() {
    val familiaAntiga = setOf("Ricardo", "Elsa", "Brendha", "Ricardo Pai", "André")
    val familiaAtual = setOf("Ricardo", "Simone", "Lucas", "Brensha")

    println("Union")
    println(familiaAntiga + familiaAtual)
    println(familiaAntiga union familiaAtual) //infix

    println("subtração")
    println(familiaAntiga - familiaAtual)
    println(familiaAntiga subtract familiaAtual) //infix
    println(familiaAtual subtract familiaAntiga) //infix

    println("intersect")
    println(familiaAntiga intersect familiaAtual) //infix
}

private fun testaSet1() {
    val assistiramCursoAndroid = setOf("Ric", "Ric2")
    val assistiramCursoKotlin = setOf("Ric1", "Ric", "Ric2", "Ric9", "Sim")
    //val assistirAmbos:Set<String> = assistiramCursoAndroid.plus(assistiramCursoKotlin)
    //val assistirAmbos:Set<String> = assistiramCursoAndroid+ assistiramCursoKotlin
    val assistirAmbos: MutableSet<String> = mutableSetOf<String>()
    assistirAmbos.addAll(assistiramCursoAndroid)
    assistirAmbos.addAll(assistiramCursoKotlin)
    println(assistirAmbos)
    println(assistirAmbos.distinct())//desnecessário
}

private fun testaListaCursos() {
    val assistiramCursoAndroid = listOf("Ric", "Ric2")
    val assistiramCursoKotlin = listOf("Ric1", "Ric", "Ric2", "Ric9", "Sim")

//    val assistirAmbos:MutableList<String> = mutableListOf()
//    assistirAmbos.addAll(assistiramCursoAndroid)
//    assistirAmbos.addAll(assistiramCursoKotlin)
    val assistirAmbos: List<String> = assistiramCursoAndroid + assistiramCursoKotlin
    println(assistirAmbos)
    println(assistirAmbos.distinct())
}

private fun testaBancoDeNomes() {
    val banco = BancoDeNomes()
    banco.salva("Ric")
    println(banco.nomes)

    val banco2 = BancoDeNomes()
    println(banco.nomes)
}

class BancoDeNomes {
    companion object {
        private val dados = mutableListOf<String>()
    }

    val nomes: Collection<String> get() = dados.toList()

    fun salva(nome: String) {
        dados.add(nome)
    }


}

private fun exemploDeListaReadOnly() {
    //val nomes: List<String> = listOf("Ric", "sim")
    //val nomes: Collection<String> = listOf("Ric", "sim")
    val nomes: Iterable<String> = setOf("Ric", "sim")
    for (nome in nomes.iterator())
        println(nome)
    println()

    println(nomes);
}

private fun exemploDeListaMutavel() {
    //val nomes: MutableList<String> = mutableListOf("Ric", "sim")
    val nomes: MutableCollection<String> = mutableListOf("Ric", "sim")
    //val nomes: MutableIterable<String> = mutableSetOf("Ric", "sim")
    nomes.add("Teste")
    nomes.remove("sim")
    for (nome in nomes.iterator())
        println(nome)
    println()

    println(nomes);
}