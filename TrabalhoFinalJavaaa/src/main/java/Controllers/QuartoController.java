package Controllers;

import Daos.ClienteDAO;
import Daos.QuartoDAO;
import Models.Cliente;
import Models.Quarto;
import View.MainView;
import View.QuartoView;

import java.util.ArrayList;
import java.util.List;

public class QuartoController {
    private List<Quarto> quartos;
    private QuartoView view;
    private QuartoDAO quartoDAO;
    private ClienteDAO clienteDAO;

    public QuartoController(QuartoView view, QuartoDAO quartoDAO, ClienteDAO clienteDAO) {
        this.view = view;
        this.quartoDAO = quartoDAO;
        this.clienteDAO = clienteDAO;
        this.quartos = new ArrayList<>(List.of(quartoDAO.readQuartos()));
    }

    public void showQuartos() {
        quartos = new ArrayList<>(List.of(quartoDAO.readQuartos()));
        view.displayMessage("Quartos Disponíveis:");
        for (Quarto quarto : quartos) {
            view.displayMessage(quarto.toString());
        }
    }

    public void associarClienteAQuarto() {
        int clienteId = view.getClienteId();
        List<Quarto> quartosDisponiveis = List.of(quartoDAO.readQuartos());
        int numeroQuarto = view.escolherQuarto(quartosDisponiveis);

        Cliente cliente = clienteDAO.buscarClientePorId(clienteId);
        if (cliente == null) {
            view.displayMessage("Cliente não encontrado.");
            return;
        }

        Quarto quarto = null;
        for (Quarto q : quartosDisponiveis) {
            if (q.getNumero() == numeroQuarto) {
                quarto = q;
                break;
            }
        }

        if (quarto == null) {
            view.displayMessage("Quarto não encontrado.");
            return;
        }

        if (cliente.getNumeroQuarto() != 0) {
            view.displayMessage("Cliente já está associado a um quarto.");
            return;
        }

        cliente.setNumeroQuarto(numeroQuarto);
        clienteDAO.atualizarCliente(cliente);
        view.displayMessage("Cliente " + clienteId + " associado ao quarto " + numeroQuarto + " com sucesso.");
    }

    public void removerClienteDoQuarto() {
        int clienteId = view.getClienteId();

        Cliente cliente = clienteDAO.buscarClientePorId(clienteId);
        if (cliente == null) {
            view.displayMessage("Cliente não encontrado.");
            return;
        }

        if (cliente.getNumeroQuarto() == 0) {
            view.displayMessage("Cliente não está associado a nenhum quarto.");
            return;
        }

        cliente.setNumeroQuarto(0); // Remover associação do cliente com quarto
        clienteDAO.atualizarCliente(cliente);
        view.displayMessage("Cliente " + clienteId + " removido do quarto com sucesso.");
    }

    public void start() {
        while (true) {
            view.displayMenu();
            int option = view.getMenuOption();
            switch (option) {
                case 1:
                    showQuartos();
                    break;
                case 2:
                    associarClienteAQuarto();
                    break;
                case 3:
                    removerClienteDoQuarto();
                    break;
                case 4:
                    return;
                default:
                    view.displayMessage("Opção inválida.");
                    break;
            }
        }
    }
}
