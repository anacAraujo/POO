package aula06;

import aula05.DateYMD;

public class Bolseiro extends Aluno {
    private Professor orientador;
    private int montante;

    public Bolseiro(String nome, int cc, DateYMD dataNasc, /* DateYMD dataInsc, */ Professor orientador, int montante) {
        super(nome, cc, dataNasc/* , dataInsc */);
        this.orientador = orientador;
        this.montante = montante;
    }

    public Professor getOrientador() {
        return orientador;
    }

    public int getBolsa() {
        return montante;
    }

    public void setBolsa(int montante) {
        this.montante = montante;
    }

    public String toString() {
        return String.format(
                super.toString() + "; Orientador:%2s; Bolsa:%2d\n",
                this.orientador,
                this.montante);
    }
}