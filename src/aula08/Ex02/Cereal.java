package aula08.Ex02;

public class Cereal extends Alimento {
    private String nome;

    public Cereal(String nome, double qntProteina, double qntCaloria, double peso) {
        super(qntProteina, qntCaloria, peso);
        this.nome = nome;
        Alimento.isVegetariano = true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Cereal other = (Cereal) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Legume %s; %s",
                this.nome,
                super.toString());
    }
}