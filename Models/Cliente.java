package Models;

public class Cliente {

    private String nome, email;
    private Integer idade;
    private double telefone;

    //Método para cadastrar o aluno
    public Cliente(String nome, Integer idade, String email, double telefone) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
    }

//Retorna os dados do aluno


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdade() {
        return idade;
    }

    public double getTelefone() {
        return telefone;
    }
}