package View;

import Models.Quarto;

import java.util.Scanner;

public class QuartoView {
    private Scanner scanner;

    public QuartoView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayQuartos(Quarto[] quartos) {
        System.out.println("Opções de Quartos Disponíveis:");
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
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

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Mostrar Quartos");
        System.out.println("2. Remover Quarto");
        System.out.println("3. Sair");
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
}
