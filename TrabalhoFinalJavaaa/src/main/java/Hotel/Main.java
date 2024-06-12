package Hotel;

import FileManager.Filemanager;
import Models.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static int clienteID = 1; // Inicializa o ID do cliente

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("=============================");
            System.out.println("1- Cadastrar cliente: ");
            System.out.println("2- Remover cliente: ");
            System.out.println("3- Verificar cadastros: ");
            System.out.println("4- Verificar dados do gerente: ");
            System.out.println("5- Sair: ");
            System.out.println("=============================");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                switch (escolha) {
                    case 1:
                        cadastrarCliente();
                        break;
                    case 2:
                        removerCliente();
                        break;
                    case 3:
                        verificarCadastros();
                        case 4:
                        Gerente();
                        break;
                    case 5:
                        logger.info("Saindo...");
                        break;
                    default:
                        logger.warn("Opção inválida. Escolha novamente.");
                        break;
                }
            } else {
                scanner.next();
                logger.warn("Opção inválida. Escolha novamente.");
                escolha = 0; // Define escolha como 0 para continuar no loop
            }
        } while (escolha != 5);

        scanner.close(); // Fechar o scanner ao finalizar
    }

    public static void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Cadastro de Cliente");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = lerInteiro(scanner);

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        int telefone = lerInteiro(scanner);

        Cliente cliente = new Cliente(clienteID++, nome, idade, email, telefone);

        // Lista os dados do cliente
        logger.info("Cliente cadastrado com sucesso:");
        logger.info("ID: " + cliente.getId());
        logger.info("Nome: " + cliente.getNome());
        logger.info("Idade: " + cliente.getIdade());
        logger.info("E-mail: " + cliente.getEmail());
        logger.info("Telefone: " + cliente.getTelefone());

        Filemanager fileManager = new Filemanager();
        fileManager.escreverDetalhes("clientes.txt", cliente.toString());
    }

    private static void removerCliente() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Digite o ID do cliente a ser removido: ");
        int id = lerInteiro(scanner);
        Filemanager fileManager = new Filemanager();
        boolean removido = fileManager.removerClientePorID("clientes.txt", id);

        if (removido) {
            logger.info("Cliente removido com sucesso.");
        } else {
            logger.warn("Cliente com ID " + id + " não encontrado.");
        }
    }

    private static void verificarCadastros() {
        Filemanager fileManager = new Filemanager();
        List<Cliente> clientes = fileManager.lerClientes();
        if (clientes.isEmpty()) {
            logger.info("Nenhum cliente cadastrado.");
        } else {
            logger.info("Clientes cadastrados:");
            for (Cliente cliente : clientes) {
                logger.info(cliente);
            }
        }
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
                logger.error("Por favor, insira um valor inteiro válido.");
                System.out.print("Tente novamente: ");
            }
        } while (!entradaValida);
        return valor;
    }
 private static void Gerente() {
        Gerente gerente = new Gerente();
        gerente.verInfo();

    }
}
