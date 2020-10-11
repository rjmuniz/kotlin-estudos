package br.org.tabajara.bytebank.teste

fun testaProblemasComListas() {
    val livros: MutableList<Livro> = mutableListOf(
        Livro(titulo = "Código Da Vinci", autor = "Dan Brown", anoPublicacao = 1999, editora = "abc"),
        Livro(titulo = "A Fortaleza", autor = "Dan Brown", anoPublicacao = 1989, editora = "abc"),
        Livro(titulo = "Anjos e demonios", autor = "Dan Brown", anoPublicacao = 2000, editora = null),
        Livro(titulo = "Há 2000 anos", autor = "Chico Xavier", anoPublicacao = 1970, editora = "FEB"),
        Livro("50 anos depois", autor = "Chico Xavier", 1975, editora = "FEB")
    )

    livros
        .groupBy { it.editora?:"Sem Editora" }
        .forEach{ (editora, listaLivros)->
            println(" ${editora} livros: ${listaLivros.map { it.titulo }}")
        }
       // .forEach{            println(" ${it.key} livros: ${it.value.map { it.titulo }}")        }
}

fun List<Livro?>.imprimeComMarcadores(msg: String = "lista de livros") {
    val listaRaw = this
        .filterNotNull()//filter {it != null
        .joinToString(separator = "\n") {
            " - ${it.titulo} (${it.autor})"
        }
    println("### $msg ###")
    println(listaRaw)

}