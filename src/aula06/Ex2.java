package aula06;

import aula05.DateYMD;
import java.util.Scanner;

class Contacto {
    private static int currentID = 1;
    private static Pessoa[] pessoas;

    private int id;
    private String numTelemovel;
    private String email;
    private Pessoa pessoa;

    public Contacto(String numTelemovel, String email, Pessoa pessoa) {
        this.id = currentID;
        this.numTelemovel = numTelemovel;
        this.email = email;
        this.pessoa = pessoa;

        Contacto.pessoas[currentID - 1] = this.pessoa;
        Contacto.currentID++;
    }

    public static boolean validContact(String numTelemovel) {
        if (numTelemovel.matches("[9]+\\d{8}") || numTelemovel == null) {
            return true;
        }
        return false;
    }

    public static boolean validEmail(String email) {
        if (email.matches("[a-z]+[@]{1}[a-z]+[.]{1}.+") || email == null) {
            return true;
        }
        return false;
    }

    public static boolean pessoaUnica(String nome, int cc, DateYMD data) {
        if (Contacto.pessoas == null) {
            return true;
        }
        for (int i = 0; i < pessoas.length; i++) {
            Pessoa pessoaNova = new Pessoa(nome, cc, data);
            if (pessoas[i].equals(pessoaNova)) {
                return true;
            }
        }
        // for (Pessoa pessoa : pessoas) {
        // Pessoa pessoaNova = new Pessoa(nome, cc, data);
        // if (pessoa.equals(pessoaNova)) {
        // return true;
        // }
        // }
        return false;
    }

    public Pessoa[] getPessoas() {
        return pessoas;
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputUser = 0;

        do {
            System.out.println(
                    "1 - Inserir contacto;\n2 - Alterar contacto;\n3 - Apagar contacto;\n4 - Procurar contacto\n5 - Listar contactos\n0 - Sair");
            inputUser = sc.nextInt();
            switch (inputUser) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.next();

                    System.out.print("CC: ");
                    int cc = sc.nextInt();

                    System.out.print("Data nascimento: ");
                    String data = sc.next();
                    String[] elementosData = data.split("-");
                    int day = Integer.parseInt(elementosData[0]);
                    int month = Integer.parseInt(elementosData[1]);
                    int year = Integer.parseInt(elementosData[2]);
                    DateYMD nascimento = new DateYMD(day, month, year);

                    Boolean pessoaUnica = Contacto.pessoaUnica(nome, cc, nascimento);
                    if (!pessoaUnica) {
                        System.out.println(
                                "Esta pessoa já existe. Quer continuar a inserir um novo contacto?\n 1 - sim\n2 - nao\n");
                        inputUser = sc.nextInt();
                        if (inputUser == 2) {
                            break;
                        }
                    }
                    Pessoa pessoa = new Pessoa(nome, cc, nascimento);

                    System.out.print("Numero telemovel: ");
                    String numTele = sc.next();
                    boolean valido = Contacto.validContact(numTele);
                    if (!valido) {
                        System.out.println("Numero invalido.");
                        break;
                    }

                    System.out.print("Email: ");
                    String mail = sc.next();
                    boolean emailValido = Contacto.validEmail(mail);
                    if (!emailValido) {
                        System.out.println("Email invalido.");
                        break;
                    }

                    if (numTele == null && mail == null) {
                        System.out.println("É necessário inserir pelo menos um número ou um email.");
                        break;
                    }

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
