package Models;

public class Gerente extends Funcionario{

    public Gerente() {
        this.setNome("João");
        this.setSalario(5000.00);
        this.setHorasmensais(160);
    }

    @Override
    public void verInfo() {
        System.out.println("Informações do gerente:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Salário: " + this.getSalario());
        System.out.println("Horas Mensais: " + this.getHorasmensais());
    }
}
