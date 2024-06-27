package Controllers;

import Daos.ClienteDAO;
import Models.Cliente;
import View.MainView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ClienteController {
    private static final Logger logger = LogManager.getLogger(ClienteController.class);
    private static int clienteID = 1;
    private MainView view;
    private ClienteDAO clienteDAO;

    public ClienteController(MainView view, ClienteDAO clienteDAO) {
        this.view = view;
        this.clienteDAO = clienteDAO;
    }

    public void cadastrarCliente() {
        String nome = view.getNomeCliente();
        int idade = view.getIdadeCliente();
        String email = view.getEmailCliente();
        int telefone = view.getTelefoneCliente();

        Cliente cliente = new Cliente( nome, idade, email, telefone);
        clienteDAO.escreverDetalhes(cliente);
        view.mostrarClienteCadastrado(cliente);
    }

    public void removerCliente() {
        int id = view.getIdClienteParaRemover();
        boolean removido = clienteDAO.removerClientePorID(id);

        if (removido) {
            view.mostrarMensagem("Cliente removido com sucesso.");
        } else {
            view.mostrarMensagem("Cliente com ID " + id + " não encontrado.");
        }
    }

    public void verificarCadastros() {
        List<Cliente> clientes = clienteDAO.lerClientes();
        view.mostrarClientesCadastrados(clientes);
    }

    public void verificarClientes() {
        List<Cliente> clientes = clienteDAO.lerClientes();
        if (clientes.isEmpty()) {
            view.mostrarMensagem("Não há clientes cadastrados.");
        } else {
            for (Cliente cliente : clientes) {
                view.mostrarMensagem(cliente.toString());
            }
        }
    }
}
