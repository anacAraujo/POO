public class Book extends LibraryItem {
    private String nomeAutor;

    public Book(String titulo, String nomeAutor) {
        super(titulo);
        this.nomeAutor = nomeAutor;
    }
}
