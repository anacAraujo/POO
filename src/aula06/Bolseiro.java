package aula06;

import aula05.DateYMD;

public class Bolseiro extends Aluno {
    private Professor orientador;
    private int montante;

    public Bolseiro(String nome, int cc, DateYMD dataNasc, Professor orientador, int montante) {
        super(nome, cc, dataNasc);
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

}