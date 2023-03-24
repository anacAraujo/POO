package aula06;

import java.util.Arrays;
import java.util.List;

public class Professor extends Pessoa {
    private static List<String> categorias = Arrays.asList("Auxiliar", "Associado", "Catedrático");

    private String categoria;
    private String departamento;

    public Professor(String nome, int cc, DateYMD dataNasc, String catgr, String dep) {
        super(nome, cc, dataNasc);

        if (categorias.indexOf(catgr) == -1) {
            System.out.println("Categoria invalida.");
            return;
        }

        this.categoria = catgr;
        this.departamento = dep;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return String.format(
                "%s; Categoria: %s; Departamento: %s",
                super.toString(),
                this.categoria,
                this.departamento);
    }
}
