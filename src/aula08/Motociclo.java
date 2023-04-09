package aula08;

public class Motociclo extends Automovel {
    private String tipo;

    public Motociclo(String matricula, String marca, String modelo, double potencia, String tipo) {
        super(matricula, marca, modelo, potencia);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("%s; Tipo: %s;",
                super.toString(),
                this.tipo);
    }
}
