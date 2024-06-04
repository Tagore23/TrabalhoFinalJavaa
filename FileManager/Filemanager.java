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
                String[] partes = linha.split(",\\s*"); // Usando expressão regular para lidar com espaços após as vírgulas
                // Verifica se há pelo menos 4 partes na linha
                if (partes.length >= 4) {
                    // Remove espaços em branco dos valores e cria o cliente
                    String nome = partes[0].trim().replace("Nome: ", "");
                    Integer idade = Integer.parseInt(partes[1].trim().replace("Idade: ", ""));
                    String email = partes[2].trim().replace("E-mail: ", "");
                    Integer telefone = Integer.parseInt(partes[3].trim().replace("Telefone: ", ""));
                    Cliente cliente = new Cliente(nome, idade, email, telefone);
                    clientes.add(cliente);
                } else {
                    // Exibe uma mensagem de erro se o formato da linha estiver incorreto
                    System.out.println("Erro: Formato incorreto da linha no arquivo clientes.txt");
                }
            }
        } catch (IOException | NumberFormatException e) {
            // Captura tanto IOException quanto NumberFormatException em um único bloco catch
            System.out.println("Erro ao ler os clientes do arquivo.");
            e.printStackTrace();
        }
        return clientes;
    }

}
