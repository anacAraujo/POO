package aula06;

import aula05.DateYMD;

public class Pessoa {
    private String nome;
    private int cc;
    private DateYMD dataNasc;

    public Pessoa(String nome, int cc, DateYMD dataNasc) {
        if (!DateYMD.valid(dataNasc.getDay(), dataNasc.getMonth(), dataNasc.getYear())) {
            System.out.println("Data invalida.");
            return;
        }
        if (!validPessoa(nome, cc)) {
            System.out.println("Dados invalidos.");
            return;
        }
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }

    public static boolean validPessoa(String nome, int numcc) {
        String cc = Integer.toString(numcc);
        if (nome != "" || nome.matches("[^0-9]") || cc.matches("^[0-9]{8}$)")) {
            return true;
        }
        return false;
    }

    public String getNome() {
        return this.nome;
    }

    public int getCC() {
        return this.cc;
    }

    public DateYMD getDataNasc() {
        return this.dataNasc;
    }

    public String toString() {
        return String.format("%2s; CC: %2d; Data de nascimento: " + this.dataNasc + "\n",
                this.nome,
                this.cc);
    }

    public boolean equals(Pessoa outraPessoa) {
        if (this.nome == outraPessoa.nome && this.cc == outraPessoa.cc && this.dataNasc == outraPessoa.dataNasc) {
            return true;
        } else {
            return false;
        }
    }
}
