package aula08;

public class PesadoPassageiro extends Pesado {
    private int numMaxPassageiros;

    public PesadoPassageiro(String matricula, String marca, String modelo, double potencia, int numQuadro, double peso,
            int numMaxPassageiros) {
        super(matricula, marca, modelo, potencia, numQuadro, peso);
        this.numMaxPassageiros = numMaxPassageiros;
    }
}
