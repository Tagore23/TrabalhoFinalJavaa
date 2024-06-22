package Hotel;

import Controllers.ClienteController;
import Controllers.FuncionarioController;
import Controllers.QuartoController;
import Daos.ClienteDAO;
import Daos.FileManager;
import Daos.QuartoDAO;
import View.MainView;
import View.QuartoView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MainView view = new MainView();
        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteController clienteController = new ClienteController(view, clienteDAO);
        FuncionarioController funcionarioController = new FuncionarioController(view);

        QuartoView quartoView = new QuartoView();
        FileManager fileManager = new FileManager();
        QuartoController quartoController = new QuartoController(quartoView, fileManager);
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
                case 7:
                    quartoController.start();
                    break;
                default:
                    logger.warn("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (escolha != 7);
    }
}