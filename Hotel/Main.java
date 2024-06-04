package Hotel;
import FileManager.Filemanager;
import Models.Cliente;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("=============================");
            System.out.println("1- Cadastrar cliente: ");
            System.out.println("2- Funcionario: ");
            System.out.println("3- Gerente: ");
            System.out.println("4- Quarto: ");
            System.out.println("5- Verificar cadastros: ");
            System.out.println("6- Sair: ");
            System.out.println("=============================");

                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        cadastrarCliente();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        verificarCadastros();
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha novamente.");
                        break;
                }

        } while (escolha != 6);

        scanner.close();
    }


    public static void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de Cliente");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        Integer idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        Integer telefone = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Cliente cliente = new Cliente(nome, idade, email, telefone);

        // Lista os dados do cliente
        System.out.println("Cliente cadastrado com sucesso:");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Idade: " + cliente.getIdade());
        System.out.println("E-mail: " + cliente.getEmail());
        System.out.println("Telefone: " + cliente.getTelefone());

        Filemanager fileManager = new Filemanager();
        fileManager.escreverDetalhes("clientes.txt", "Cadastro de Cliente - Nome: " + cliente.getNome() + ", Idade: " + cliente.getIdade() + ", E-mail: " + cliente.getEmail() + ", Telefone: " + cliente.getTelefone());
    }


    private static void verificarCadastros() {
        Filemanager fileManager = new Filemanager();
        List<Cliente> clientes = fileManager.lerClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Clientes cadastrados:");
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Idade: " + cliente.getIdade());
                System.out.println("E-mail: " + cliente.getEmail());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println();
            }
        }
    }
}
