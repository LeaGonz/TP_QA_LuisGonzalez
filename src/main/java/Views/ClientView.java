package Views;

import Controllers.ClientController;
import Domain.Atracoes;
import Tools.Tools;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ClientView {
    ClientController clientController;

    public ClientView() throws FileNotFoundException {
        this.clientController = new ClientController("src/java/resources/Cesaeland_atracoes.csv");
    }

    public void clientMenu() throws InterruptedException {
        int escolha;
        do {
            System.out.printf(Tools.color.YELLOW + """
                            
                            🎢 Menu Cliente - Parque Temático CESAELand © 🎡
                            
                            %s1-%s Consultar Atrações Disponíveis
                            %s2-%s Consultar Atrações Favoritas
                            
                            """,
                    Tools.color.GREEN, Tools.color.YELLOW,
                    Tools.color.GREEN, Tools.color.RESET);

            escolha = Tools.numValidation(0, 2);

            switch (escolha) {
                case 1:
                    atracoesDisponiveis();
                    break;
                case 2:
                    System.out.println("\nAqui deveria estar as Atrações Favoritas, mas não estão... 🤖");
                    sleep(300);
                    break;

                case 0:
                    System.out.println("\nTe vas directo al menu anterior compadre... 🔙");
                    sleep(300);
                    break;
            }
        } while (escolha != 0);
    }

    /**
     * Função para mostrar as atrações disponíveis no formato de tabela
     */
    public void atracoesDisponiveis() throws InterruptedException {
        System.out.println(Tools.color.YELLOW + "\n🎢 Atrações Disponíveis - Parque Temático CESAELand © 🎡\n" + Tools.color.RESET);
        System.out.printf(Tools.color.GREEN + "%-40s | %16s | %16s | %20s%n" + Tools.color.RESET, "ATRAÇÃO", "PREÇO ADULTO", "PREÇO CRIANÇA", "DURAÇÃO (min:seg)");

        ArrayList<Atracoes> atracoes = clientController.getAtracoes();

        for (Atracoes atracao : atracoes) {
            System.out.printf("%-40s | %15s€ | %15s€ | %20s%n",
                    atracao.getAtracao(),
                    atracao.getPrecoAdulto(),
                    atracao.getPrecoCrianca(),
                    clientController.segToMinSeg(atracao.getDuracaoSeg()));
            sleep(200);
        }
    }
}
