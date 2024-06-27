package Models;

public abstract class Funcionario {
    private int id;
    private String nome;
    private double salario;
    private int horasMensais;

    public Funcionario(int id, String nome, double salario, int horasMensais) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.horasMensais = horasMensais;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public int getHorasMensais() {
        return horasMensais;
    }


    public abstract String getFuncao();


    public abstract void exibirInformacoes();

    public abstract void verInfo();
}
