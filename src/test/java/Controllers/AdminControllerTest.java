package Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {
    private AdminController adminController;
    private AdminController adminControllerControlo;


    @BeforeEach
    void setUp() throws FileNotFoundException {
        adminController = new AdminController("src/test/resources/Cesaeland_vendas.csv", "src/test/resources/Cesaeland_atracoes.csv", "src/test/resources/Cesaeland_custos.csv");

        adminControllerControlo = new AdminController("src/test/resources/Cesaeland_vendasControlo.csv", "src/test/resources/Cesaeland_atracoesControlo.csv", "src/test/resources/Cesaeland_custosControlo.csv");
    }

    @Test
    public void totalVendasTest() {
        ArrayList<Double> totalVendas = adminController.totalVendas();

        assertEquals(10, totalVendas.getFirst());   //Total Bilhetes Vendidos
        assertEquals(50, totalVendas.get(1));       //Total Bilhetes Adultos
        assertEquals(13, totalVendas.get(2));       //Total Bilhetes Crianças
        assertEquals(63, totalVendas.getLast());    //Total de Vendas

    }

    @Test
    public void totalVendasArraySizeTest() {
        ArrayList<Double> totalVendas = adminController.totalVendas();

        assertEquals(4, totalVendas.size());        //Tamanho max do ArrayList

    }
}
