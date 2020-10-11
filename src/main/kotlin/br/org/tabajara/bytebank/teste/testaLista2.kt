package br.org.tabajara.bytebank.teste

fun testaListas2() {
    val prateleira = Prateleira(
        genero = "Espirita",
        listOf(
            Livro(titulo = "Há 2000 anos", autor = "Chico Xavier", anoPublicacao = 1970, editora = "FEB"),
            Livro("50 anos depois", autor = "Chico Xavier", 1975, editora = "FEB")
        )
    )

    prateleira.organizarPorTitulo().imprimeLista()
    prateleira.organizarPorAno().imprimeLista()
}
fun List<Livro>.imprimeLista(msg:String= "lista de livros"){
    val listaRaw = this.joinToString(separator = "\n") {
        " - ${it.titulo} (${it.autor})"
    }
    println("### $msg ###")
    println(listaRaw)

}

data class Prateleira(
    val genero: String,
    val livros: List<Livro>
) {
    fun organizarPorTitulo(): List<Livro> {
        return livros.sortedBy { it.titulo }
    }

    fun organizarPorAno(): List<Livro> {
        return livros.sortedBy { it.anoPublicacao }
    }
}
