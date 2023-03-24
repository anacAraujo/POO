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

                    inst.procurarContacto().setNumTelemovel(novoNum);
                    break;
                case 3:
                    inst.apagarContacto(inst.procurarContacto());
                    break;
                case 4:
                    inst.procurarContacto();
                    System.out.println(inst.procurarContacto());
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
