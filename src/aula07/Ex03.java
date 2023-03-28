package aula07;

import java.util.Arrays;
import java.util.List;

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
                this.distPercorrida);
    }

    public int getDistPercorrida() {
        return distPercorrida;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
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
        this.numGolos = 0;
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
    private int numRobos;

    public Equipa(String nomeEquipa, String nomeResponsavel) {
        this.nomeEquipa = nomeEquipa;
        this.nomeResponsavel = nomeResponsavel;
        this.golosMarcados = 0;
        this.golosSofridos = 0;
        this.numRobos = 0;
        this.robos = new Robo[3];
    }

    public void inserirRobos(int posX, int posY, String tipo) {
        if (numRobos > 3) {
            System.out.println("Cada equipa tem 3 robos.");
            return;
        }
        this.robos[numRobos] = new Robo(posX, posY, tipo);
        numRobos++;
    }

    public void atualizarGolos() {
        if (numRobos == 0) {
            return;
        }
        for (int i = 0; i < numRobos - 1; i++) {
            this.golosMarcados += this.robos[i].getNumGolos();
        }
    }

    @Override
    public String toString() {
        String robos = "";
        for (int i = 0; i < numRobos - 1; i++) {
            robos += this.robos[i].toString();
        }
        return String.format(
                "Equipa %s\nResponsavel: %s\nTotal de golos marcados: %d\nTotal de golos sofridos: %d\nRobos:\n%s",
                this.nomeEquipa,
                this.nomeResponsavel,
                this.golosMarcados,
                this.golosSofridos,
                robos);
    }

    public Robo[] getRobos() {
        return robos;
    }

    public int getGolosMarcados() {
        return golosMarcados;
    }

    public void setGolosSofridos(int golosSofridos) {
        this.golosSofridos = golosSofridos;
    }
}

class Jogo {
    private Equipa equipa1;
    private Equipa equipa2;
    private Bola bola;
    private int duracao;
    private int tempoDecorrido;

    public Jogo(Equipa equipa1, Equipa equipa2, Bola bola, int duracao) {
        this.equipa1 = equipa1;
        this.equipa2 = equipa2;
        this.bola = bola;
        this.duracao = duracao;
    }

    // private Robo roboMaisProximoBola(Equipa equipa) {
    // int distMin = 10000;
    // int posicaoRobo = -1;

    // for (int i = 0; i < equipa.getNumRobos(); i++) {
    // int x1 = equipa.getRobos()[i].getPosX();
    // int y1 = equipa.getRobos()[i].getPosY();

    // int x2 = bola.getPosX();
    // int y2 = bola.getPosY();

    // int dist = (int) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

    // if (dist < distMin) {
    // distMin = dist;
    // posicaoRobo = i;
    // }
    // }
    // return equipa.getRobos()[posicaoRobo];
    // }

    public void jogar() {
        int numequipa = (int) (Math.random() * 2);
        Robo robo = null;
        if (numequipa == 1) {
            robo = equipa1.getRobos()[numequipa];
        } else if (numequipa == 0) {
            robo = equipa2.getRobos()[numequipa];
        }

        robo.move(robo.getPosX() + 10, robo.getPosY() + 10);

        if (robo.getPosX() < 30 && robo.getPosX() > 20 && robo.getPosY() > 40) {
            robo.marcarGolo();
        }
        robo.marcarGolo();
        tempoDecorrido++;
    }

    @Override
    public String toString() {
        return String.format("Equipas:\n%s\n%s", this.equipa1.toString(), this.equipa2.toString());
    }

    public int getTempoDecorrido() {
        return tempoDecorrido;
    }
}

public class Ex03 {
    public static void main(String[] args) {

        Equipa equipa1 = new Equipa("AAA", "Aaa");
        equipa1.inserirRobos((int) Math.random() * 50, (int) Math.random() * 50, "GuardaRedes");
        equipa1.inserirRobos((int) Math.random() * 50, (int) Math.random() * 50, "Avancado");

        Equipa equipa2 = new Equipa("BBB", "Bbb");
        equipa2.inserirRobos((int) Math.random() * 50, (int) Math.random() * 50, "GuardaRedes");
        equipa2.inserirRobos((int) Math.random() * 50, (int) Math.random() * 50, "Avancado");

        Bola bola = new Bola(25, 25, "branco");

        int duracao = 10;

        Jogo jogo = new Jogo(equipa1, equipa2, bola, duracao);

        while (jogo.getTempoDecorrido() != duracao) {
            jogo.jogar();
        }

        equipa1.atualizarGolos();
        equipa2.atualizarGolos();
        equipa1.setGolosSofridos(equipa2.getGolosMarcados());
        equipa2.setGolosSofridos(equipa1.getGolosMarcados());

        System.out.println(jogo.toString());
    }
}
