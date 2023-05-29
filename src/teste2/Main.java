package teste2;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner sc = new Scanner(System.in);
        int userchoise = 8;

        String filePath = "src/teste2/contactos.txt";

        contactManager.load(filePath);

        do {
            System.out.println(
                    "1 - Adicionar Contacto\n2 - Modificar Contacto\n3 - Remover Avião\n4 - Procurar por nome\n5 - Procurar por telemovel\n6 - Procurar por email\n7 - Listar contactos\n8 - Listar contactos por nome\n9 - Listar contactos por telemovel\n10 - Listar contactos email\n10 - Listar contactos data nascimento\n12 - Fehar");
            userchoise = sc.nextInt();
            switch (userchoise) {
                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumberString = sc.nextLine();
                    if (!contactManager.validatePhoneNumber(phoneNumberString)) {
                        System.out.println("invalid number");
                        break;
                    }
                    int phoneNumber = Integer.parseInt(phoneNumberString);
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    if (!contactManager.validateEmail(email)) {
                        System.out.println("invalid email");
                        break;
                    }
                    System.out.print("Aniversário: ");
                    String birthDateString = sc.next();
                    LocalDate birthDate = LocalDate.parse(birthDateString);

                    contactManager.addContact(new Contact(name, phoneNumber, email, birthDate));
                    break;
                case 2:
                    System.out.print("Name: ");
                    String nameContactChange = sc.nextLine();
                    sc.nextLine();
                    Contact contactChange = contactManager.searchContactByname(nameContactChange);

                    System.out.print("New phone number: ");
                    int newnumber = sc.nextInt();
                    contactManager.addContact(new Contact(contactChange.getName(), newnumber, contactChange.getEmail(),
                            contactChange.getBirthDate()));
                    contactManager.removeContact(contactChange);
                    break;
                case 3:
                    System.out.print("Name: ");
                    String nameRemover = sc.nextLine();
                    sc.nextLine();
                    contactManager.removeContact(contactManager.searchContactByname(nameRemover));
                    break;
                case 4:
                    System.out.print("Name: ");
                    String nameProcurar = sc.nextLine();
                    sc.nextLine();
                    System.out.println(contactManager.searchContactByname(nameProcurar));
                    break;
                case 5:
                    System.out.print("Name: ");
                    int telemovelProcurar = sc.nextInt();
                    System.out.println(contactManager.searchContactByPhoneNumber(telemovelProcurar));
                    break;
                case 6:
                    System.out.print("Name: ");
                    String emailProcurar = sc.nextLine();
                    sc.nextLine();
                    System.out.println(contactManager.searchContactByEmail(emailProcurar));
                    break;
                case 7:
                    contactManager.listAllContacts();
                    break;
                case 8:
                    contactManager.listContactsByName();
                    ;
                    break;
                case 9:
                    contactManager.listContactsByPhoneNumber();
                    ;
                    break;
                case 10:
                    contactManager.listContactsByEmail();
                    ;
                    break;
                case 11:
                    contactManager.listContactsByBirthDate();
                    ;
                    break;

                case 12:
                    contactManager.save(filePath);
                    break;
            }
        } while (userchoise != 12);

        sc.close();
    }
}
