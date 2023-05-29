package teste2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ContactManager implements ContactManagerInterface {
    Map<Integer, Contact> phoneList;

    public ContactManager() {
        phoneList = new HashMap<>();
    }

    public void load(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\t");
                phoneList.put(Contact.idStatic,
                        new Contact(data[0], Integer.parseInt(data[1]), data[2], LocalDate.parse(data[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    public void save(String filePath) {
        try {
            FileOutputStream output = new FileOutputStream(filePath);
            ObjectOutputStream object = new ObjectOutputStream(output);
            object.writeObject(phoneList);
            object.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean validateEmail(String email) {
        if (email.matches("^(.+)@(.+)$")) {
            return true;
        }
        return false;
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("[0-9]{9}")) {
            return true;
        }
        return false;
    }

    public boolean addContact(Contact person) {
        for (Contact contacto : phoneList.values()) {
            if (person.equals(contacto)) {
                System.out.println("Inalid data.");
                return false;
            }
        }
        phoneList.put(person.getId(), person);
        return true;
    }

    public boolean removeContact(Contact person) {
        for (Contact contacto : phoneList.values()) {
            if (person.equals(contacto)) {
                phoneList.remove(person.getId());
                return true;
            }
        }
        return false;
    }

    public Contact searchContactByname(String name) {
        for (Contact contacto : phoneList.values()) {
            if (name.equals(contacto.getName())) {
                return contacto;
            }
        }
        return null;
    }

    public Contact searchContactByEmail(String email) {
        for (Contact contacto : phoneList.values()) {
            if (email.equals(contacto.getEmail())) {
                return contacto;
            }
        }
        return null;
    }

    public Contact searchContactByPhoneNumber(int phoneNumber) {
        for (Contact contacto : phoneList.values()) {
            if (phoneNumber == contacto.getPhoneNumber()) {
                return contacto;
            }
        }
        return null;
    }

    public void listAllContacts() {
        System.out.println("Contacts:\n");
        for (Contact contacto : phoneList.values()) {
            System.out.println(contacto.toString());
        }
    }

    public void listContactsByName() {
        TreeMap<String, Contact> moviesTime = new TreeMap<>();
        phoneList.forEach((name, contact) -> moviesTime.put(contact.getName(), contact));
        moviesTime.forEach((name, contact) -> System.out.println(String.format("%s", contact)));
    }

    public void listContactsByEmail() {
        TreeMap<String, Contact> moviesTime = new TreeMap<>();
        phoneList.forEach((email, contact) -> moviesTime.put(contact.getEmail(), contact));
        moviesTime.forEach((email, contact) -> System.out.println(String.format("%s", contact)));
    }

    public void listContactsByPhoneNumber() {
        TreeMap<Integer, Contact> moviesTime = new TreeMap<>();
        phoneList.forEach((phoneNumber, contact) -> moviesTime.put(contact.getPhoneNumber(), contact));
        moviesTime.forEach((phoneNumber, contact) -> System.out.println(String.format("%s", contact)));
    }

    public void listContactsByBirthDate() {
        TreeMap<LocalDate, Contact> moviesTime = new TreeMap<>();
        phoneList.forEach((birthdate, contact) -> moviesTime.put(contact.getBirthDate(), contact));
        moviesTime.forEach((birthdate, contact) -> System.out.println(String.format("%s", contact)));
    }
}
