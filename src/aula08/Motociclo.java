package aula08;

import java.util.Arrays;
import java.util.List;

public class Motociclo extends Automovel {
    private static List<String> tipos = Arrays.asList("desportivo", "estrada");

    private String tipo;

    public Motociclo(String matricula, String marca, String modelo, double potencia, String tipo) {
        super(matricula, marca, modelo, potencia);
        this.tipo = tipo;
    }

    public static boolean validTipo(String tipo) {
        if (tipos.indexOf(tipo) == -1) {
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
