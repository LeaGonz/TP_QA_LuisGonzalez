package Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {
    private AdminController adminController;
    private AdminController adminControllerControlo;

    /**
     * Criamos o ambiente de test antes de cada test
     * @throws FileNotFoundException
     */
    @BeforeEach
    void setUp() throws FileNotFoundException {
        adminController = new AdminController("src/test/resources/Cesaeland_vendas.csv", "src/test/resources/Cesaeland_atracoes.csv", "src/test/resources/Cesaeland_custos.csv");

    }

    /**
     * Testa o método totalVendas()
     * Verificamos o total de bilhetes vendidos, quantidade de bilhetes de adultos, crianças e total de vendas
     */
    @Test
    public void totalVendasTest() {
        ArrayList<Double> totalVendas = adminController.totalVendas();

        assertEquals(10, totalVendas.getFirst());   //Total Bilhetes Vendidos
        assertEquals(50, totalVendas.get(1));       //Total Bilhetes Adultos
        assertEquals(13, totalVendas.get(2));       //Total Bilhetes Crianças
        assertEquals(63, totalVendas.getLast());    //Total de Vendas

    }

    /**
     * Testa o tamanho do ArrayList devolvido pelo método totalVendas()
     */
    @Test
    public void totalVendasArraySizeTest() {
        ArrayList<Double> totalVendas = adminController.totalVendas();

        assertEquals(4, totalVendas.size());

    }

    /**
     * Testa a atração mais procurada por adultos
     * Verificamos ID, nome e número de bilhetes vendidos
     */
    @Test
    public void atracaoMaisProcuradaGeralAdultoTest() {
        ArrayList<String> atracaoMaisProcurada = adminController.atracaoMaisProcuradaGeral("adulto");

        assertEquals("9", atracaoMaisProcurada.get(0));
        assertEquals("Torre da Nuvem", atracaoMaisProcurada.get(1));
        assertEquals("2", atracaoMaisProcurada.get(4));
    }

    /**
     * Testa a atração mais procurada por crianças
     * Verificamos ID, nome e número de bilhetes vendidos
     */
    @Test
    public void atracaoMaisProcuradaGeralCriancaTest() {
        ArrayList<String> atracaoMaisProcurada = adminController.atracaoMaisProcuradaGeral("crianca");

        assertEquals("3", atracaoMaisProcurada.get(0));
        assertEquals("Trampolins Bases de Dados", atracaoMaisProcurada.get(1));
        assertEquals("1", atracaoMaisProcurada.get(4));
    }

    /**
     * Testa a atração mais procurada considerando todos os tipos de clientes
     * Verificamos ID, nome e número de bilhetes vendidos
     */
    @Test
    public void atracaoMaisProcuradaGeralTudoTest() {
        ArrayList<String> atracaoMaisProcurada = adminController.atracaoMaisProcuradaGeral("tudo");

        assertEquals("3", atracaoMaisProcurada.get(0));
        assertEquals("Trampolins Bases de Dados", atracaoMaisProcurada.get(1));
        assertEquals("2", atracaoMaisProcurada.get(4));
    }

    /**
     * Testa o comportamento com um tipo de cliente inválido
     */
    @Test
    public void atracaoMaisProcuradaGeralInvalidTest() {
        ArrayList<String> atracaoMaisProcurada = adminController.atracaoMaisProcuradaGeral("invalido");

        assertTrue(atracaoMaisProcurada.isEmpty());

    }

    /**
     * Testa o tamanho do array devolvido pelo método atracaoMaisProcuradaGeral
     */
    @Test
    public void atracaoMaisProcuradaGeralTestArraySizeTest() {
        ArrayList<Double> atracaoMaisProcurada = adminController.totalVendas();

        assertEquals(4, atracaoMaisProcurada.size());

    }

    /**
     * Testa o cálculo do total de gastos
     */
    @Test
    void totalGastosTest() {
        assertEquals(3548.5, adminController.totalGastos());
    }
}
