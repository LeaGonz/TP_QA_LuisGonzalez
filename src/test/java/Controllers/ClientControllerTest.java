package Controllers;

import Domain.Atracoes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientControllerTest {
    private ClientController clientController;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        clientController = new ClientController("src/test/resources/Cesaeland_atracoes.csv");
    }

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

    @Test
    public void getAtracoesArraySizeTest() {
        ArrayList<Atracoes> atracoes = clientController.getAtracoes();

        assertEquals(10, atracoes.size());
    }

    @Test
    public void segToMinSeg(){
        assertEquals("2:05",clientController.segToMinSeg(125));
        assertEquals("1:30",clientController.segToMinSeg(90));
        assertEquals("4:05",clientController.segToMinSeg(245));
        assertEquals("0:56",clientController.segToMinSeg(56));
        assertEquals("6:10",clientController.segToMinSeg(370));
    }

}