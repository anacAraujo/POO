package aula06;

import java.util.Scanner;
import java.util.List;

public class MenuEx2 {

    private static Scanner sc = new Scanner(System.in);

    public static Contacto procurarContacto(ContactosInstituicao inst) {
        Contacto contactoAlterar = null;
        int userProcurar;

        System.out.println("Procurar contacto por:\n 1- nome\n 2 - numero");
        userProcurar = sc.nextInt();

        if (userProcurar == 1) {
            System.out.print("Nome: ");
            String nomeProcurar = sc.next();
            List<Contacto> listaContactos = inst.procurarContactoNome(nomeProcurar);
            if (listaContactos.get(0) == null) {
                System.out.println("Contacto nao existe.");
                return null;
            }
            contactoAlterar = listaContactos.get(0);

            if (listaContactos.size() > 1) {
                System.out.println(listaContactos);
                System.out.print("Id do contacto a alterar: ");
                int idAlterar = sc.nextInt();
                contactoAlterar = inst.procurarContactoID(idAlterar);
            }

        } else if (userProcurar == 2) {
            System.out.print("Numero: ");
            String numProcurar = sc.next();
            List<Contacto> listaContactos = inst.procurarContactoNum(numProcurar);
            if (listaContactos.get(0) == null) {
                System.out.println("Contacto nao existe.");
                return null;
            }
            contactoAlterar = listaContactos.get(0);

            if (listaContactos.size() > 1) {
                System.out.println(listaContactos);
                System.out.print("Id do contacto a alterar: ");
                int idAlterar = sc.nextInt();
                contactoAlterar = inst.procurarContactoID(idAlterar);
            }
        }
        return contactoAlterar;
    }

    public static void main(String[] args) {
        ContactosInstituicao inst = new ContactosInstituicao();

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

                    if (!DateYMD.valid(day, month, year)) {
                        System.out.println("Data invalida.");
                        break;
                    }
                    DateYMD nascimento = new DateYMD(day, month, year);

                    if (!Pessoa.validPessoa(nome, cc)) {
                        System.out.println("Dados invalidos.");
                        break;
                    }
                    Pessoa pessoa = new Pessoa(nome, cc, nascimento);

                    if (inst.verificarPessoaRepetida(pessoa)) {
                        System.out.println(
                                "Esta pessoa já existe. Quer continuar a inserir um novo contacto?\n1 - sim\n2 - nao\n");
                        inputUser = sc.nextInt();
                        if (inputUser == 2) {
                            break;
                        }
                    }

                    System.out.print("Numero telemovel: ");
                    String numTele = sc.next();
                    boolean valido = Contacto.validNumber(numTele);
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

                    if (!Contacto.validContact(pessoa, numTele, mail)) {
                        System.out.println("Contacto invalido");
                        break;
                    }
                    Contacto contacto = new Contacto(pessoa, numTele, mail);
                    inst.inserirContacto(contacto);
                    break;
                case 2:
                    System.out.print("Novo numero: ");
                    String novoNum = sc.next();

                    Contacto contactoAlterar = procurarContacto(inst);

                    if (contactoAlterar == null) {
                        break;
                    }

                    contactoAlterar.setNumTelemovel(novoNum);
                    break;
                case 3:
                    Contacto contactoApagar = procurarContacto(inst);

                    if (contactoApagar == null) {
                        break;
                    }
                    inst.apagarContacto(contactoApagar);
                    break;
                case 4:
                    // TODO tem de se criar a var contacto e processar o null
                    // procuar duas vezes porque???
                    procurarContacto(inst);
                    System.out.println(procurarContacto(inst));
                    break;
                case 5:
                    System.out.println(inst.toString());
                    break;
                default:
                    break;
            }
        } while (inputUser != 0);

        sc.close();
    }
}
