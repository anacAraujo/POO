package aula08.Ex01;

import java.util.ArrayList;
import java.util.List;

public class EmpresaAluguer {
    private String nome;
    private String codgPostal;
    private String email;
    private List<Automovel> automoveis;

    public EmpresaAluguer(String nome, String codgPostal, String email) {
        this.nome = nome;
        this.codgPostal = codgPostal;
        this.email = email;
        this.automoveis = new ArrayList<Automovel>();
    }

    public void adicionarAutomovel(Automovel automovel) {
        automoveis.add(automovel);
    }

    @Override
    public String toString() {
        String automoveis = "";
        for (Automovel automovel : this.automoveis) {
            automoveis += automovel.toString() + "\n";
        }
        return String.format("Empresa %s, Código postal: %s, E-mail: %s, Automóveis:\n %s",
                this.nome,
                this.codgPostal,
                this.email,
                automoveis);
    }
}
