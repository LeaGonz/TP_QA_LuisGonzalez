package Controllers;

import Domain.Atracoes;
import Model.AtracoesRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClientController {
    private AtracoesRepository atracoesRepository;

    /**
     * Criamos o nosso repositório com a data
     */
    public ClientController(String atracoesPath) throws FileNotFoundException {
        this.atracoesRepository = AtracoesRepository.getInstance(atracoesPath);
    }

    /**
     * Metodo para retornar a listagem das atrações
     *
     * @return ArrayList<Atracoes>
     */
    public ArrayList<Atracoes> getAtracoes() {
        return this.atracoesRepository.getAtracoes();
    }

    /**
     * Função para convertir segundos ao formato min:seg
     *
     * @param seg int
     * @return String min:seg
     */
    public String segToMinSeg(int seg) {
        if (seg < 0) return "0:00";

        int min = seg / 60;
        int segrest = seg % 60;

        return min + ":" + String.format("%02d", segrest);
    }
}
