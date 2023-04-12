package aula08.Ex02;

public class Carne extends Alimento {
    public enum VariedadeCarne {
        VACA, PORCO, PERU, FRANGO, OUTRA
    };

    private VariedadeCarne variedade;

    public Carne(VariedadeCarne variedade, double qntProteina, double qntCaloria, double peso) {
        super(qntProteina, qntCaloria, peso);
        this.variedade = variedade;
        Alimento.isVegetariano = false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((variedade == null) ? 0 : variedade.hashCode());
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
        Carne other = (Carne) obj;
        if (variedade != other.variedade)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Carne de " + this.variedade + "; %s",
                super.toString());
    }
}
