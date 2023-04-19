package aula09.Ex03;

public class MilitaryPlane extends Plane {
    private int municoes;

    public MilitaryPlane(String nome, String fab, int ano, int maxPassageiros, int maxVelocidade, int municoes) {
        super(nome, fab, ano, maxPassageiros, maxVelocidade);
        this.municoes = municoes;
    }

    public String getPlaneType() {
        return "Militar";
    }

    @Override
    public String toString() {
        return String.format("Avião Comercial %s, Nº Municoes: %d",
                super.toString(),
                this.municoes);
    }
}
