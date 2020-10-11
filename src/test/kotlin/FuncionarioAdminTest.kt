import br.org.tabajara.bytebank.modelo.FuncionarioAdmin
import br.org.tabajara.bytebank.modelo.Gerente
import br.org.tabajara.bytebank.modelo.SistemaInterno
import junit.framework.TestCase
import org.junit.Test

class FuncionarioAdminTest : TestCase() {

    val func :Gerente = Gerente("func", "aasdfasdf",1000.0,1)
    fun setup(){
        assertNotNull(func)
    }

    @Test
    fun testGetBonificacao() {
        val actual: Double = func.bonificacao
        val expected: Double = 1100.0
        assertEquals(expected, actual)
    }

    @Test
    fun testAutenticaSenhaCorreta() {
        val expected = SistemaInterno().entra(func, 1)
        assertTrue(expected)
    }


    fun testAutenticaSenhaErrada() {
        val expected = SistemaInterno().entra(func, 3)
        print(expected)
        assertFalse(expected)
    }

    @Test
    fun testGetSenha() {
        assert(true)
    }


}