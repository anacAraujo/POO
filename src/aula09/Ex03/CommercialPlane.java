package aula09.Ex03;

public class CommercialPlane extends Plane {
    private int tripulantes;

    public CommercialPlane(String nome, String fab, int ano, int maxPassageiros, int maxVelocidade, int tripulantes) {
        super(nome, fab, ano, maxPassageiros, maxVelocidade);
        this.tripulantes = tripulantes;
    }

    public String getPlaneType() {
        return "Comercial";
    }

    @Override
    public String toString() {
        return String.format("Avião Comercial %s, Nº Tripulantes: %d",
                super.toString(),
                this.tripulantes);
    }
}
