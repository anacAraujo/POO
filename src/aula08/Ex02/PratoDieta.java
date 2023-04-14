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
        if (alimento.totalCaloriasAlimento() + totalCalorias > caloriasMax) {
            return false;
        }
        totalCalorias += alimento.totalCaloriasAlimento();
        super.addIngrediente(alimento);
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s - Dieta (%.1f de %.1f Calorias)",
                super.toString(),
                this.totalCalorias,
                this.caloriasMax);
    }
}
