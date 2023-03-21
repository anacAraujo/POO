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
                "%2s; CC:%2d; Data de nascimento: " + this.getDataNasc()
                        + "; Número mecangrafico:%2d; Data de inscrição: " + this.getDataInsc()
                        + "; Orientador:%2s; Bolsa:%2d\n",
                this.getName(),
                this.getCC(),
                this.getNMec(),
                this.orientador,
                this.montante);
    }
}