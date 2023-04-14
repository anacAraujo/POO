package aula08.Ex02;

public abstract class Alimento {
    public static boolean isVegetariano;

    private double qntProteina;
    private double qntCaloria;
    private double peso;
    private double totalCaloriasAlimento;
    private double totalProteinasAlimento;

    public Alimento(double qntProteina, double qntCaloria, double peso) {
        this.qntProteina = qntProteina;
        this.qntCaloria = qntCaloria;
        this.peso = peso;
    }

    public double getQntProteina() {
        return qntProteina;
    }

    public double getQntCaloria() {
        return qntCaloria;
    }

    public double getPeso() {
        return peso;
    }

    public double totalCaloriasAlimento() {
        return (this.peso * this.qntCaloria) / 100;
    }

    public double totalProteinasAlimento() {
        return (this.peso * this.qntProteina) / 100;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(qntProteina);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(qntCaloria);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(peso);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (isVegetariano ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alimento other = (Alimento) obj;
        if (Double.doubleToLongBits(qntProteina) != Double.doubleToLongBits(other.qntProteina))
            return false;
        if (Double.doubleToLongBits(qntCaloria) != Double.doubleToLongBits(other.qntCaloria))
            return false;
        if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
            return false;
        if (isVegetariano != other.isVegetariano)
            return false;
        return true;
    }

    @Override
    public String toString() {
        String vegi = "";
        if (isVegetariano) {
            vegi = "Vegetariano;";
        }
        return String.format("Proteinas: %.1f; Calorias: %.1f; Peso: %.1f; %s",
                this.qntProteina,
                this.qntCaloria,
                this.peso,
                vegi);
    }
}
