package Models;

public class Cliente {
    private int id; // Novo campo ID
    private String nome, email;
    private Integer idade, telefone;

    // Método para cadastrar o cliente com ID
    public Cliente(int id, String nome, Integer idade, String email, Integer telefone) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
    }

    // Retornar os dados do cliente
    public int getId() {
        return id;
    }

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

    @Override
    public String toString() {
        return id + ", " + nome + ", " + idade + ", " + email + ", " + telefone;
    }
}
