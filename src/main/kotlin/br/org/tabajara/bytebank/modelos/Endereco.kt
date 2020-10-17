package br.org.tabajara.bytebank.modelos

class Endereco(
    var logradouro: String = "",
    var numero: Int = 1,
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = "SP",
    var complemento: String = "",
    var cep: String = "00000-000"
) {

    override fun toString(): String {
        return "Endereco($logradouro, $numero - $estado)"
    }

    override fun equals(other: Any?): Boolean {
        if (other != null && other is Endereco) {
            return this.logradouro == other.logradouro
        }
        return false
    }

    override fun hashCode(): Int {
        return logradouro.hashCode()
    }

    fun completo(): String {
        return """
            $logradouro, $numero - $complemento
            $bairro
            $cidade - $estado - $cep
        """.trimIndent()
    }

}