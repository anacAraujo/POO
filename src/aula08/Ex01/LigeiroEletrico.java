package aula08.Ex01;

public class LigeiroEletrico extends Ligeiro implements VeiculoEletrico {
    private int bateria;

    public LigeiroEletrico(String matricula, String marca, String modelo, double potencia, String numQuadro,
            double capacidadeBagageira) {
        super(matricula, marca, modelo, potencia, numQuadro, capacidadeBagageira);
        this.bateria = 100;
    }

    @Override
    public void trajeto(int quilometros) {
        super.trajeto(quilometros);
        if (quilometros >= 1000) {
            this.bateria -= 70;
        } else {
            this.bateria -= 45;
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
