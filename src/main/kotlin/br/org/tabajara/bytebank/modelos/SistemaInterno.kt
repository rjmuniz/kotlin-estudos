package br.org.tabajara.bytebank.modelos

class SistemaInterno {
    fun entra(autenticavel: Autenticavel, senha: Int, autenticado: () -> Unit = {}): Boolean {
        if (autenticavel.autentica(senha)) {
            autenticavel.boasVindas()
            autenticado()
            return true
        }

        println("Falha ao autenticar")
        return false
    }

    fun entraComReceptor(autenticavel: Autenticavel, senha: Int, autenticado: SistemaInterno.() -> Unit = {}): Boolean {
        if (autenticavel.autentica(senha)) {
            autenticavel.boasVindas()
            this.autenticado()
            return true
        }

        println("Falha ao autenticar")
        return false
    }

    fun boasVindas(usuario:Nomeado) {
        println("Bem vindo ${usuario.nome}")
    }

}