package aula06;

import aula05.DateYMD;
import java.util.Scanner;

class Contacto {
    private static int currentID = 1;

    private int id;
    private int numTelemovel;
    private String email;
    private Pessoa pessoa;

    public Contacto(int numTelemovel, String email, Pessoa pessoa) {
        this.id = currentID;
        this.numTelemovel = numTelemovel;
        this.email = email;
        this.pessoa = pessoa;
        Contacto.currentID++;
    }

    public static boolean validContact(int numTelemovel) {
        String numTele = Integer.toString(numTelemovel);
        if (numTele.matches("\\d{9}") && numTele.matches("\\^9")) {
            return true;
        }
        return false;
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputUser = 0;

        do {
            System.out.println(
                    "1 - Inserir contacto;\n2 - Alterar contacto;\n3 - Apagar contacto;\n4 - Procurar contacto\n5 - Procurar contacto\n0 - Sair");
            inputUser = sc.nextInt();
            switch (inputUser) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CC: ");
                    int cc = sc.nextInt();

                    System.out.print("Data nascimento: ");
                    String data = sc.nextLine();
                    String[] elementosData = data.split("-");
                    int day = Integer.parseInt(elementosData[0]);
                    int month = Integer.parseInt(elementosData[1]);
                    int year = Integer.parseInt(elementosData[2]);
                    DateYMD nascimento = new DateYMD(day, month, year);

                    System.out.print("Numero telemovel: ");
                    int numTele = sc.nextInt();
                    boolean valido = Contacto.validContact(numTele);
                    if (!valido) {
                        System.out.println("Numero invalido.");
                        break;
                    }

                    System.out.print("Email: ");
                    String mail = sc.nextLine();

                    Pessoa pessoa = new Pessoa(nome, cc, nascimento);
                    Contacto contacto = new Contacto(numTele, mail, pessoa);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    break;
            }
        } while (inputUser != 0);

        sc.close();
    }
}
