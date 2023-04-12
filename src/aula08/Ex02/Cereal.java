package aula08.Ex02;

public class Cereal extends Alimento {
    private String nome;

    public Cereal(double qntProteina, double qntCaloria, double peso) {
        super(qntProteina, qntCaloria, peso);
        setIsVegetariano(true);
    }
}