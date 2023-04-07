package teste;

import java.util.Scanner;

public class LibraryMain {

    private static Scanner scanner = new Scanner(System.in);

    private static LibraryItem searchByTitle(ILibrary library) {
        System.out.print("Insira o titulo: ");
        String titulo = scanner.nextLine();
        LibraryItem item = library.searchForItem(titulo);
        return item;
    }

    public static void main(String[] args) {
        ILibrary library = new Library();
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
                    System.out.println("Adicionar:\n1 - Livro\n2 - DVD");
                    int tipoItem = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();

                    switch (tipoItem) {
                        case 1:
                            System.out.print("Autor: ");
                            String autor = scanner.nextLine();
                            library.addItem(new Book(titulo, autor));
                            break;
                        case 2:
                            System.out.print("Duração: ");
                            int duracao = scanner.nextInt();
                            scanner.nextLine();

                            library.addItem(new Dvd(titulo, duracao));
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;
                case "2":
                    // remover item
                    LibraryItem itemRemove = searchByTitle(library);
                    if (itemRemove == null) {
                        System.out.println("Titulo não existe.");
                        break;
                    }
                    library.removeItem(itemRemove);
                    break;
                case "3":
                    // procurar um item e imprimir as suas informações
                    LibraryItem itemSearch = searchByTitle(library);
                    if (itemSearch == null) {
                        System.out.println("Titulo não existe.");
                        break;
                    }
                    System.out.println(itemSearch.toString());
                    break;
                case "4":
                    // emprestar um item, através do ID
                    System.out.print("O seu nome:");
                    String userName = scanner.nextLine();
                    System.out.print("Id do item que quer emprestar: ");
                    int idEmprestar = scanner.nextInt();
                    scanner.nextLine();

                    boolean borrowed = library.borrowItem(idEmprestar, userName);
                    if (borrowed) {
                        System.out.println("Item emprestado com sucesso.");
                    } else {
                        System.out.println("Falha ao emprestar o item.");
                    }
                    break;
                case "5":
                    // devolver um item, através do ID
                    System.out.print("Id do item que quer devolver: ");
                    int idDevolver = scanner.nextInt();
                    scanner.nextLine();

                    boolean returned = library.returnItem(idDevolver);
                    if (returned) {
                        System.out.println("Item devolvido com sucesso.");
                    } else {
                        System.out.println("Falha ao devolver o item.");
                    }
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
                    System.out.println("Erro opcao invalida.");
                    break;
            }
        }
        scanner.close();
    }
}
