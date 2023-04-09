package aula08;

public abstract class Pesado extends Automovel {
    private int numQuadro;
    private double peso;

    public Pesado(String matricula, String marca, String modelo, double potencia, int numQuadro, double peso) {
        super(matricula, marca, modelo, potencia);
        this.numQuadro = numQuadro;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("%s; Nº Quadro: %d; Peso: %f",
                super.toString(),
                this.numQuadro,
                this.peso);
    }
}
