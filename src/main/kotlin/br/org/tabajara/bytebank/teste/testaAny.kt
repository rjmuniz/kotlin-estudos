package br.org.tabajara.bytebank.teste
import br.org.tabajara.bytebank.modelo.Endereco

fun testaAny() {
    testSmartCast(Msg("teste"))

    imprime(Any() as Unit)
    imprime(2)
    imprime(1.0)
    imprime(Endereco())
}

fun imprime(valor: Any?) {
    println(valor)
}
class Msg(val msg:String)

fun testSmartCast (obj: Any)
{
    if(obj is Msg)
    {
        print(obj.msg)
    }
    else
    {
        obj as Msg
        print(obj.msg)
    }
}

