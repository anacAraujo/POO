package aula09.Ex03;

public abstract class Plane {
    private String nome;
    private String fabricante;
    private int anoProducao;
    private int maxPassageiros;
    private int maxVelocidade;

    public Plane(String nome, String fab, int ano, int maxPassageiros, int maxVelocidade) {
        this.nome = nome;
        this.fabricante = fab;
        this.anoProducao = ano;
        this.maxPassageiros = maxPassageiros;
        this.maxVelocidade = maxVelocidade;
    }

    abstract String getPlaneType();

    @Override
    public String toString() {
        return String.format("%s, Fabricante: %s, Ano Producao: %d, Máx. Passageiros: %d, Máx. Velocidade: %d",
                this.nome,
                this.fabricante,
                this.anoProducao,
                this.maxPassageiros,
                this.maxVelocidade);
    }
}
