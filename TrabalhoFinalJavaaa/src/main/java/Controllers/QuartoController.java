package Controllers;
import Models.Quarto;
import View.QuartoView;
import Daos.FileManager;
import java.util.ArrayList;
import java.util.List;

public class QuartoController {
    private List<Quarto> quartos;
    private QuartoView view;
    private FileManager fileManager;

    public QuartoController(QuartoView view, FileManager fileManager) {
        this.view = view;
        this.fileManager = fileManager;
        this.quartos = new ArrayList<>(List.of(fileManager.readQuartos()));
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
            fileManager.writeQuartos(quartos.toArray(new Quarto[]));
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