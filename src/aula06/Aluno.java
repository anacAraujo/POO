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
        super(iNome, iBI, iDataNasc);

        LocalDate dataatual = LocalDate.now();
        DateYMD dataAtual = new DateYMD(dataatual.getDayOfMonth(), dataatual.getMonthValue(), dataatual.getYear());
        this.dataInsc = dataAtual;

        this.nMec = currentMec;
        Aluno.currentMec++;
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
                "%2s; CC:%2d; Data de nascimento: " + this.getDataNasc()
                        + "; Número mecangrafico:%2d; Data de inscrição: " + this.dataInsc + "\n",
                this.getName(),
                this.getCC(),
                this.nMec);
    }
}
