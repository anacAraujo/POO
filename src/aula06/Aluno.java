package aula06;

import java.time.LocalDate;

import aula05.DateYMD;

public class Aluno extends Pessoa {
    // ... definição de atributos
    private static int currentMec = 100;

    private int nMec;
    private DateYMD dataInsc = null;

    public Aluno(String iNome, int iBI, DateYMD iDataNasc, DateYMD iDataInsc) {
        super(iNome, iBI, iDataNasc);

        if (dataInsc == null) {
            LocalDate dataatual = LocalDate.now();
            DateYMD dataAtual = new DateYMD(dataatual.getDayOfMonth(), dataatual.getMonthValue(), dataatual.getYear());
            this.dataInsc = dataAtual;
        } else {
            this.dataInsc = iDataInsc;
        }

        this.nMec = currentMec;
        Aluno.currentMec++;
    }

    public Aluno(String iNome, int iBI, DateYMD iDataNasc) {
        this(iNome, iBI, iDataNasc, null);
    }

    public int getNMec() {
        return this.nMec;
    }

    public DateYMD getDataInsc() {
        return this.dataInsc;
    }

    public String getName() {
        return this.getNome();
    }

    public String toString() {
        return String.format(
                super.toString() + "; Número mecangrafico:%2d; Data de inscrição: " + this.dataInsc + "\n",
                this.nMec);
    }
}
