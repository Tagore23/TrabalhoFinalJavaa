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
        File diretorio = new File(caminho);
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
    }

    public boolean arquivoExiste(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);
        return arquivo.exists();
    }

    public Quarto[] readQuartos() {
        List<Quarto> quartos = new ArrayList<>();
        File file = new File(DEFAULT_PATH + "\\quartos.txt");
        if (!file.exists() || file.length() == 0) {
            return quartos.toArray(new Quarto[0]);
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 3) {
                        try {
                            int numero = Integer.parseInt(data[0]);
                            double valor = Double.parseDouble(data[1]);
                            int andar = Integer.parseInt(data[2]);
                            quartos.add(new Quarto(numero, valor, andar));
                        } catch (NumberFormatException e) {
                            logger.error("Erro ao converter os dados: " + line, e);
                        }
                    } else {
                        logger.error("Dados inválidos: " + line);
                    }
                }
            } catch (IOException e) {
                logger.error("Erro ao ler o arquivo de quartos.", e);
            }
        }
        return quartos.toArray(new Quarto[0]);
    }

    public void writeQuartos(Quarto[] quartos) {
        File file = new File(DEFAULT_PATH + "\\quartos.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Quarto quarto : quartos) {
                writer.write(quarto.getNumero() + "," + quarto.getValor() + "," + quarto.getAndar());
                writer.newLine();
            }
        } catch (IOException e) {
            logger.error("Erro ao escrever no arquivo de quartos.", e);
        }
    }
}
