package Daos;

import Models.Quarto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final Logger logger = LogManager.getLogger(FileManager.class);
    private static final String DEFAULT_PATH = "C:\\Java\\TrabalhoFinalJavaa";

    public FileManager() {
        criarDiretorio(DEFAULT_PATH);
    }

    public void criarDiretorio(String caminho) {
        if (caminho == null) {
            logger.error("Caminho de diretório é nulo.");
            return;
        }

        File diretorio = new File(caminho);
        if (!diretorio.exists()) {
            if (diretorio.mkdirs()) {
                logger.info("Diretório criado: " + caminho);
            } else {
                logger.error("Falha ao criar diretório: " + caminho);
            }
        }
    }
}
