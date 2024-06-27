package Models;

public class Cliente {
    private int id;
    private String nome;
    private int idade;
    private String email;
    private int telefone;
    private int numeroQuarto;

    public Cliente(int id, String nome, int idade, String email, int telefone, int numeroQuarto) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.numeroQuarto = numeroQuarto;
    }

    public Cliente(String nome, int idade, String email, int telefone) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.numeroQuarto = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                ", numeroQuarto=" + numeroQuarto +
                '}';
    }
}
