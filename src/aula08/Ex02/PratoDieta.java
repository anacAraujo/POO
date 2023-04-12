package aula08.Ex02;

public class PratoDieta extends Prato {
    private double caloriasMax;
    private double totalCalorias;

    public PratoDieta(String nome, double maxCalorias) {
        super(nome);
        this.caloriasMax = maxCalorias;
        this.totalCalorias = 0;
    }

    @Override
    public boolean addIngrediente(Alimento alimento) {
        totalCalorias += alimento.getQntCaloria();
        if (totalCalorias > caloriasMax) {
            return false;
        }
        super.addIngrediente(alimento);
        return true;
    }
}
