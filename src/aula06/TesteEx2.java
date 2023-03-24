package aula06;

import java.util.Scanner;

public class TesteEx2 {
    public static void main(String[] args) {
        ContactosInstituicao inst = new ContactosInstituicao();
        Pessoa p1 = new Pessoa("ana", 11111111, new DateYMD(1, 1, 1111));
        Pessoa p2 = new Pessoa("wer", 33333333, new DateYMD(6, 9, 2222));
        Contacto c1 = new Contacto(p1, "987654321", "ana@gmail.com");
        Contacto c2 = new Contacto(p1, "908765432", "aaaa@ddd.ddd");
        Contacto c3 = new Contacto(p2, "978789789", "rfgh@bbbb.mm");

        System.out.println("1 - INSERIR");

        inst.inserirContacto(c1);
        inst.inserirContacto(c2);
        inst.inserirContacto(c3);
        System.out.println(inst);

        System.out.println("2 - ALTERAR");
        inst.procurarContactoNome("ana").get(0).setNumTelemovel("999999999");
        System.out.println(inst);

        System.out.println("3 - APAGAR");
        inst.apagarContacto(inst.procurarContactoNum("999999999").get(0));
        System.out.println(inst);

        System.out.println("4 - PROCURAR");
        System.out.println(inst.procurarContactoID(1));
        System.out.println(inst.procurarContactoID(2));
    }
}
