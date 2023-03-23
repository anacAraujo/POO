package aula06;

import aula05.DateYMD;
import java.util.Scanner;

public class TesteEx2 {
    // public static void main(String[] args) {
    // ContactosInstituicao inst = new ContactosInstituicao();
    // Pessoa p1 = new Pessoa("ana", 11111111, new DateYMD(1, 1, 1111));
    // Contacto c1 = new Contacto(p1, "987654321", "ana@gmail.com");
    // inst.inserirContacto(c1);

    // System.out.println(c1);

    // Contacto c2 = new Contacto(p1, "908765432", "aaaa@ddd.ddd");
    // inst.inserirContacto(c2);

    // System.out.println(c2.equals(c1));

    // System.out.println(inst);

    // System.out.println(inst.procurarContactoNome(c1.getPessoa().getName()));
    // System.out.println(inst.procurarContactoID(c1.getId()));
    // }
    public static void main(String[] args) {
        ContactosInstituicao inst = new ContactosInstituicao();

        Scanner sc = new Scanner(System.in);

        int inputUser = 0;

        do {
            System.out.println(
                    "1 - Inserir contacto;\n2 - Alterar contacto;\n3 - Apagar contacto;\n4 - Procurar contacto\n5 - Listar contactos\n0 - Sair");
            inputUser = sc.nextInt();
            int userProcurar = 0;
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

                    Pessoa pessoa = new Pessoa(nome, cc, nascimento);

                    if (!inst.verificarPessoaRepetida(pessoa)) {
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

                    if (numTele == null && mail == null) {
                        System.out.println("É necessário inserir pelo menos um número ou um email.");
                        break;
                    }

                    Contacto contacto = new Contacto(pessoa, numTele, mail);
                    inst.inserirContacto(contacto);
                    break;
                case 2:
                    System.out.println("Procurar contacto por:\n 1- nome\n 2 - numero");
                    userProcurar = sc.nextInt();

                    if (userProcurar == 1) {
                        System.out.print("Nome: ");
                        String nomeProcurar = sc.next();
                        inst.procurarContactoNome(nomeProcurar);

                        System.out.print("Id do contacto a alterar: ");
                        int idAlterar = sc.nextInt();
                        System.out.print("Novo numero: ");
                        String novoNum = sc.next();

                        inst.alterarContactonum(inst.procurarContactoID(idAlterar), novoNum);

                    } else if (userProcurar == 2) {
                        System.out.print("Numero: ");
                        String numProcurar = sc.next();

                        System.out.print("Novo numero: ");
                        String novoNum = sc.next();

                        inst.alterarContactonum(inst.procurarContactoNum(numProcurar), novoNum);
                    }
                    break;
                case 3:
                    System.out.println("Procurar contacto por:\n 1- nome\n 2 - numero");
                    userProcurar = sc.nextInt();

                    if (userProcurar == 1) {
                        System.out.print("Nome: ");
                        String nomeProcurar = sc.next();
                        inst.procurarContactoNome(nomeProcurar);

                        System.out.print("Id do contacto a apagar: ");
                        int idApagar = sc.nextInt();

                        inst.apagarContacto(inst.procurarContactoID(idApagar));

                    } else if (userProcurar == 2) {
                        System.out.print("Numero: ");
                        String numProcurar = sc.next();

                        inst.apagarContacto(inst.procurarContactoNum(numProcurar));
                    }

                    break;
                case 4:
                    System.out.println("Procurar contacto por:\n 1- nome\n 2 - numero");
                    userProcurar = sc.nextInt();

                    if (userProcurar == 1) {
                        System.out.print("Nome: ");
                        String nomeProcurar = sc.next();
                        inst.procurarContactoNome(nomeProcurar);

                    } else if (userProcurar == 2) {
                        System.out.print("Numero: ");
                        String numProcurar = sc.next();
                        inst.procurarContactoNum(numProcurar);
                    }
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
