package aula08.Ex01;

public class Ligeiro extends Automovel {
    private String numQuadro;
    private double capacidadeBagageira;

    public Ligeiro(String matricula, String marca, String modelo, double potencia, String numQuadro,
            double capacidadeBagageira) {
        super(matricula, marca, modelo, potencia);
        this.numQuadro = numQuadro;
        this.capacidadeBagageira = capacidadeBagageira;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("%s; Nº Quadro: %s; Capacidade Bagageira: %f",
                super.toString(),
                this.numQuadro,
                this.capacidadeBagageira);
    }
}
