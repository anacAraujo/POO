package aula07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Objeto {
    private static int distPercorrida = 0;

    private int posX;
    private int posY;

    public Objeto(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void move(int newX, int newY) {
        int posAnteriorX = this.posX;
        int posAnteriorY = this.posY;

        this.posX = newX;
        this.posY = newY;
        Objeto.distPercorrida += Math.sqrt((this.posY - posAnteriorY) * (this.posY - posAnteriorY)
                + (this.posX - posAnteriorX) * (this.posX - posAnteriorX));
    }

    @Override
    public String toString() {
        return String.format("Posição x:%d; y:%d; ",
                this.posX,
                this.posY);
    }
}

class Robo extends Objeto {
    private static List<String> categorias = Arrays.asList("GuardaRedes", "Avancado", "Defesa", "Medio");

    private String id;
    private String tipoJogador;
    private int numGolos;

    public Robo(String id, int posX, int posY, String tipo) {
        super(posX, posY);

        if (categorias.indexOf(tipo) == -1) {
            System.out.println("Tipo de jogador invalido.");
            return;
        }
        this.tipoJogador = tipo;
        this.id = id;
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
        // TODO Auto-generated method stub
        return super.toString();
    }
}

class Equipa {
    private static Scanner sc = new Scanner(System.in);

    private String nomeEquipa;
    private String nomeResponsavel;
    private int golosMarcados;
    private int golosSofridos;
    private Robo[] robos;

    public Equipa(String nomeEquipa, String nomeResponsavel) {
        this.nomeEquipa = nomeEquipa;
        this.nomeResponsavel = nomeResponsavel;
        this.golosMarcados = 0;
        this.golosSofridos = 0;
        this.robos = new Robo[3];
        adicionarRobos();
    }

    private void adicionarRobos() {
        for (int i = 0; i < robos.length; i++) {
            System.out.print("ID do robô: ");
            String id = sc.next();
            System.out.print("Posição x: ");
            int posX = sc.nextInt();
            System.out.print("Posição Y: ");
            int posY = sc.nextInt();
            System.out.print("Tipo: ");
            String tipo = sc.next();

            robos[i] = new Robo(id, posX, posY, tipo);
        }
    }

    public void atualizarGolos() {
        // se o ide do robo marcar um golo adicionar aos golos marcados
        // se não adicionar aos sofridos
        for (Robo robo : robos) {
            this.golosMarcados += robo.getNumGolos();
        }
    }
}

public class Jogo {

}
