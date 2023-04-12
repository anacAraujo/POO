package aula08.Ex02;

public class PratoVegetariano extends Prato {
    public PratoVegetariano(String nome) {
        super(nome);
    }

    @Override
    public boolean addIngrediente(Alimento alimento) {
        if (!Alimento.isVegetariano) {
            return false;
        }
        super.addIngrediente(alimento);
        return true;
    }
}
