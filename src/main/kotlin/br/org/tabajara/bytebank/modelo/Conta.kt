package br.org.tabajara.bytebank.modelo

import br.org.tabajara.bytebank.exception.FalhaAutenticacaoException
import br.org.tabajara.bytebank.exception.SaldoInsuficienteException


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
        if (saldo < valor) throw SaldoInsuficienteException("Não foi possivel transferir: $valor, pois a conta só tinha: ${this.saldo}")
        if(!autentica(senha)) throw FalhaAutenticacaoException()

        this.saldo -= valor
        destino.deposita(valor)
    }

    override fun autentica(senha: Int): Boolean {
        return titular.autentica(senha)
    }
}

