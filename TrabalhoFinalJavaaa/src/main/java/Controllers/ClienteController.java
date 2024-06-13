package Controllers;

import Daos.ClienteDAO;
import Models.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ClienteController {
    private static final Logger logger = LogManager.getLogger(ClienteController.class);
    private static int clienteID = 1;
    private ClienteDAO clienteDAO;

    public ClienteController(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void cadastrarCliente(String nome, int idade, String email, int telefone) {
        logger.info("Cadastro de Cliente");
        Cliente cliente = new Cliente(clienteID++, nome, idade, email, telefone);

        logger.info("Cliente cadastrado com sucesso:");
        logger.info("ID: " + cliente.getId());
        logger.info("Nome: " + cliente.getNome());
        logger.info("Idade: " + cliente.getIdade());
        logger.info("E-mail: " + cliente.getEmail());
        logger.info("Telefone: " + cliente.getTelefone());

        clienteDAO.escreverDetalhes(cliente);
    }

    public void removerCliente(int id) {
        boolean removido = clienteDAO.removerClientePorID(id);

        if (removido) {
            logger.info("Cliente removido com sucesso.");
        } else {
            logger.warn("Cliente com ID " + id + " não encontrado.");
        }
    }

    public void verificarCadastros() {
        List<Cliente> clientes = clienteDAO.lerClientes();
        if (clientes.isEmpty()) {
            logger.info("Nenhum cliente cadastrado.");
        } else {
            logger.info("Clientes cadastrados:");
            for (Cliente cliente : clientes) {
                logger.info(cliente);
            }
        }
    }
}
