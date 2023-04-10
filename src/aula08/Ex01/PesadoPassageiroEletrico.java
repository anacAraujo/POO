package aula08.Ex01;

public class PesadoPassageiroEletrico extends PesadoPassageiro implements VeiculoEletrico {
    private int bateria;

    public PesadoPassageiroEletrico(String matricula, String marca, String modelo, double potencia, String numQuadro,
            double peso, int numMaxPassageiros) {
        super(matricula, marca, modelo, potencia, numQuadro, peso, numMaxPassageiros);
        this.bateria = 100;
    }

    @Override
    public void trajeto(int quilometros) {
        super.trajeto(quilometros);
        if (quilometros >= 1000) {
            this.bateria -= 80;
        } else {
            this.bateria -= 60;
        }
    }

    public int autonomia() {
        return bateria;
    }

    public void carregar(int percentagem) {
        if (percentagem > 100 || percentagem <= 0 || percentagem < this.bateria) {
            System.out.println("Valor inválido.");
            return;
        }
        this.bateria = percentagem;
    }
}
