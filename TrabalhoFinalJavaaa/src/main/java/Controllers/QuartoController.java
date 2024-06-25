package Controllers;

import Models.Quarto;
import View.QuartoView;
import Daos.QuartoDAO;

import java.util.ArrayList;
import java.util.List;

public class QuartoController {
    private List<Quarto> quartos;
    private QuartoView view;
    private QuartoDAO quartoDAO;

    public QuartoController(QuartoView view, QuartoDAO quartoDAO) {
        this.view = view;
        this.quartoDAO = quartoDAO;
        this.quartos = new ArrayList<>(List.of(quartoDAO.readQuartos()));
    }

    public void showQuartos() {
        view.displayQuartos(quartos.toArray(new Quarto[0]));
    }

    public void removeQuarto() {
        int numero = view.getQuartoNumero();
        Quarto quartoToRemove = null;
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                quartoToRemove = quarto;
                break;
            }
        }
        if (quartoToRemove != null) {
            quartos.remove(quartoToRemove);
            quartoDAO.writeQuartos(quartos.toArray(new Quarto[0]));
            view.displayMessage("Quarto " + numero + " removido com sucesso.");
        } else {
            view.displayMessage("Quarto " + numero + " está indisponível.");
        }
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
                    removeQuarto();
                    break;
                case 3:
                    return;
                default:
                    view.displayMessage("Opção inválida.");
                    break;
            }
        }
    }
}
