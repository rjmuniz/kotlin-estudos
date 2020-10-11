package br.org.tabajara.bytebank.teste

fun testaListas() {
    val livro1 = Livro(titulo = "Código Da Vinci", autor = "Dan Brown", anoPublicacao = 1999, editora = "abc")
    val livro2 = Livro(titulo = "A Fortaleza", autor = "Dan Brown", anoPublicacao = 1989, editora = "abc")
    val livro3 = Livro(titulo = "Anjos e demonios", autor = "Dan Brown", anoPublicacao = 2000, editora = "abc")
    val livro4 = Livro(titulo = "Há 2000 anos", autor = "Chico Xavier", anoPublicacao = 1970, editora = "FEB")

    val livros: MutableList<Livro> = mutableListOf(livro1, livro2, livro3, livro4)
    livros.add(
        Livro("50 anos depois", autor = "Chico Xavier", 1975, editora = "FEB"))

    println(livros)
    livros.remove(livro3)
    livros.imprimeComMarcadores()

    val sortedList = livros.sorted()
    sortedList.imprimeComMarcadores()

    val sortedList2 = livros.sortedBy { it.titulo }
    sortedList2.imprimeComMarcadores()

    val filtered = livros
        .filter{ it.autor == "Chico Xavier"}
        .sortedBy { it.anoPublicacao }
        .map { it.titulo }
    // filtered.imprimeComMarcadores("Livros do Chico")
    println(filtered)
}
fun List<Livro>.imprimeComMarcadores(msg:String= "lista de livros"){
    val listaRaw = this.joinToString(separator = "\n") {
        " - ${it.titulo} (${it.autor})"
    }
    println("### $msg ###")
            println(listaRaw)

}
fun Any.print(){
    println(this)
}
data class Livro(
    val titulo: String,
    val autor: String,
    val anoPublicacao: Int,
    val editora: String?
): Comparable<Livro> {
    override fun compareTo(other: Livro): Int {
        return this.anoPublicacao.compareTo(other.anoPublicacao)
    }
}