package aula06;

import aula05.DateYMD;

public class Bolseiro extends Aluno {
    private Professor orientador;
    private int montante;

    public Bolseiro(String nome, int cc, DateYMD dataNasc, DateYMD dataInsc, Professor orientador, int montante) {
        super(nome, cc, dataNasc, dataInsc);
        this.orientador = orientador;
        this.montante = montante;
    }

    public Bolseiro(String nome, int cc, DateYMD dataNasc, Professor orientador, int montante) {
        this(nome, cc, dataNasc, null, orientador, montante);
    }

    public Professor getOrientador() {
        return orientador;
    }

    public int getBolsa() {
        return montante;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

    public void setBolsa(int montante) {
        this.montante = montante;
    }

    public String toString() {
        return String.format(
                "%s; Orientador: %s; Bolsa: %d\n",
                super.toString(),
                this.orientador,
                this.montante);
    }
}