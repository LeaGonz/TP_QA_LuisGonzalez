package Controllers;

import Domain.Atracoes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientControllerTest {
    private ClientController clientController;

    /**
     * Criamos o ambiente de test antes de cada test
     * @throws FileNotFoundException
     */
    @BeforeEach
    void setUp() throws FileNotFoundException {
        clientController = new ClientController("src/test/resources/Cesaeland_atracoes.csv");
    }

    /**
     * Testa a primeira atração da lista
     * Verifica o ID, nome, preço adulto, preço criança, duração
     */
    @Test
    void getAtracoesFirstTest() {
        ArrayList<Atracoes> atracoes = clientController.getAtracoes();

        Atracoes atracoesFirst = atracoes.getFirst();
        assertEquals(1, atracoesFirst.getId());
        assertEquals("Montanha Russa da Programacao", atracoesFirst.getAtracao());
        assertEquals(15, atracoesFirst.getPrecoAdulto());
        assertEquals(12, atracoesFirst.getPrecoCrianca());
        assertEquals(180, atracoesFirst.getDuracaoSeg());

    }

    /**
     * Testa a atração do meio da lista
     * Verifica o ID, nome, preço adulto, preço criança, duração
     */
    @Test
    void getAtracoesMiddleTest() {
        ArrayList<Atracoes> atracoes = clientController.getAtracoes();

        Atracoes atracoesMedio = atracoes.get(4);
        assertEquals(5, atracoesMedio.getId());
        assertEquals("Carrossel Web", atracoesMedio.getAtracao());
        assertEquals(4.5, atracoesMedio.getPrecoAdulto());
        assertEquals(3, atracoesMedio.getPrecoCrianca());
        assertEquals(120, atracoesMedio.getDuracaoSeg());
    }

    /**
     * Testa a última atração da lista
     * Verifica o ID, nome, preço adulto, preço criança, duração
     */
    @Test
    void getAtracoesLastTest() {
        ArrayList<Atracoes> atracoes = clientController.getAtracoes();

        Atracoes atracoesLast = atracoes.getLast();
        assertEquals(10, atracoesLast.getId());
        assertEquals("Labirinto do Trabalho em Equipa", atracoesLast.getAtracao());
        assertEquals(7.5, atracoesLast.getPrecoAdulto());
        assertEquals(5, atracoesLast.getPrecoCrianca());
        assertEquals(520, atracoesLast.getDuracaoSeg());
    }

    /**
     * Testa o tamanho da lista de atrações
     */
    @Test
    public void getAtracoesArraySizeTest() {
        ArrayList<Atracoes> atracoes = clientController.getAtracoes();

        assertEquals(10, atracoes.size());
    }

    /**
     * Testa a conversão de segundos para formato mm:ss
     */
    @Test
    public void segToMinSegTest() {
        assertEquals("2:05", clientController.segToMinSeg(125));
        assertEquals("1:30", clientController.segToMinSeg(90));
        assertEquals("4:05", clientController.segToMinSeg(245));
        assertEquals("0:56", clientController.segToMinSeg(56));
        assertEquals("6:10", clientController.segToMinSeg(370));
    }

    /**
     * Testa a conversão de segundos para formato mm:ss
     * em casos limites
     */
    @Test
    void segToMinSegLimitCasesTest() {
        assertEquals("0:00", clientController.segToMinSeg(0));
        assertEquals("0:01", clientController.segToMinSeg(1));
        assertEquals("1:00", clientController.segToMinSeg(60));
        assertEquals("59:59", clientController.segToMinSeg(3599));
        assertEquals("100:00", clientController.segToMinSeg(6000));
    }

    /**
     * Testa a conversão de segundos para formato mm:ss
     * em casos de segundos negativos
     */
    @Test
    void segToMinSegNegativeTest() {
        assertEquals("0:00", clientController.segToMinSeg(-1));
        assertEquals("0:00", clientController.segToMinSeg(-60));
    }

}