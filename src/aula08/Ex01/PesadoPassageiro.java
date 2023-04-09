package aula08.Ex01;

public class PesadoPassageiro extends Pesado {
    private int numMaxPassageiros;

    public PesadoPassageiro(String matricula, String marca, String modelo, double potencia, int numQuadro, double peso,
            int numMaxPassageiros) {
        super(matricula, marca, modelo, potencia, numQuadro, peso);
        this.numMaxPassageiros = numMaxPassageiros;
    }

    @Override
    public String toString() {
        return String.format("%; Nº Máximo Passageiros: %d",
                super.toString(),
                this.numMaxPassageiros);
    }
}
