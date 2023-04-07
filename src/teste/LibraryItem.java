package teste;

public abstract class LibraryItem {
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

        currentID++;
    }

    public void checkout(String nomeUser) {
        this.nomeUser = nomeUser;
        this.isDisponivel = false;
    }

    public void returnLibraryItem() {
        this.isDisponivel = true;
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LibraryItem)) {
            return false;
        }

        LibraryItem outroItem = (LibraryItem) obj;

        if (this.id == outroItem.id &&
                this.titulo == outroItem.titulo) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }

    @Override
    public String toString() {
        String disponivel = "";
        if (isDisponivel) {
            disponivel = "sim";
        } else {
            disponivel = "não; Utilizador: " + this.nomeUser;
        }
        return String.format("ID item: %d, Titulo: %s, Disponivel: %s",
                this.id,
                this.titulo,
                disponivel);
    }
}
