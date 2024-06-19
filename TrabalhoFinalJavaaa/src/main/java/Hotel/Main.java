package Hotel;

import Controllers.ClienteController;
import Controllers.FuncionarioController;
import Daos.ClienteDAO;
import Daos.FileManager;
import View.MainView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MainView view = new MainView();
        FileManager fileManager = new FileManager();
        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteController clienteController = new ClienteController(view, clienteDAO);
        FuncionarioController funcionarioController = new FuncionarioController(view);

        int escolha;
        do {
            escolha = view.mostrarMenuPrincipal();
            switch (escolha) {
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
                    funcionarioController.verInfoGerente();
                    break;
                case 5:
                    funcionarioController.cadastrarRecepcionista();
                    break;
                case 6:
                    logger.info("Saindo...");
                    break;
                default:
                    logger.warn("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (escolha != 6);
    }
}
