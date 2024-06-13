package Controllers;

import Models.Gerente;
import Models.Recepcionista;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FuncionarioController {
    private static final Logger logger = LogManager.getLogger(FuncionarioController.class);

    public void verInfoGerente() {
        Gerente gerente = new Gerente();
        gerente.verInfo();
    }

    public void cadastrarRecepcionista(String nome, double salario, int horasmensais) {
        logger.info("Cadastro de Recepcionista");

        Recepcionista recepcionista = new Recepcionista(nome, salario, horasmensais);
        recepcionista.verInfo();
    }
}
