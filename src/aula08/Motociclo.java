package aula08;

public class Motociclo extends Automovel {
    private static String[] tipos = { "desportivo", "estrada" };

    private String tipo;

    public Motociclo(String matricula, String marca, String modelo, double potencia, String tipo) {
        super(matricula, marca, modelo, potencia);
        this.tipo = tipo;
    }

    public boolean validTipo(String tipo) {
        if (tipo != "desportivo" || tipo != "estrada") {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("%s; Tipo: %s;",
                super.toString(),
                this.tipo);
    }
}
