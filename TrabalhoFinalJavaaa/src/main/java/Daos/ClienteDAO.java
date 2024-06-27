package Daos;

import Models.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private String filePath;
    private FileManager fileManager;

    public ClienteDAO(String filePath) {
        this.filePath = filePath;
        this.fileManager = new FileManager(); // Inicializando o FileManager aqui
        this.fileManager.criarDiretorio(filePath);
    }

    public void escreverDetalhes(Cliente cliente) {
        List<Cliente> clientes = lerClientes();
        int proximoId = proximoId(clientes); // Obtém o próximo ID disponível
        cliente.setId(proximoId); // Define o próximo ID para o cliente
        clientes.add(cliente);
        escreverClientes(clientes);
    }

    public List<Cliente> lerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                int idade = Integer.parseInt(dados[2]);
                String email = dados[3];
                int telefone = Integer.parseInt(dados[4]);
                int numeroQuarto = Integer.parseInt(dados[5]);
                Cliente cliente = new Cliente(id, nome, idade, email, telefone, numeroQuarto);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    private void escreverClientes(List<Cliente> clientes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Cliente cliente : clientes) {
                bw.write(cliente.getId() + "," + cliente.getNome() + "," +
                        cliente.getIdade() + "," + cliente.getEmail() + "," +
                        cliente.getTelefone() + "," + cliente.getNumeroQuarto());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int proximoId(List<Cliente> clientes) {
        int maiorId = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getId() > maiorId) {
                maiorId = cliente.getId();
            }
        }
        return maiorId + 1; // Próximo ID disponível
    }

    public boolean removerClientePorID(int id) {
        List<Cliente> clientes = lerClientes();
        Cliente clienteARemover = null;
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clienteARemover = cliente;
                break;
            }
        }
        if (clienteARemover != null) {
            clientes.remove(clienteARemover);
            escreverClientes(clientes);
            return true;
        }
        return false;
    }

    public void atualizarCliente(Cliente clienteAtualizado) {
        List<Cliente> clientes = lerClientes();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == clienteAtualizado.getId()) {
                clientes.set(i, clienteAtualizado);
                break;
            }
        }
        escreverClientes(clientes);
    }

    public Cliente buscarClientePorId(int id) {
        List<Cliente> clientes = lerClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
