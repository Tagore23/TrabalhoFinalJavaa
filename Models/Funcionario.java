package Models;

abstract class Funcionario {

    private String nome;
    private double salario;
    private int horasmensais;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public int getHorasmensais() {
        return horasmensais;
    }
    public void setHorasmensais(int horasmensais) {
        this.horasmensais = horasmensais;
    }

    public abstract void aumento();

}
