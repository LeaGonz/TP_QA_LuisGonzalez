package Controllers;

import Domain.Atracoes;
import Domain.Custos;
import Domain.Vendas;
import Model.AtracoesRepository;
import Model.CustosRepository;
import Model.VendasRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdminController {
    private VendasRepository vendasRepository;
    private AtracoesRepository atracoesRepository;
    private CustosRepository custosRepository;

    public AdminController(String vendasPath, String atracoesPath, String custosPath) throws FileNotFoundException {
        this.vendasRepository = VendasRepository.getInstance(vendasPath);
        this.atracoesRepository = AtracoesRepository.getInstance(atracoesPath);
        this.custosRepository = CustosRepository.getInstance(custosPath);
    }

    /**
     * Função que calcula o total de bilhetes vendidos
     * O total de valor por bilhetes de adultos
     * O total de valor por bilhetes de crianças
     * E o total valor das vendas de todos os bilhetes
     *
     * @return ArrayList
     */
    public ArrayList<Double> totalVendas() {
        ArrayList<Double> resultadoTotal = new ArrayList<>();
        int bilhetesTotal = 0;
        double adultosTotal = 0;
        double criancasTotal = 0;

        for (Vendas venda : vendasRepository.getVendas()) {
            // Calculo total dos bilhetes vendidos
            bilhetesTotal++;
            for (Atracoes atracao : atracoesRepository.getAtracoes()) {
                if (venda.getIdAtracao() == atracao.getId()) {
                    // Calculo valor bilhete de adultos
                    if (venda.getClient().equalsIgnoreCase("adulto")) {
                        adultosTotal += atracao.getPrecoAdulto();
                        break;
                    }
                    // Calculo valor bilhete de crianças
                    else if (venda.getClient().equalsIgnoreCase("crianca")) {
                        criancasTotal += atracao.getPrecoCrianca();
                        break;
                    }
                }
            }
        }

        // Calculo total do valor dos bilhetes vendidos
        double totalVendas = adultosTotal + criancasTotal;

        resultadoTotal.add((double) bilhetesTotal);
        resultadoTotal.add(adultosTotal);
        resultadoTotal.add(criancasTotal);
        resultadoTotal.add(totalVendas);

        return resultadoTotal;
    }

    /**
     * Função para calcular a atração mais procurada seja adulto/criança ou ambas
     *
     * @param cliente
     * @return ArrayList com id e contagem de bilhetes da atração
     */
    public ArrayList<String> atracaoMaisProcuradaGeral(String cliente) {
        ArrayList<Integer> atracoes = new ArrayList<>();
        ArrayList<Integer> contador = new ArrayList<>();

        // Contabilizamos todas as atrações
        for (Vendas venda : vendasRepository.getVendas()) {
            // Filtramos por tipo de cliente
            if (venda.getClient().equalsIgnoreCase(cliente) || cliente.equals("tudo")) {
                // Adicionamos a atração se não existir e +1 contador
                if (!atracoes.contains(venda.getIdAtracao())) {
                    atracoes.add(venda.getIdAtracao());
                    contador.add(1);
                }
                // Atualizamos contador da atração +1
                else {
                    int i = atracoes.indexOf(venda.getIdAtracao());
                    contador.set(i, contador.get(i) + 1);
                }
            }
        }

        // Procuramos o índice da atração com maior contagem
        int maior = 0;
        for (int i = 0; i < contador.size(); i++) {
            if (contador.get(i) > contador.get(maior)) {
                maior = i;
            }
        }

        ArrayList<String> atracaoFinal = new ArrayList<>();
        for (Atracoes atracao : atracoesRepository.getAtracoes()) {
            if (atracao.getId() == atracoes.get(maior)) {
                atracaoFinal.add(String.valueOf(atracao.getId()));
                atracaoFinal.add(atracao.getAtracao());
                atracaoFinal.add(String.valueOf(atracao.getPrecoAdulto()));
                atracaoFinal.add(String.valueOf(atracao.getPrecoCrianca()));
                atracaoFinal.add(String.valueOf(contador.get(maior)));
                break;
            }
        }
        return atracaoFinal;
    }


    /**
     * Função para calcular o total gastado.
     * Calculamos o total de bilhetes x o custo de manutenção por bilhete
     * E somamos com a quantidade de meses x os meses das vendas registradas
     * @return double Total gastos
     */
    public double totalGastos() {
        ArrayList<Integer> atracoes = new ArrayList<>();
        ArrayList<Integer> contador = new ArrayList<>();
        ArrayList<ArrayList<String>> meses = new ArrayList<>();
        ArrayList<Integer> contadorMeses = new ArrayList<>();

        // Contabilizamos todas as atrações
        for (Vendas venda : vendasRepository.getVendas()) {
            // Adicionamos a atração se não existir e +1 contador
            if (!atracoes.contains(venda.getIdAtracao())) {
                atracoes.add(venda.getIdAtracao());
                contador.add(1);

                meses.add(new ArrayList<>());
                meses.getLast().add(venda.getData());
                contadorMeses.add(1);
            } else {
                // Obtemos o índice da atração
                int i = atracoes.indexOf(venda.getIdAtracao());

                // Atualizamos contador da atração +1
                contador.set(i, contador.get(i) + 1);

                // Atualizamos contador mês
                if (!meses.get(i).contains(venda.getData())) {
                    meses.get(i).add(venda.getData());
                    contadorMeses.set(i, contadorMeses.get(i) + 1);
                }
            }
        }

        // Calculamos total de custos (ManuBilhetes * QtdBilhetes) + (Meses * FixoMês)
        double totalGastos = 0;
        for (Custos custo : custosRepository.getCustos()) {
            int i = atracoes.indexOf(custo.getIdAtracao());
            totalGastos += (custo.getManutencaoBilhete() * contador.get(i)) + (contadorMeses.get(i) * custo.getFixoMes());
        }

        return totalGastos;
    }

}
