package aula07;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Objeto {
    private int distPercorrida;
    private int posX;
    private int posY;

    public Objeto(int posX, int posY) {
        this.distPercorrida = 0;
        this.posX = posX;
        this.posY = posY;
    }

    public void move(int newX, int newY) {
        int posAnteriorX = this.posX;
        int posAnteriorY = this.posY;

        this.posX = newX;
        this.posY = newY;
        distPercorrida += Math.sqrt((this.posY - posAnteriorY) * (this.posY - posAnteriorY)
                + (this.posX - posAnteriorX) * (this.posX - posAnteriorX));
    }

    @Override
    public String toString() {
        return String.format("Posição x:%d; y:%d;\nDistancia percorrida: %d",
                this.posX,
                this.posY,
                distPercorrida);
    }
}

class Robo extends Objeto {
    private static List<String> categorias = Arrays.asList("GuardaRedes", "Avancado", "Defesa", "Medio");
    private static int currentID = 0;

    private String id;
    private String tipoJogador;
    private int numGolos;

    public Robo(int posX, int posY, String tipo) {
        super(posX, posY);
        if (categorias.indexOf(tipo) == -1) {
            System.out.println("Tipo de jogador invalido.");
            return;
        }
        this.tipoJogador = tipo;
        this.id = "Robo" + currentID;
        currentID++;
        numGolos = 0;
    }

    public void marcarGolo() {
        numGolos++;
    }

    public String getId() {
        return id;
    }

    public int getNumGolos() {
        return numGolos;
    }

    @Override
    public String toString() {
        return String.format("Robo: %s\nTipo: %s\nNumero de golos marcados: %d\n%s",
                this.id,
                this.tipoJogador,
                this.numGolos,
                super.toString());
    }
}

class Bola extends Objeto {
    private String cor;

    public Bola(int posX, int posY, String cor) {
        super(posX, posY);
        this.cor = cor;
    }

    @Override
    public String toString() {
        return String.format("Bola %s\n%s",
                this.cor,
                super.toString());
    }
}

class Equipa {
    private String nomeEquipa;
    private String nomeResponsavel;
    private int golosMarcados;
    private int golosSofridos;
    private Robo[] robos;

    public Equipa(String nomeEquipa, String nomeResponsavel, int posX, int posY, String tipo) {
        this.nomeEquipa = nomeEquipa;
        this.nomeResponsavel = nomeResponsavel;
        this.golosMarcados = 0;
        this.golosSofridos = 0;
        this.robos = new Robo[3];

        for (int i = 0; i < robos.length; i++) {
            robos[i] = new Robo(posX, posY, tipo);
        }
    }

    private void atualizarGolos() {
        for (Robo robo : robos) {
            this.golosMarcados += robo.getNumGolos();
        }
    }

    @Override
    public String toString() {
        atualizarGolos();
        return String.format(
                "Equipa %s\nResponsavel: %s\nTotal de golos marcados: %d\nTotal de golos sofridos: %d\nRobos:\n%s",
                this.nomeEquipa,
                this.nomeResponsavel,
                this.golosMarcados,
                this.golosSofridos,
                this.robos.toString());
    }
}

class Jogo {

}

public class Ex03 {

}
