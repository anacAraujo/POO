package aula08.Ex02;

public class Peixe extends Alimento {
    public enum TipoPeixe {
        CONGELADO, FRESCO
    };

    private TipoPeixe tipo;

    public Peixe(TipoPeixe tipo, double qntProteina, double qntCaloria, double peso) {
        super(qntProteina, qntCaloria, peso);
        this.tipo = tipo;
        Alimento.isVegetariano = false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Peixe other = (Peixe) obj;
        if (tipo != other.tipo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        String tipo = "";
        switch (this.tipo) {
            case CONGELADO:
                tipo = "congelado";
                break;
            case FRESCO:
                tipo = "fresco";
                break;
        }
        return String.format("Peixe %s; %s",
                tipo,
                super.toString());
    }
}