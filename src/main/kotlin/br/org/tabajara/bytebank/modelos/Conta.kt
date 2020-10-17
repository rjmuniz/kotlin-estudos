package br.org.tabajara.bytebank.modelos

import br.org.tabajara.bytebank.excessoes.FalhaAutenticacaoExcessao
import br.org.tabajara.bytebank.excessoes.SaldoInsuficienteExcessao


const val initCountValue: Int = 0

abstract class Conta(
    val titular: Cliente,
    val numeroConta: Int = 1001
) : Autenticavel{
    var saldo: Double
        protected set

    companion object {
        var totalCount: Int = 0
            private set
    }


    init {
        this.saldo = 0.0
        totalCount++
    }
//    val titular: String
//    val numeroConta: Int
//    constructor(titular: String, numeroConta: Int) {
//        this.titular = titular
//        this.numeroConta = numeroConta
//    }


    abstract fun saca(valor: Double)

    fun deposita(valor: Double) {
        this.saldo += valor
    }

    fun transfere(valor: Double, destino: Conta, senha:Int) {
        if (saldo < valor) throw SaldoInsuficienteExcessao("Não foi possivel transferir: $valor, pois a conta só tinha: ${this.saldo}")
        if(!autentica(senha)) throw FalhaAutenticacaoExcessao()

        this.saldo -= valor
        destino.deposita(valor)
    }

    override fun autentica(senha: Int): Boolean {
        return titular.autentica(senha)
    }
}

