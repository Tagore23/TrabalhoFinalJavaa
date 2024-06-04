package Models;

public class Cliente {

    private String nome, email;
    private Integer idade, telefone;

    // Método para cadastrar o cliente
    public Cliente(String nome, Integer idade, String email, Integer telefone) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
    }

    // Retornar os dados do cliente
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getTelefone() {
        return telefone;
    }
}
