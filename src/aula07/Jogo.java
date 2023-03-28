package aula07;

import java.util.Arrays;
import java.util.List;

class Objeto {
    private static int distPercorrida = 0;

    private int posX;
    private int posY;

    public Objeto() {
        int posX = (int) Math.floor(Math.random() * (50));
        int posY = (int) Math.floor(Math.random() * (50));
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
        return String.format("Posição x:%d; y:%d;\nDistancia percorrida: %d",
                this.posX,
                this.posY,
                distPercorrida);
    }
}

class Robo extends Objeto {
    private static List<String> categorias = Arrays.asList("GuardaRedes", "Avancado", "Defesa", "Medio");
    private static int currentId = 0;

    private String id;
    private String tipoJogador;
    private int numGolos;

    public Robo() {
        super();
        int tipo = (int) Math.floor(Math.random() * (5));
        this.tipoJogador = categorias.get(tipo);
        this.id = "Robo" + currentId;
        currentId++;
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
        super();
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

    public Equipa() {
        int nome = (int) Math.floor(Math.random() * (100));
        this.nomeEquipa = "Equipa" + nome;
        this.nomeResponsavel = "Responsavel" + nome;
        this.golosMarcados = 0;
        this.golosSofridos = 0;
        this.robos = new Robo[3];
        adicionarRobos();
    }

    private void adicionarRobos() {
        for (int i = 0; i < robos.length; i++) {
            robos[i] = new Robo();
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

public class Jogo {

}
