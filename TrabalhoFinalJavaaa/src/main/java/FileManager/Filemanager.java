package FileManager;

import Models.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filemanager {
    private static final Logger logger = LogManager.getLogger(Filemanager.class);
    private static final String DEFAULT_PATH = "C:\\Java\\TrabalhoFinalJavaa";
    private static final String CLIENTES_FILE = DEFAULT_PATH + "\\clientes.txt";

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

    public void escreverDetalhes(String nomeArquivo, String detalhes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DEFAULT_PATH + "\\" + nomeArquivo, true))) {
            writer.write(detalhes + "\n");
            logger.info("Detalhes gravados em " + nomeArquivo);
        } catch (IOException e) {
            logger.error("Erro ao escrever detalhes no arquivo.", e);
        }
    }

    public List<Cliente> lerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CLIENTES_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(", ");
                if (partes.length >= 5) {
                    Cliente cliente = new Cliente(
                            Integer.parseInt(partes[0].trim()), // ID
                            partes[1].trim(), // Nome
                            Integer.parseInt(partes[2].trim()), // Idade
                            partes[3].trim(), // Email
                            Integer.parseInt(partes[4].trim()) // Telefone
                    );
                    clientes.add(cliente);
                } else {
                    logger.error("Erro: Formato incorreto da linha no arquivo clientes.txt");
                }
            }
        } catch (IOException | NumberFormatException e) {
            logger.error("Erro ao ler os clientes do arquivo.", e);
        }
        return clientes;
    }

    public boolean removerClientePorID(String nomeArquivo, int id) {
        List<Cliente> clientes = lerClientes();
        List<Cliente> clientesAtualizados = clientes.stream()
                .filter(cliente -> cliente.getId() != id)
                .collect(Collectors.toList());

        if (clientes.size() == clientesAtualizados.size()) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DEFAULT_PATH + "\\" + nomeArquivo))) {
            for (Cliente cliente : clientesAtualizados) {
                writer.write(cliente.toString() + "\n");
            }
        } catch (IOException e) {
            logger.error("Erro ao atualizar o arquivo após a remoção.", e);
            return false;
        }

        return true;
    }
}
