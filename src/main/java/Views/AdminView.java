package Views;

import Controllers.AdminController;
import Tools.Tools;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class AdminView {
    AdminController adminController;

    public AdminView() throws FileNotFoundException {
        this.adminController = new AdminController("src/main/resources/Cesaeland_vendas.csv","src/main/resources/Cesaeland_atracoes.csv","src/main/resources/Cesaeland_custos.csv");
    }

    public void adminMenu() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        int escolha;
        do {
            System.out.printf(Tools.color.YELLOW + """
                            
                            🎢 Menu Administrador - Parque Temático CESAELand © 👨‍💻
                            
                            %s1-%s  Consultar o total de todas as vendas
                            %s2-%s  Consultar o total de lucro
                            %s3-%s  Consultar o total de vendas e lucro por mês, de forma tabelar
                            %s4-%s  Consultar a atração mais procurada por adultos (número de bilhetes vendidos)
                            %s5-%s  Consultar a atração mais procurada por crianças (número de bilhetes vendidos)
                            %s6-%s  Consultar a atração mais procurada (número de bilhetes vendidos)
                            %s7-%s  Consultar a atração mais lucrativa (considere o período total)
                            %s8-%s  Consultar a atração menos lucrativa (considere o período total)
                            %s9-%s  Consultar a atração com melhor preço/tempo. Apresenta a atração que custa menos por segundo
                            %s10-%s Adicionar novo login
                            
                            """,
                    Tools.color.GREEN, Tools.color.YELLOW,
                    Tools.color.GREEN, Tools.color.YELLOW,
                    Tools.color.GREEN, Tools.color.RESET,
                    Tools.color.GREEN, Tools.color.YELLOW,
                    Tools.color.GREEN, Tools.color.YELLOW,
                    Tools.color.GREEN, Tools.color.YELLOW,
                    Tools.color.GREEN, Tools.color.RESET,
                    Tools.color.GREEN, Tools.color.RESET,
                    Tools.color.GREEN, Tools.color.RESET,
                    Tools.color.GREEN, Tools.color.RESET);

            escolha = Tools.numValidation(0, 10);

            switch (escolha) {
                case 1:
                    totalVendas();
                    break;
                case 2:
                    totalLucros();
                    break;
                case 3:
                    System.out.println("\nAqui deveria estar o Consultar o total de vendas e lucro por mês, de forma tabelar,\n mas não estão... 🤖");
                    sleep(300);
                    break;
                case 4:
                    atracaoMaisProcurada("adulto");
                    break;
                case 5:
                    atracaoMaisProcurada("crianca");
                    break;
                case 6:
                    atracaoMaisProcurada("tudo");
                    break;
                case 7:
                    System.out.println("\nAqui deveria estar o Consultar a atração mais lucrativa (considere o período total),\n mas não estão... 🤖");
                    sleep(300);
                    break;
                case 8:
                    System.out.println("\nAqui deveria estar o Consultar a atração menos lucrativa (considere o período total),\n mas não estão... 🤖");
                    sleep(300);
                    break;
                case 9:
                    System.out.println("\nAqui deveria estar o Consultar a atração com melhor preço/tempo. \nApresenta a atração que custa menos por segundo, mas não estão... 🤖");
                    sleep(300);
                    break;
                case 10:
                    System.out.println("\nAqui deveria estar o Adicionar novo login, mas não estão... 🤖");
                    sleep(300);
                    break;
                case 0:
                    System.out.println("\nQue tengas un buen día Administrador... 🔙");
                    break;
            }
        } while (escolha != 0);
    }

    /**
     * Mostramos o total de lucros. Vermelho sé foi negativo e amarelo se foi negativo
     */
    private void totalLucros() {
        System.out.println(Tools.color.YELLOW + "\n🎢 Total de Lucro - Parque Temático CESAELand © 🎡\n" + Tools.color.RESET);

        ArrayList<Double> totalVendas = adminController.totalVendas();
        double total = totalVendas.get(3) - adminController.totalGastos();

        if (total < 0) System.out.println("O total de lucros é: " + Tools.color.RED + String.format("%.2f", total) + Tools.color.RESET);
        else System.out.println("O total de lucros é: " + Tools.color.YELLOW + String.format("%.2f", total) + Tools.color.RESET);
    }

    /**
     * Mostramos dependendo do menu selecionado:
     * Atração mais procurada por adultos
     * Atração mais procurada por Crianças
     * Atração mais procurada
     *
     * @param cliente
     */
    private void atracaoMaisProcurada(String cliente) throws InterruptedException {
        String clientType = "";
        if (cliente.equalsIgnoreCase("adulto")) clientType = " por Adultos";
        else if (cliente.equalsIgnoreCase("crianca")) clientType = " por Criancas";

        System.out.println(Tools.color.YELLOW + "\n🎢 Atração mais procurada" + clientType + " - Parque Temático CESAELand © 🎡\n" + Tools.color.RESET);

        // Alimentamos a data passando o parâmetro ao metodo do controller
        ArrayList<String> atracao = adminController.atracaoMaisProcuradaGeral(cliente);

        sleep(200);
        System.out.printf(Tools.color.GREEN + """
                        ------------------------------
                        Nº:                 %s%s%s
                        Atração:            %s%s%s
                        Bilhetes vendidos:  %s%s%s
                        """,
                Tools.color.RESET, atracao.getFirst(), Tools.color.GREEN,
                Tools.color.RESET, atracao.get(1), Tools.color.GREEN,
                Tools.color.RESET, atracao.get(4), Tools.color.GREEN
        );

        switch (cliente) {
            case "adulto":
                System.out.printf("""
                                Preço Adulto:       %s%s €%s
                                ------------------------------
                                """,
                        Tools.color.RESET, atracao.get(2), Tools.color.GREEN
                );
                break;
            case "crianca":
                System.out.printf("""
                                Preço Criança:      %s%s €%s
                                ------------------------------
                                """,
                        Tools.color.RESET, atracao.get(3), Tools.color.GREEN
                );
                break;
            case "tudo":
                System.out.printf("""
                                Preço Adulto:       %s%s €%s
                                Preço Criança:      %s%s €%s
                                ------------------------------
                                """,
                        Tools.color.RESET, atracao.get(2), Tools.color.GREEN,
                        Tools.color.RESET, atracao.get(3), Tools.color.GREEN
                );
                break;
        }
        sleep(500);
    }

    /**
     * Mostramos o total de bilhetes vendidos, total valor adultos,
     * total valor crianças e total valor vendido
     */
    private void totalVendas() throws InterruptedException {
        ArrayList<Double> resultadoTotal = adminController.totalVendas();

        System.out.println(Tools.color.YELLOW + "\n🎢 Total de Vendas - Parque Temático CESAELand © 🎡\n" + Tools.color.RESET);

        sleep(200);
        System.out.printf(Tools.color.GREEN + """
                        🎫    Total Bilhetes Vendidos:   %s%s%s
                        👨‍🦰👩‍🦰  Total Bilhetes Adultos:    %s%s €%s
                        🧒    Total Bilhetes Crianças:   %s%s €%s
                        
                            💶 Total de Vendas %s%s € 💶
                        """,
                Tools.color.RESET, resultadoTotal.getFirst().intValue(), Tools.color.GREEN,
                Tools.color.RESET, resultadoTotal.get(1), Tools.color.GREEN,
                Tools.color.RESET, resultadoTotal.get(2), Tools.color.GREEN,
                Tools.color.RESET, resultadoTotal.get(3)
        );
        sleep(500);

    }


}
