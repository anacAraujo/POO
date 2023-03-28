package aula07;

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
}

class Robo extends Objeto {
    private String id;
    private String tipoJogador;
    private int numGolos;

    public Robo(String id, int posX, int posY, String tipo) {
        super(posX, posY);
        this.tipoJogador = tipo;
        this.id = id;
        numGolos = 0;
    }

    public void marcarGolo() {
        numGolos++;
    }
}

public class Ex03 {

}
