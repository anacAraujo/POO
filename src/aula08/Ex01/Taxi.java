package aula08.Ex01;

public class Taxi extends Ligeiro {
    private int licenca;

    public Taxi(String matricula, String marca, String modelo, double potencia, int numQuadro, int capacidadeBagageira,
            int licenca) {
        super(matricula, marca, modelo, potencia, numQuadro, capacidadeBagageira);
        this.licenca = licenca;
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
        return String.format("%s; Lincença: %d",
                super.toString(),
                this.licenca);
    }
}
