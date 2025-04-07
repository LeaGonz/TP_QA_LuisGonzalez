package Controllers;

import Domain.Atracoes;
import Domain.Vendas;
import Model.AtracoesRepository;
import Model.VendasRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EngController {
    private VendasRepository vendasRepository;
    private AtracoesRepository atracoesRepository;

    /**
     * Criamos os nossos repositórios com as datas
     */
    public EngController(String vendasPath, String atracoesPath) throws FileNotFoundException {
        this.vendasRepository = VendasRepository.getInstance(vendasPath);
        this.atracoesRepository = AtracoesRepository.getInstance(atracoesPath);
    }

    /**
     * Função para calcular os bilhetes faltantes para a próxima revisão
     * Usamos ArrayList
     * @return Arraylist ordenada de: revisoes
     */
    public ArrayList<ArrayList<String>> proximasRevisoes() {
        ArrayList<ArrayList<String>> revisoes = new ArrayList<>();

        int bilhetesTotal = 0;
        // Preenchemos as atrações
        for (Atracoes atracao : atracoesRepository.getAtracoes()) {
            revisoes.add(new ArrayList<>());
            revisoes.getLast().add(String.valueOf(atracao.getId()));
            revisoes.getLast().add(atracao.getAtracao());

            // Contagem de bilhetes vendidos
            for (Vendas venda : vendasRepository.getVendas()) {
                if (venda.getIdAtracao() == atracao.getId()) {
                    bilhetesTotal++;
                }
            }

            // Calculo bilhetes faltantes
            int bilhetesFaltantes = 50 - (bilhetesTotal % 50);
            if (bilhetesFaltantes == 50) bilhetesFaltantes = 0;

            // Adicionamos ao array
            revisoes.getLast().add(String.valueOf(bilhetesFaltantes));

            // Reiniciamos contador
            bilhetesTotal = 0;
        }

        // Ordenamos o arraylist (Bubble sort)
        for (int i = 0; i < revisoes.size() - 1; i++) {
            for (int j = 0; j < revisoes.size() - i - 1; j++) {
                int valor1 = Integer.parseInt(revisoes.get(j).get(2));
                int valor2 = Integer.parseInt(revisoes.get(j + 1).get(2));

                if (valor1 > valor2) {
                    ArrayList<String> temp = revisoes.get(j);
                    revisoes.set(j, revisoes.get(j + 1));
                    revisoes.set(j + 1, temp);
                }
            }
        }
        return revisoes;
    }
}

