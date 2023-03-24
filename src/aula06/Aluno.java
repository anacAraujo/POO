package aula06;

import java.time.LocalDate;

public class Aluno extends Pessoa {
    private static int currentMec = 100;

    private int nMec;
    private DateYMD dataInsc;

    public Aluno(String iNome, int iBI, DateYMD iDataNasc, DateYMD iDataInsc) {
        super(iNome, iBI, iDataNasc);

        if (iDataInsc == null) {
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

    @Override
    public String toString() {
        return String.format(
                "%s; Número mecangrafico: %d; Data de inscrição: %s",
                super.toString(),
                this.nMec,
                this.dataInsc.toString());
    }
}
