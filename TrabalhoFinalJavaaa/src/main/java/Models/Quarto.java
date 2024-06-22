package Models;

public class Quarto {
    private int numero;
    private double valor;
    private int andar;

    public Quarto(int numero, double valor, int andar) {
        this.numero = numero;
        this.valor = valor;
        this.andar = andar;
    }

    public int getNumero() {
        return numero;
    }

    public double getValor() {
        return valor;
    }

    public int getAndar() {
        return andar;
    }

    @Override
    public String toString() {
        return "Quarto " + numero + " - Andar: " + andar + " - Valor: R$" + valor;
    }
}


