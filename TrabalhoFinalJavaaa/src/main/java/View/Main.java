package View;

import Controllers.ClienteController;
import Controllers.FuncionarioController;
import Daos.ClienteDAO;
import Daos.Filemanager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Filemanager fileManager = new Filemanager();
        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteController clienteController = new ClienteController(clienteDAO);
        FuncionarioController funcionarioController = new FuncionarioController();

        int escolha;
        do {
            exibirMenu();
            escolha = lerOpcoesMenu(scanner);
            processaEscolhaUsuario(scanner, escolha, clienteController, funcionarioController);
        } while (escolha != 6);
    }

    private static void exibirMenu() {
        System.out.println("=============================");
        System.out.println("1- Cadastrar cliente: ");
        System.out.println("2- Remover cliente: ");
        System.out.println("3- Verificar cadastros: ");
        System.out.println("4- Verificar dados do gerente: ");
        System.out.println("5- Cadastrar recepcionista: ");
        System.out.println("6- Sair: ");
        System.out.println("=============================");
    }

    private static int lerOpcoesMenu(Scanner scanner) {
        int escolha = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                entradaValida = true;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.println("Por favor, insira um valor inteiro válido.");
            }
        } while (!entradaValida);
        return escolha;
    }

    private static void processaEscolhaUsuario(Scanner scanner, int op, ClienteController clienteController, FuncionarioController funcionarioController) {
        switch (op) {
            case 1:
                cadastrarCliente(scanner, clienteController);
                break;
            case 2:
                removerCliente(scanner, clienteController);
                break;
            case 3:
                clienteController.verificarCadastros();
                break;
            case 4:
                funcionarioController.verInfoGerente();
                break;
            case 5:
                cadastrarRecepcionista(scanner, funcionarioController);
                break;
            case 6:
                logger.info("Saindo...");
                break;
            default:
                System.out.println("Opção invalida! Escolha uma opção de acordo com o menu.");
                break;
        }
    }

    private static void cadastrarCliente(Scanner scanner, ClienteController clienteController) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = lerInteiro(scanner);

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        int telefone = lerInteiro(scanner);

        clienteController.cadastrarCliente(nome, idade, email, telefone);
    }

    private static void removerCliente(Scanner scanner, ClienteController clienteController) {
        System.out.print("Digite o ID do cliente a ser removido: ");
        int id = lerInteiro(scanner);
        clienteController.removerCliente(id);
    }

    private static void cadastrarRecepcionista(Scanner scanner, FuncionarioController funcionarioController) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Salário: ");
        double salario = lerDouble(scanner);

        System.out.print("Horas Mensais: ");
        int horasmensais = lerInteiro(scanner);

        funcionarioController.cadastrarRecepcionista(nome, salario, horasmensais);
    }

    private static int lerInteiro(Scanner scanner) {
        int valor = 0;
        boolean entradaValida = false;
        do {
            try {
                valor = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                entradaValida = true;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.println("Por favor, insira um valor inteiro válido.");
            }
        } while (!entradaValida);
        return valor;
    }

    private static double lerDouble(Scanner scanner) {
        double valor = 0.0;
        boolean entradaValida = false;
        do {
            try {
                valor = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer do scanner
                entradaValida = true;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.println("Por favor, insira um valor decimal válido.");
            }
        } while (!entradaValida);
        return valor;
    }
}
