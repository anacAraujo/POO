import java.util.ArrayList;
import java.util.List;

public class Library implements ILibrary {
    private int currentItem;
    private List<LibraryItem> itens;

    public Library() {
        this.itens = new ArrayList<LibraryItem>();
        currentItem = 0;
    }

    public void addItem(LibraryItem item) {
        this.itens.add(item);
    }

    public void removeItem(LibraryItem item) {
        this.itens.remove(item);
    }

    public LibraryItem searchForItem(String title) {
        for (LibraryItem libraryItem : itens) {
            if (libraryItem.getTitulo() == title) {
                return libraryItem;
            }
        }
        return null;
    }

    public boolean borrowItem(int itemId) {
        if (this.itens.get(itemId).getisDisponivel()) {
            this.itens.get(itemId).checkout(this.itens.get(itemId).getNomeUser());
            return true;
        }
        return false;
    }

    public boolean returnItem(int itemId) {
        if (!this.itens.get(itemId).getisDisponivel()) {
            this.itens.get(itemId).returnLibraryItem();
            return true;
        }
        return false;
    }

    public void printInventory() {
        for (LibraryItem libraryItem : itens) {
            libraryItem.toString();
        }
    }
}
