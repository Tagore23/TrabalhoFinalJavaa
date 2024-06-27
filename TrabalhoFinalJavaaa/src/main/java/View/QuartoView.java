package View;

import Models.Quarto;

import java.util.List;
import java.util.Scanner;

public class QuartoView {
    private Scanner scanner;

    public QuartoView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public int getQuartoNumero() {
        while (true) {
            System.out.print("Digite o número do quarto: ");
            String input = scanner.nextLine();
            try {
                int numero = Integer.parseInt(input);
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
    }

    public int getClienteId() {
        while (true) {
            System.out.print("Digite o ID do cliente: ");
            String input = scanner.nextLine();
            try {
                int id = Integer.parseInt(input);
                return id;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Mostrar Quartos");
        System.out.println("2. Associar Cliente a um Quarto");
        System.out.println("3. Remover Cliente de um Quarto");
        System.out.println("4. Sair");
    }

    public int getMenuOption() {
        while (true) {
            System.out.print("Escolha uma opção: ");
            String input = scanner.nextLine();
            try {
                int option = Integer.parseInt(input);
                return option;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
    }

    public int escolherQuarto(List<Quarto> quartos) {
        while (true) {
            System.out.print("Escolha um número de quarto disponível: ");
            String input = scanner.nextLine();
            try {
                int numero = Integer.parseInt(input);
                for (Quarto quarto : quartos) {
                    if (quarto.getNumero() == numero) {
                        return numero;
                    }
                }
                System.out.println("Número de quarto não encontrado na lista.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
    }
}
