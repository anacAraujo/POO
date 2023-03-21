package aula06;

import aula05.DateYMD;

public class Bolseiro extends Aluno {
    private String orientador;
    private int montante;

    public Bolseiro(String nome, int cc, DateYMD dataNasc, DateYMD dataInsc, String orientador, int montante) {
        super(nome, cc, dataNasc, dataInsc);
        this.orientador = orientador;
        this.montante = montante;
    }
}