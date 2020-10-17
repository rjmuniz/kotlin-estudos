package br.org.tabajara.bytebank.testes

import java.time.LocalDate
import java.time.Period


fun testaDataClass() {
    val pessoa = Pessoa("Ricardo", LocalDate.of(1981, 6, 9))
    val doc = DocumentoRG("2002002")
    val (nome) = pessoa
    val (rg) = doc
    println("rg = $rg")
    pessoa.fala()
    pessoa.nascimento()
    println(pessoa.idade)
    println(pessoa)
    println(doc)
}

class Pessoa(val nome:String, val dtNasc: LocalDate){
    val idade:Int
        get(){
            return Period.between(dtNasc, LocalDate.now()).years
        }
    fun fala(){
        println("Emite som")
    }
    fun nascimento()
    {
        println(dtNasc.toString())
    }
    operator fun component1() = this.nome
}
data class DocumentoRG(val rg:String="RG", val cpf:String = "CPF")