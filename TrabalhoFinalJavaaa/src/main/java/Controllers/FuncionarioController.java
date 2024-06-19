package Controllers;

import Models.Gerente;
import Models.Recepcionista;
import View.MainView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FuncionarioController {
    private static final Logger logger = LogManager.getLogger(FuncionarioController.class);
    private MainView view;

    public FuncionarioController(MainView view) {
        this.view = view;
    }

    public void verInfoGerente() {
        Gerente gerente = new Gerente();
        gerente.verInfo();
    }

    public void cadastrarRecepcionista() {
        String nome = view.getNomeRecepcionista();
        double salario = view.getSalarioRecepcionista();
        int horasMensais = view.getHorasMensaisRecepcionista();

        Recepcionista recepcionista = new Recepcionista(nome, salario, horasMensais);
        view.mostrarRecepcionistaCadastrada(recepcionista);
    }
}
