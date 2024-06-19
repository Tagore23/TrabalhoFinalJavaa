package Models;

public class Recepcionista extends Funcionario {



    public Recepcionista(String nome, Double salario, Integer horasmensais) {
        setNome(nome);
        setSalario(salario);
        setHorasmensais(horasmensais);
    }

    @Override
    public void verInfo() {
        System.out.println("Informações do recepcionista:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Salário: " + this.getSalario());
        System.out.println("Horas Mensais: " + this.getHorasmensais());
    }

    @Override
    public String toString() {
        return "Recepcionista{" +
                "nome='" + getNome() + '\'' +
                ", salario=" + getSalario() +
                ", horasmensais=" + getHorasmensais() +
                '}';
    }
}
