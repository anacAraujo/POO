package aula06;

import java.util.List;
import java.util.Scanner;

public class MenuEx2 {
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
                    // TODO validar data
                    DateYMD nascimento = new DateYMD(day, month, year);

                    // TODO validar pessoa
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

                    // TODO validar contacto
                    Contacto contacto = new Contacto(pessoa, numTele, mail);
                    inst.inserirContacto(contacto);
                    break;
                case 2:
                    //
                    System.out.println("Procurar contacto por:\n 1- nome\n 2 - numero");
                    userProcurar = sc.nextInt();

                    if (userProcurar == 1) {
                        System.out.print("Nome: ");
                        String nomeProcurar = sc.next();
                        List<Contacto> contactos = inst.procurarContactoNome(nomeProcurar);
                        Contacto contactoAlterar = contactos.get(0);

                        if (contactos.size() > 1) {
                            System.out.println(contactos);
                            System.out.print("Id do contacto a alterar: ");
                            int idAlterar = sc.nextInt();
                            contactoAlterar = inst.procurarContactoID(idAlterar);
                        }
                        // return contactoAlterar
                        System.out.print("Novo numero: ");
                        String novoNum = sc.next();

                        contactoAlterar.setNumTelemovel(novoNum);

                    } else if (userProcurar == 2) {
                        System.out.print("Numero: ");
                        String numProcurar = sc.next();
                        List<Contacto> contactos = inst.procurarContactoNum(numProcurar);
                        Contacto contactoAlterar = contactos.get(0);

                        // TODO if mais do que um - igual ao de cima
                        System.out.print("Novo numero: ");
                        String novoNum = sc.next();

                        contactoAlterar.setNumTelemovel(novoNum);
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

                        inst.apagarContacto(inst.procurarContactoNum(numProcurar).get(0));
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
