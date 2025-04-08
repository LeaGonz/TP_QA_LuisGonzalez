package Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EngControllerTest {
    private EngController engController;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        engController = new EngController("src/test/resources/Cesaeland_vendas_EngController.csv", "src/test/resources/Cesaeland_atracoes.csv");
    }

    /**
     * Fazemos 3 test para o método proximasRevisoes()
     * Porque o método devolve o arrayList ordenado
     * Onde as 3 primeiras atrações são as mais proximas para fazer revisão
     * Foi criado o ficheiro "Cesaeland_vendas_EngController.csv" para simplificar o test
     */


    @Test
    public void proximasRevisoesFirstTest() {
        ArrayList<ArrayList<String>> revisoes = engController.proximasRevisoes();

        assertEquals("9", revisoes.getFirst().getFirst());
        assertEquals("Torre da Nuvem", revisoes.getFirst().get(1));
        assertEquals("46", revisoes.getFirst().get(2));

    }

    @Test
    public void proximasRevisoesMiddleTest() {
        ArrayList<ArrayList<String>> revisoes = engController.proximasRevisoes();

        assertEquals("6", revisoes.get(1).getFirst());
        assertEquals("Rio Lento Quality Assurance", revisoes.get(1).get(1));
        assertEquals("47", revisoes.get(1).get(2));

    }

    @Test
    public void proximasRevisoesLastTest() {
        ArrayList<ArrayList<String>> revisoes = engController.proximasRevisoes();

        assertEquals("2", revisoes.get(2).getFirst());
        assertEquals("Casa Assombrada de Projeto Final", revisoes.get(2).get(1));
        assertEquals("48", revisoes.get(2).get(2));

    }

    @Test
    public void proximasRevisoesArraySizeTest() {
        ArrayList<ArrayList<String>> revisoes = engController.proximasRevisoes();

        // ArrayList size
        assertEquals(10, revisoes.size());
    }

    @Test
    public void proximasRevisoesArrayStructureTest() {
        ArrayList<ArrayList<String>> revisoes = engController.proximasRevisoes();

        // ArrayList structure 3 data: id, atração, numBilhetes
        for (ArrayList<String> revisao : revisoes) {
            assertEquals(3, revisao.size());
        }
    }

}