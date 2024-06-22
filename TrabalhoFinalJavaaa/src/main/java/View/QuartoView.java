package View;

import Models.Quarto;

public class QuartoView {
    public void displayQuartos(Quarto[] quartos) {
        System.out.println("Opções de Quartos Disponíveis:");
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }
}
