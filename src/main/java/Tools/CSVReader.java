package Tools;

import Domain.Atracoes;
import Domain.Custos;
import Domain.Login;
import Domain.Vendas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {

    /**
     * Lemos ficheiro do logins
     *
     * @param filePath
     * @return Login repositorio
     */
    public static ArrayList<Login> loginRepository(String filePath) throws FileNotFoundException {

        ArrayList<Login> loginArray = new ArrayList<>();

        Scanner sc = new Scanner(new File(filePath));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] linhas = line.split(",");
            // Criamos objeto com a data do ficheiro
            Login login = new Login(linhas[0], linhas[1], linhas[2]);
            loginArray.add(login);
        }
        return loginArray;
    }

    /**
     * Lemos ficheiro das atracoes
     *
     * @param filePath
     * @return Atrações repositorio
     */
    public static ArrayList<Atracoes> atracoesRepository(String filePath) throws FileNotFoundException {

        ArrayList<Atracoes> atracoesArray = new ArrayList<>();

        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] linhas = line.split(";");
            // Criamos objeto com a data do ficheiro
            Atracoes atracoes = new Atracoes(
                    Integer.parseInt(linhas[0]),
                    linhas[1],
                    Double.parseDouble(linhas[2]),
                    Double.parseDouble(linhas[3]),
                    Integer.parseInt(linhas[4])
            );
            atracoesArray.add(atracoes);
        }
        return atracoesArray;
    }

    /**
     * Lemos ficheiro dos custos
     *
     * @param filePath
     * @return Custos repositorio
     */
    public static ArrayList<Custos> custosRepository(String filePath) throws FileNotFoundException {

        ArrayList<Custos> custosArray = new ArrayList<>();

        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] linhas = line.split(";");
            // Criamos objeto com a data do ficheiro
            Custos custos = new Custos(
                    Integer.parseInt(linhas[0]),
                    Double.parseDouble(linhas[1]),
                    Double.parseDouble(linhas[2])
            );
            custosArray.add(custos);
        }
        return custosArray;
    }

    /**
     * Lemos ficheiro das vendas
     *
     * @param filePath
     * @return Vendas repositorio
     */
    public static ArrayList<Vendas> vendasRepository(String filePath) throws FileNotFoundException {
        ArrayList<Vendas> vendasArray = new ArrayList<>();

        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] linhas = line.split(";");
            // Criamos objeto com a data do ficheiro
            Vendas vendas = new Vendas(
                    Integer.parseInt(linhas[0]),
                    linhas[1],
                    linhas[2]
            );
            vendasArray.add(vendas);
        }
        return vendasArray;
    }
}
