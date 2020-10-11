package br.org.tabajara.bytebank.modelo

interface Autenticavel {
    //val senha:Int
    fun autentica(senha: Int): Boolean
    fun boasVindas(){
        println("[br.org.tabajara.bytebank.modelo.Autenticavel]bem vindo ao sistema")
    }
}