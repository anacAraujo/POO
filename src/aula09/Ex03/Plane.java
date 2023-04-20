package aula09.Ex03;

public abstract class Plane {
    private String id;
    private String fabricante;
    private int anoProducao;
    private int maxPassageiros;
    private int maxVelocidade;

    public Plane(String id, String fab, int ano, int maxPassageiros, int maxVelocidade) {
        this.id = id;
        this.fabricante = fab;
        this.anoProducao = ano;
        this.maxPassageiros = maxPassageiros;
        this.maxVelocidade = maxVelocidade;
    }

    public String getId() {
        return id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getAnoProducao() {
        return anoProducao;
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public int getMaxVelocidade() {
        return maxVelocidade;
    }

    abstract String getPlaneType();

    @Override
    public String toString() {
        return String.format("%s, Fabricante: %s, Ano Producao: %d, Máx. Passageiros: %d, Máx. Velocidade: %d",
                this.id,
                this.fabricante,
                this.anoProducao,
                this.maxPassageiros,
                this.maxVelocidade);
    }
}
