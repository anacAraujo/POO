package aula08.Ex01;

import java.util.ArrayList;
import java.util.List;

public class EmpresaAluguer {
    private String nome;
    private int codgPostal;
    private String email;
    private List<Automovel> automoveis;

    public EmpresaAluguer(String nome, int codgPostal, String email) {
        this.nome = nome;
        this.codgPostal = codgPostal;
        this.email = email;
        this.automoveis = new ArrayList<Automovel>();
    }
}
