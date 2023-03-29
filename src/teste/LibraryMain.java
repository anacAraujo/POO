import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        ILibrary library = new Library();
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("7")) {
            System.out.println("Library Menu:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Search for item");
            System.out.println("4. Borrow item");
            System.out.println("5. Return item");
            System.out.println("6. Print inventory");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // adicionar item
                    System.out.print("Titulo: ");
                    String titulo = scanner.next();
                    library.addItem(new LibraryItem(titulo));
                    break;
                case "2":
                    // remover item
                    System.out.print("Titulo que quer eliminar: ");
                    String tituloEliminar = scanner.next();
                    LibraryItem eliminar = library.searchForItem(tituloEliminar);
                    if (eliminar == null) {
                        System.out.println("não existe.");
                        return;
                    }
                    library.removeItem(eliminar);
                    break;
                case "3":
                    // procurar um item e imprimir as suas informações
                    System.out.print("Titulo que quer procurar: ");
                    String tituloProcurar = scanner.next();
                    LibraryItem procurar = library.searchForItem(tituloProcurar);
                    if (procurar == null) {
                        System.out.println("não existe.");
                        return;
                    }
                    System.out.println(procurar.toString());
                    break;
                case "4":
                    // emprestar um item, através do ID
                    System.out.print("Id do item que quer emprestar: ");
                    int idEmprestar = scanner.nextInt();
                    if (idEmprestar == -1) {
                        System.out.println("não existe.");
                        return;
                    }
                    library.returnItem(idEmprestar);
                    break;
                case "5":
                    // devolver um item, através do ID
                    System.out.print("Id do item que quer devolver: ");
                    int idDevolver = scanner.nextInt();
                    library.returnItem(idDevolver);
                    break;
                case "6":
                    // imprimir o inventório da libraria
                    library.printInventory();
                    break;
                case "7":
                    System.out.println("Exiting program.");
                    break;
                default:
                    // imprimir mensagem de erro
                    System.out.println("Erro.");
                    break;
            }
        }
        scanner.close();
    }
}
