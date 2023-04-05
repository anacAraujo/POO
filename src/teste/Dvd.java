package teste;

public class Dvd extends LibraryItem {
    private int duracao;

    public Dvd(String titulo, int d) {
        super(titulo);
        this.duracao = d;
    }
}
