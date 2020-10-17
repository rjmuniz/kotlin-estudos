package br.org.tabajara.bytebank.testes

fun testaFor() {
    for (i in 1..3)
        println(i)

    loop123@ for (i in 10 downTo 0 step 2) {
        if (i == 6) continue
        if (i == 2) break@loop123

        println(i)
    }
}