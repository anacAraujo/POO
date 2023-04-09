package aula08.Ex01;

public abstract class Pesado extends Automovel {
    private String numQuadro;
    private double peso;

    public Pesado(String matricula, String marca, String modelo, double potencia, String numQuadro, double peso) {
        super(matricula, marca, modelo, potencia);
        this.numQuadro = numQuadro;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("%s; Nº Quadro: %s; Peso: %f",
                super.toString(),
                this.numQuadro,
                this.peso);
    }
}
