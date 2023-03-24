package aula06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactosInstituicao {

    private List<Contacto> contactos;

    public ContactosInstituicao() {
        this.contactos = new ArrayList<Contacto>();
    }

    // TODO passar elementos contacto e vaidar - retornar false se não for valido e
    // no menu apresentar a mensagem
    public void inserirContacto(Contacto contacto) {
        this.contactos.add(contacto);
    }

    public List<Contacto> procurarContactoNum(String num) {
        List<Contacto> result = new ArrayList<>();
        for (Contacto contacto : contactos) {
            if (contacto.getNumTelemovel() == num) {
                result.add(contacto);
            }
        }
        return result;
    }

    public List<Contacto> procurarContactoNome(String nome) {
        List<Contacto> result = new ArrayList<>();
        for (Contacto contacto : contactos) {
            Pessoa pessoa = contacto.getPessoa();
            if (pessoa.getName() == nome) {
                result.add(contacto);
            }
        }
        return result;
    }

    public Contacto procurarContactoID(int id) {
        for (Contacto contacto : contactos) {
            if (contacto.getId() == id) {
                return contacto;
            }
        }
        return null;
    }

    public Contacto procurarContacto() {
        Scanner sc = new Scanner(System.in);
        Contacto contactoAlterar = null;
        int userProcurar;

        System.out.println("Procurar contacto por:\n 1- nome\n 2 - numero");
        userProcurar = sc.nextInt();

        if (userProcurar == 1) {
            System.out.print("Nome: ");
            String nomeProcurar = sc.next();
            List<Contacto> listaContactos = procurarContactoNome(nomeProcurar);
            contactoAlterar = listaContactos.get(0);

            if (listaContactos.size() > 1) {
                System.out.println(listaContactos);
                System.out.print("Id do contacto a alterar: ");
                int idAlterar = sc.nextInt();
                contactoAlterar = procurarContactoID(idAlterar);
            }

        } else if (userProcurar == 2) {
            System.out.print("Numero: ");
            String numProcurar = sc.next();
            List<Contacto> listaContactos = procurarContactoNum(numProcurar);
            contactoAlterar = listaContactos.get(0);

            if (listaContactos.size() > 1) {
                System.out.println(listaContactos);
                System.out.print("Id do contacto a alterar: ");
                int idAlterar = sc.nextInt();
                contactoAlterar = procurarContactoID(idAlterar);
            }
        }
        return contactoAlterar;
    }

    public void apagarContacto(Contacto contacto) {
        this.contactos.remove(contacto);
    }

    public boolean verificarPessoaRepetida(Pessoa pessoa) {
        for (Contacto contacto : contactos) {
            if (contacto.getPessoa().equals(pessoa)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "Lista de contactos:\n";
        for (Contacto contacto : contactos) {
            result += contacto.toString();
        }
        return result;
    }
}
