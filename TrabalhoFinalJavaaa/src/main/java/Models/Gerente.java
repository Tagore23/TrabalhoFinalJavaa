package Models;

public class Gerente extends Funcionario {

    public Gerente() {
        super(1, "João", 5000.00, 160);
    }

    @Override
    public String getFuncao() {
        return "Gerente";
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Informações do gerente:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Salário: " + getSalario());
        System.out.println("Horas Mensais: " + getHorasMensais());
    }

    @Override
    public void verInfo() {
        exibirInformacoes();
    }
}
