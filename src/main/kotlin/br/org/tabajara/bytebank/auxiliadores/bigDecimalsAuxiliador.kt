package br.org.tabajara.bytebank.auxiliadores

import java.math.BigDecimal
import java.math.RoundingMode


fun Array<BigDecimal>.media(): BigDecimal {
    return if(this.isEmpty()) BigDecimal.ZERO else this.somatoria() / this.size.toBigDecimal()

}
fun Array<BigDecimal>.somatoria(): BigDecimal {
    val somatoria = this.reduce { acumulador, valor -> acumulador + valor }
    return somatoria.setScale(2, RoundingMode.UP)
}
fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
    val arr = Array(valores.count()) { i ->
        valores[i].toBigDecimal()
    }
    return arr
}
