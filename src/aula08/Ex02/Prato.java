package aula08.Ex02;

import java.util.ArrayList;
import java.util.List;

public class Prato {
    private String nome;
    private List<Alimento> alimentos;
    private double caloriasPrato;
    private double proteinasPrato;
    private double pesoPrato;

    public Prato(String nome) {
        this.nome = nome;
        this.caloriasPrato = 0;
        this.proteinasPrato = 0;
        this.pesoPrato = 0;
        alimentos = new ArrayList<Alimento>();
    }

    public boolean addIngrediente(Alimento alimento) {
        this.caloriasPrato += alimento.totalCaloriasAlimento();
        this.proteinasPrato += alimento.totalProteinasAlimento();
        this.pesoPrato += alimento.getPeso();
        alimentos.add(alimento);
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        long temp;
        temp = Double.doubleToLongBits(caloriasPrato);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(proteinasPrato);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pesoPrato);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Prato other = (Prato) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (Double.doubleToLongBits(caloriasPrato) != Double.doubleToLongBits(other.caloriasPrato))
            return false;
        if (Double.doubleToLongBits(proteinasPrato) != Double.doubleToLongBits(other.proteinasPrato))
            return false;
        if (Double.doubleToLongBits(pesoPrato) != Double.doubleToLongBits(other.pesoPrato))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Prato %s composto por: %d ingredientes - total de calorias %.1f, proteinas %.1f, peso %.1f",
                this.nome,
                alimentos.size(),
                this.caloriasPrato,
                this.proteinasPrato,
                this.pesoPrato);
    }
}
