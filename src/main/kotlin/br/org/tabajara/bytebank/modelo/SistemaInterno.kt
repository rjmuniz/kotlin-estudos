package br.org.tabajara.bytebank.modelo

class SistemaInterno {
    fun entra(autenticavel: Autenticavel, senha:Int): Boolean{
        if(autenticavel.autentica(senha)){
            autenticavel.boasVindas()
            return true
        }

        println("Falha ao autenticar")
        return false
    }

}