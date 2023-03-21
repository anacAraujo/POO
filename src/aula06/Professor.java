package aula06;

import aula05.DateYMD;

public class Professor extends Pessoa {
    private String categoria;
    private String departamento;

    public Professor(String nome, int cc, DateYMD dataNasc, String catgr, String dep) {
        super(nome, cc, dataNasc);
        switch (catgr) {
            case "Auxiliar":
                this.categoria = catgr;
                break;
            case "Associado":
                this.categoria = catgr;
                break;
            case "Catedrático":
                this.categoria = catgr;
                break;
            default:
                System.out.println("Categoria invalida.");
                return;
        }
        this.departamento = dep;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getNomeProfessor() {
        return this.getNome();
    }

}
