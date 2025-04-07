package Model;

import Domain.Custos;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustosRepository {
    private static CustosRepository instance;

    private ArrayList<Custos> custos;

    private CustosRepository(String path) throws FileNotFoundException {
        this.custos = CSVReader.custosRepository(path);
    }

    /**
     * Singleton para evitar carregar várias vezes os dados do CSV custos
     * @return Única instância do repositório
     */
    public static CustosRepository getInstance(String path) throws FileNotFoundException {
        if (instance == null) {
            instance = new CustosRepository(path);
        }
        return instance;
    }

    public ArrayList<Custos> getCustos() {
        return this.custos;
    }
}
