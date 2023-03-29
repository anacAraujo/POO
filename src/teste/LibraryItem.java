public class LibraryItem {
    private static int currentID = 0;

    private int id;
    private String titulo;
    private boolean isDisponivel;
    private String nomeUser;

    public LibraryItem(String titulo) {
        this.id = currentID;
        this.titulo = titulo;
        this.isDisponivel = true;
        this.nomeUser = null;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public boolean getisDisponivel() {
        return this.isDisponivel;
    }

    public String getNomeUser() {
        return this.nomeUser;
    }

    public void checkout(String nomeUser) {
        this.nomeUser = nomeUser;
        this.isDisponivel = false;
    }

    public void returnLibraryItem() {
        this.isDisponivel = true;
    }

    @Override
    public String toString() {
        String diponivel = "";
        if (isDisponivel) {
            diponivel = "sim";
        } else {
            diponivel = "não; Utilizador: " + this.nomeUser;
        }
        return String.format("ID item: %d: Titulo: %s, Disponivel: " + diponivel + "",
                this.id,
                this.titulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LibraryItem)) {
            return false;
        }

        LibraryItem outroItem = (LibraryItem) obj;

        if (this.titulo == outroItem.titulo) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}
