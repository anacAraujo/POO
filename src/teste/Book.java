package teste;

public class Book extends LibraryItem {
    private String nomeAutor;

    public Book(String titulo, String nomeAutor) {
        super(titulo);
        this.nomeAutor = nomeAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((nomeAutor == null) ? 0 : nomeAutor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (nomeAutor == null) {
            if (other.nomeAutor != null)
                return false;
        } else if (!nomeAutor.equals(other.nomeAutor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s, Autor: %s",
                super.toString(),
                this.nomeAutor);
    }
}
