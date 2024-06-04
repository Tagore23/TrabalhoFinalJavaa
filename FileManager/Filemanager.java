package FileManager;

import Models.Cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Filemanager {
    private static final String DEFAULT_PATH = "C:\\Java\\TrabalhoFinalJavaa";
    private static final String CLIENTES_FILE = DEFAULT_PATH + "\\clientes.txt";

    public Filemanager() {
        criarDiretorio(DEFAULT_PATH);
    }

    // Método para criar o diretório se não existir
    private void criarDiretorio(String caminho) {
        File diretorio = new File(caminho);
        if (!diretorio.exists())
            diretorio.mkdir();
    }

    // Método para verificar se um arquivo existe
    public boolean arquivoExiste(String nomeArquivo) {
        File arquivo = new File(DEFAULT_PATH + "\\" + nomeArquivo);
        return arquivo.exists();
    }

    // Método para escrever os detalhes em um arquivo
    public void escreverDetalhes(String nomeArquivo, String detalhes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DEFAULT_PATH + "\\" + nomeArquivo, true))) {
            writer.write(detalhes + "\n");
            System.out.println("Detalhes gravados em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao escrever detalhes no arquivo.");
            e.printStackTrace();
        }
    }

    // Método para ler clientes de um arquivo
    public static List<Cliente> lerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CLIENTES_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                Cliente cliente = new Cliente(partes[0], Integer.parseInt(partes[1]), partes[2], Double.parseDouble(partes[3]));
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
