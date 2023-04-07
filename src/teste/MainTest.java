package teste;

public class MainTest {
    public static void main(String[] args) {
        ILibrary library = new Library();
        library.addItem(new Book("livro0", "autor0"));
        library.addItem(new Book("livro1", "autor1"));
        library.addItem(new Book("livro2", "autor2"));
        library.addItem(new Book("livro3", "autor3"));
        library.addItem(new Dvd("filme4", 22));
        library.printInventory();

        LibraryItem eliminar = library.searchForItem("livro2");
        if (eliminar == null) {
            System.out.println("não existe.");
        } else {
            library.removeItem(eliminar);
        }
        library.printInventory();

        LibraryItem procurar = library.searchForItem("livro0");
        if (procurar == null) {
            System.out.println("não existe.");
        } else {
            System.out.println("Resultado: " + procurar.toString());
        }

        library.borrowItem(4, "paulo");
        library.printInventory();

        library.returnItem(4);

        library.printInventory();
    }
}
