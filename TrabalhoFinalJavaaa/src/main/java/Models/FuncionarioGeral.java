package Models;

public class FuncionarioGeral extends Funcionario {
    private String funcao;

    public FuncionarioGeral(int id, String nome, double salario, int horasMensais, String funcao) {
        super(id, nome, salario, horasMensais);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Informações do Funcionário Geral:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Salário: " + getSalario());
        System.out.println("Horas Mensais: " + getHorasMensais());
        System.out.println("Função: " + funcao);
    }

    @Override
    public void verInfo() {

    }

    @Override
    public String toString() {
        return "Funcionário Geral{" +
                "ID=" + getId() +
                ", Nome='" + getNome() + '\'' +
                ", Salário=" + getSalario() +
                ", Horas Mensais=" + getHorasMensais() +
                ", Função='" + funcao + '\'' +
                '}';
    }
}
