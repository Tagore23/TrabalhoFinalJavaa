package Controllers;
import Models.Quarto;
import View.QuartoView;

public class QuartoController {
    private Quarto[] quartos;
    private QuartoView view;

    public QuartoController(QuartoView view) {
        this.quartos = new Quarto[]{
                new Quarto(1, 150.0, 1),
                new Quarto(2, 200.0, 2),
                new Quarto(3, 250.0, 3)
        };
        this.view = view;
    }

    public void showQuartos() {
        view.displayQuartos(quartos);
    }
}
