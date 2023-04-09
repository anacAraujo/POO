package aula08;

public class Ligeiro extends Automovel {
    private int numQuadro;
    private int capacidadeBagageira;

    public Ligeiro(String matricula, String marca, String modelo, double potencia, int numQuadro,
            int capacidadeBagageira) {
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
        return String.format("%s; Nº Quadro: %d; Capacidade Bagageira: %d",
                super.toString(),
                this.numQuadro,
                this.capacidadeBagageira);
    }
}
