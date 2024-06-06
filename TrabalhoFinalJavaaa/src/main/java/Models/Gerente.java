package Models;

public class Gerente extends Funcionario{

    @Override
    public void verInfo() {
        
        System.out.println("Informações do gerente:");

        System.out.println("Nome: "+this.getNome());
        System.out.println("Salario: "+this.getSalario());
        System.out.println("Horas Mensais: "+this.getHorasmensais());
    }
}
