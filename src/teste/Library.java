package teste;

import java.util.ArrayList;
import java.util.List;

public class Library implements ILibrary {
    private List<LibraryItem> itens;

    public Library() {
        this.itens = new ArrayList<LibraryItem>();
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

    public LibraryItem searchById(int itemId) {
        for (LibraryItem libraryItem : itens) {
            if (libraryItem.getId() == itemId) {
                return libraryItem;
            }
        }
        return null;
    }

    public boolean borrowItem(int itemId, String userName) {
        LibraryItem item = searchById(itemId);
        if (item.getisDisponivel()) {
            item.checkout(userName);
            return true;
        }
        return false;
    }

    public boolean returnItem(int itemId) {
        LibraryItem item = searchById(itemId);
        if (!item.getisDisponivel()) {
            item.returnLibraryItem();
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
