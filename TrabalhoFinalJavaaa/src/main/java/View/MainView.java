package View;

import Models.Cliente;
import Models.Recepcionista;
import java.util.List;
import java.util.Scanner;

public class MainView {
    private Scanner scanner;

    public MainView() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("=============================");
        System.out.println("1- Cadastrar cliente: ");
        System.out.println("2- Remover cliente: ");
        System.out.println("3- Verificar cadastros: ");
        System.out.println("4- Verificar dados do gerente: ");
        System.out.println("5- Cadastrar recepcionista: ");
        System.out.println("6- Sair: ");
        System.out.println("=============================");
        System.out.print("Escolha uma opção: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            scanner.next();
        }
        int escolha = scanner.nextInt();
        scanner.nextLine();
        return escolha;
    }

    public String getNomeCliente() {
        System.out.print("Nome: ");
        return scanner.nextLine();
    }

    public int getIdadeCliente() {
        System.out.print("Idade: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            scanner.next();
        }
        int idade = scanner.nextInt();
        scanner.nextLine();
        return idade;
    }

    public String getEmailCliente() {
        System.out.print("E-mail: ");
        return scanner.nextLine();
    }

    public int getTelefoneCliente() {
        System.out.print("Telefone: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            scanner.next();
        }
        int telefone = scanner.nextInt();
        scanner.nextLine();
        return telefone;
    }

    public int getIdClienteParaRemover() {
        System.out.print("Digite o ID do cliente a ser removido: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            scanner.next();
        }
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public void mostrarClienteCadastrado(Cliente cliente) {
        System.out.println("Cliente cadastrado com sucesso:");
        System.out.println(cliente);
    }

    public void mostrarClientesCadastrados(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Clientes cadastrados:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public String getNomeRecepcionista() {
        System.out.print("Nome: ");
        return scanner.nextLine();
    }

    public double getSalarioRecepcionista() {
        System.out.print("Salário: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, insira um valor decimal.");
            scanner.next();
        }
        double salario = scanner.nextDouble();
        scanner.nextLine();
        return salario;
    }

    public int getHorasMensaisRecepcionista() {
        System.out.print("Horas Mensais: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            scanner.next();
        }
        int horasMensais = scanner.nextInt();
        scanner.nextLine();
        return horasMensais;
    }

    public void mostrarRecepcionistaCadastrada(Recepcionista recepcionista) {
        System.out.println("Recepcionista cadastrada com sucesso:");
        System.out.println(recepcionista);
    }
}
