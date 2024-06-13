package Daos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;

public class Filemanager {
    private static final Logger logger = LogManager.getLogger(Filemanager.class);
    private static final String DEFAULT_PATH = "C:\\Java\\TrabalhoFinalJavaa";

    public Filemanager() {
        criarDiretorio(DEFAULT_PATH);
    }

    private void criarDiretorio(String caminho) {
        File diretorio = new File(caminho);
        if (!diretorio.exists())
            diretorio.mkdir();
    }

    public boolean arquivoExiste(String nomeArquivo) {
        File arquivo = new File(DEFAULT_PATH + "\\" + nomeArquivo);
        return arquivo.exists();
    }
}
