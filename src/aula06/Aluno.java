package aula06;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import aula05.DateYMD;

public class Aluno extends Pessoa {
    // ... definição de atributos
    private static int currentMec = 100;

    private int nMec;
    private DateYMD dataInsc;

    public Aluno(String iNome, int iBI, DateYMD iDataNasc, DateYMD iDataInsc) {
        super(iNome, iBI, iDataNasc);

        this.dataInsc = iDataInsc;

        this.nMec = currentMec;
        Aluno.currentMec++;
    }

    public Aluno(String iNome, int iBI, DateYMD iDataNasc) {
        super(iNome, iBI, iDataNasc);

        LocalDate dataAtual = java.time.LocalDate.now();
        // dataInsc.setDate(iBI, , iBI);
        // Integer.parseInt(dataAtual.getMonth());
        this.nMec = currentMec;
        Aluno.currentMec++;
    }

    // nota: neste caso deve assumir a data atual
    public int getNMec() {
        return this.nMec;
    } // retorna o número mecanográfico
      // ... acrescentar métodos necessários

    public String getName() {
        return this.getNome();
    }

    public String toString() {
        return String.format("%2s; CC:%2d; Data de nascimento:%2; Número mecangrafico:%2d; Data de inscrição:%2\n",
                this.getName(),
                this.getCC(),
                this.getDataNasc(),
                this.nMec,
                this.dataInsc);
    }
}
