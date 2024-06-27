package Hotel;

import Controllers.ClienteController;
import Controllers.FuncionarioController;
import Controllers.QuartoController;
import Daos.ClienteDAO;
import Daos.FuncionarioDAO;
import Daos.QuartoDAO;
import Models.Gerente;
import View.MainView;
import View.QuartoView;

public class Main {
    public static void main(String[] args) {
        MainView view = new MainView();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO("funcionarios.txt");
        ClienteDAO clienteDAO = new ClienteDAO("clientes.txt");
        QuartoDAO quartoDAO = new QuartoDAO("quartos.txt");

        FuncionarioController funcionarioController = new FuncionarioController(view, funcionarioDAO);
        ClienteController clienteController = new ClienteController(view, clienteDAO);
        QuartoController quartoController = new QuartoController(new QuartoView(), quartoDAO, clienteDAO);
        Gerente gerente = new Gerente();

        int opcao;
        do {
            opcao = view.mostrarMenuPrincipal();
            switch (opcao) {
                case 1:
                    clienteController.cadastrarCliente();
                    break;
                case 2:
                    clienteController.removerCliente();
                    break;
                case 3:
                    clienteController.verificarCadastros();
                    break;
                case 4:
                    gerente.verInfo();
                    break;
                case 5:
                    funcionarioController.cadastrarFuncionario();
                    break;
                case 6:
                    funcionarioController.verificarFuncionarios();
                    break;
                case 7:
                    quartoController.start();
                    break;
                case 8:
                    view.mostrarMensagem("Saindo...");
                    break;
                default:
                    view.mostrarMensagem("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 8);
    }
}
