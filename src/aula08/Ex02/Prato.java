package aula08.Ex02;

import java.util.ArrayList;
import java.util.List;

public abstract class Prato {
    private String nome;
    private List<Alimento> alimentos;

    public Prato(String nome) {
        this.nome = nome;
        alimentos = new ArrayList<Alimento>();
    }

    public boolean addIngrediente(Alimento alimento) {
        alimentos.add(alimento);
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((alimentos == null) ? 0 : alimentos.hashCode());
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
        if (alimentos == null) {
            if (other.alimentos != null)
                return false;
        } else if (!alimentos.equals(other.alimentos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String comp = "";
        for (Alimento alimento : alimentos) {
            comp += alimento.toString();
        }

        return String.format("A Sair... Prato %s composto por: %d \n",
                this.nome,
                alimentos.size(),
                comp);
    }

}
