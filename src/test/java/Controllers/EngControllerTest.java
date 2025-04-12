package Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EngControllerTest {
    private EngController engController;

    /**
     * Criamos o ambiente de test antes de cada test
     * @throws FileNotFoundException
     */
    @BeforeEach
    void setUp() throws FileNotFoundException {
        engController = new EngController("src/test/resources/Cesaeland_vendas_EngController.csv", "src/test/resources/Cesaeland_atracoes.csv");
    }

    /**
     * Testa o primeiro elemento da lista de próximas revisões
     * Verifica se a atração com maior urgência de revisão está correta
     */
    @Test
    public void proximasRevisoesFirstTest() {
        ArrayList<ArrayList<String>> revisoes = engController.proximasRevisoes();

        assertEquals("9", revisoes.getFirst().getFirst());
        assertEquals("Torre da Nuvem", revisoes.getFirst().get(1));
        assertEquals("46", revisoes.getFirst().get(2));

    }

    /**
     * Testa o segundo elemento da lista de próximas revisões
     * Verifica se a atração com maior urgência de revisão está correta
     */
    @Test
    public void proximasRevisoesSecondTest() {
        ArrayList<ArrayList<String>> revisoes = engController.proximasRevisoes();

        assertEquals("6", revisoes.get(1).getFirst());
        assertEquals("Rio Lento Quality Assurance", revisoes.get(1).get(1));
        assertEquals("47", revisoes.get(1).get(2));

    }

    /**
     * Testa o último elemento da lista de próximas revisões
     * Verifica se a atração com maior urgência de revisão está correta
     */
    @Test
    public void proximasRevisoesLastTest() {
        ArrayList<ArrayList<String>> revisoes = engController.proximasRevisoes();

        assertEquals("2", revisoes.get(2).getFirst());
        assertEquals("Casa Assombrada de Projeto Final", revisoes.get(2).get(1));
        assertEquals("48", revisoes.get(2).get(2));

    }

    /**
     * Testa o tamanho da lista completa de próximas revisões
     */
    @Test
    public void proximasRevisoesArraySizeTest() {
        ArrayList<ArrayList<String>> revisoes = engController.proximasRevisoes();

        assertEquals(10, revisoes.size());
    }

    /**
     * Testa a estrutura de dados devolvida para cada atração
     * Verifica se cada elemento contém os 3 campos obrigatórios:
     * 0 - ID da atração
     * 1 - Nome da atração
     * 2 - Número de bilhetes faltantes para revisão
     */
    @Test
    public void proximasRevisoesArrayStructureTest() {
        ArrayList<ArrayList<String>> revisoes = engController.proximasRevisoes();

        for (ArrayList<String> revisao : revisoes) {
            assertEquals(3, revisao.size());
        }
    }

}