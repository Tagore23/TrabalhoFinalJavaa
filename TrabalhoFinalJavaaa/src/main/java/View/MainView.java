package View;

import Models.Cliente;
import Models.Funcionario;
import Models.Gerente;
import Models.Quarto;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuPrincipal() {
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Verificar Cadastros de Clientes");
        System.out.println("4. Ver Info Gerente");
        System.out.println("5. Cadastrar Funcionário");
        System.out.println("6. Verificar Funcionários");
        System.out.println("7. Escolher Quarto");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public String getNomeCliente() {
        System.out.print("Nome do Cliente: ");
        return scanner.next();
    }

    public int getIdadeCliente() {
        System.out.print("Idade do Cliente: ");
        return scanner.nextInt();
    }

    public String getEmailCliente() {
        System.out.print("Email do Cliente: ");
        return scanner.next();
    }

    public int getTelefoneCliente() {
        System.out.print("Telefone do Cliente: ");
        return scanner.nextInt();
    }

    public int getIdClienteParaRemover() {
        System.out.print("ID do Cliente para remover: ");
        return scanner.nextInt();
    }

    public void mostrarClienteCadastrado(Cliente cliente) {
        System.out.println("Cliente cadastrado com sucesso: " + cliente);
    }

    public void mostrarClientesCadastrados(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public String getNomeFuncionario() {
        System.out.print("Nome do Funcionário: ");
        return scanner.next();
    }

    public double getSalarioFuncionario() {
        System.out.print("Salário do Funcionário: ");
        return scanner.nextDouble();
    }

    public int getHorasMensaisFuncionario() {
        System.out.print("Horas Mensais do Funcionário: ");
        return scanner.nextInt();
    }

    public String getFuncaoFuncionario() {
        System.out.print("Função do Funcionário: ");
        return scanner.next();
    }

    public void mostrarFuncionarioCadastrado(Funcionario funcionario) {
        System.out.println("Funcionário cadastrado com sucesso: " + funcionario);
    }

    public void mostrarFuncionariosCadastrados(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarInfoGerente(Gerente gerente) {
        System.out.println("Informações do Gerente:");
        System.out.println("Nome: " + gerente.getNome());
        System.out.println("Salário: " + gerente.getSalario());
        System.out.println("Horas Mensais: " + gerente.getHorasMensais());
    }

    public int escolherQuarto(List<Quarto> quartosDisponiveis) {
        System.out.println("Quartos Disponíveis:");
        for (Quarto quarto : quartosDisponiveis) {
            System.out.println(quarto);
        }
        System.out.print("Digite o número do quarto desejado: ");
        return scanner.nextInt();
    }
}
