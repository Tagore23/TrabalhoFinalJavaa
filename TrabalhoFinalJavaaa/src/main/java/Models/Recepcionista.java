package Models;

public class Recepcionista extends Funcionario{

    private String nome;
    private double salario;
    private int horasmensais;
    private int pontossatisfacao;
    private int horasextras;

    public Recepcionista(String nome, Double salario, Integer horasmensais) {
        this.nome = nome;
        this.salario = salario;
        this.horasmensais = horasmensais;
        this.pontossatisfacao = 0;
        this.horasextras = 0;
    }

    @Override
    public void verInfo() {
        System.out.println("Informações do recepcionista:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Salário: " + this.getSalario());
        System.out.println("Horas Mensais: " + this.getHorasmensais());
    }
    
}
