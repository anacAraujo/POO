package aula08;

public class PesadoMercadoria extends Pesado {
    private double cargaMax;

    public PesadoMercadoria(String matricula, String marca, String modelo, double potencia, int numQuadro, double peso,
            double cargaMax) {
        super(matricula, marca, modelo, potencia, numQuadro, peso);
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return String.format("%s; Carga Máxima: %f",
                super.toString(),
                this.cargaMax);
    }
}
