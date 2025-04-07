package Tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {
    private static Scanner in = new Scanner(System.in);

    /**
     * Método para validar se é interger ou não
     *
     * @return escolha
     */
    public static int numValidation(int minEscolha, int maxEscolha) {
        while (true) {
            try {
                if (minEscolha == 0)
                    System.out.print(color.RED + "(0 para sair)" + color.RED + " ▶ " + color.RESET);
                else System.out.print(color.RED + "▶ " + color.RESET);

                int escolha = in.nextInt();
                in = new Scanner(System.in);

                if (escolha >= minEscolha && escolha <= maxEscolha) return escolha;
                else throw new InputMismatchException();

            } catch (InputMismatchException e) {
                System.out.println("Opção invalida!\n");
                in = new Scanner(System.in);
            }
        }
    }

    public static class color {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset
        // Regular Colors
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
    }
}
