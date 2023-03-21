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
    private DateTime dataInsc;

    public Aluno(String iNome, int iBI, DateYMD iDataNasc, DateYMD iDataInsc) {
        super(iNome, iBI, iDataNasc);

        this.dataInsc = iDataInsc;

        this.nMec = currentMec;
        Aluno.currentMec++;
    }

    public Aluno(String iNome, int iBI, DateYMD iDataNasc) {
        super(iNome, iBI, iDataNasc);

        this.dataInsc = java.time.LocalDate.now();

        this.nMec = currentMec;
        Aluno.currentMec++;
    }

    // nota: neste caso deve assumir a data atual
    public int getNMec() {
        return this.nMec;
    } // retorna o número mecanográfico
      // ... acrescentar métodos necessários
}
