package aula08.Ex02;

public class Carne extends Alimento {
    private enum variedades {
        vaca, porco, peru, frango, outra
    };

    private variedades variedade;

    public Carne(double qntProteina, double qntCaloria, double peso, variedades variedade) {
        super(qntProteina, qntCaloria, peso);
        this.variedade = variedade;
        setIsVegetariano(false);
    }

}
