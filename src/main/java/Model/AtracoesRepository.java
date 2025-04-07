package Model;

import Domain.Atracoes;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AtracoesRepository {
    private static AtracoesRepository instance;

    private ArrayList<Atracoes> atracoes;

    private AtracoesRepository(String path) throws FileNotFoundException {
        this.atracoes = CSVReader.atracoesRepository(path);
    }

    /**
     * Singleton para evitar carregar várias vezes os dados do CSV atracoes
     * @return Única instância do repositório
     */
    public static AtracoesRepository getInstance(String path) throws FileNotFoundException {
        if (instance == null) {
            instance = new AtracoesRepository(path);
        }
        return instance;
    }

    /**
     * Função para devolver toda a informação do CSV
     * @return Lista de Atracoes
     */
    public ArrayList<Atracoes> getAtracoes() {
        return this.atracoes;
    }
}
