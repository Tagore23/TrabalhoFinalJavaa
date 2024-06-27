package Controllers;

import Daos.FuncionarioDAO;
import Models.Funcionario;
import Models.Gerente;
import Models.FuncionarioGeral;
import View.MainView;

import java.util.List;

public class FuncionarioController {
    private MainView view;
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioController(MainView view, FuncionarioDAO funcionarioDAO) {
        this.view = view;
        this.funcionarioDAO = funcionarioDAO;
    }

    public void cadastrarFuncionario() {
        String nome = view.getNomeFuncionario();
        double salario = view.getSalarioFuncionario();
        int horasMensais = view.getHorasMensaisFuncionario();
        String funcao = view.getFuncaoFuncionario();

        // Gerar um novo ID único
        int id = gerarNovoId();

        Funcionario funcionario;
        if (funcao.equalsIgnoreCase("Gerente")) {
            funcionario = new Gerente();
        } else {
            funcionario = new FuncionarioGeral(id, nome, salario, horasMensais, funcao);
        }
        funcionarioDAO.cadastrarFuncionario(funcionario);
        view.mostrarFuncionarioCadastrado(funcionario);
    }

    private int gerarNovoId() {
        List<Funcionario> funcionarios = funcionarioDAO.lerFuncionarios();
        int maxId = 0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() > maxId) {
                maxId = funcionario.getId();
            }
        }
        return maxId + 1;
    }

    public void verificarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioDAO.lerFuncionarios();
        view.mostrarFuncionariosCadastrados(funcionarios);
    }

    public void verInfoGerente() {
        List<Funcionario> funcionarios = funcionarioDAO.lerFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Gerente) {
                Gerente gerente = (Gerente) funcionario;
                gerente.exibirInformacoes();
                return;
            }
        }
        view.mostrarMensagem("Nenhum gerente encontrado.");
    }
}
