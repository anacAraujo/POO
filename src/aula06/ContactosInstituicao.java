package aula06;

import java.util.ArrayList;
import java.util.List;
import aula05.DateYMD;

public class ContactosInstituicao {

    private List<Contacto> contactos;

    public ContactosInstituicao() {
        this.contactos = new ArrayList<Contacto>();
    }

    public void inserirContacto(Contacto contacto) {
        this.contactos.add(contacto);
    }

    public Contacto procurarContactoNum(String num) {
        for (Contacto contacto : contactos) {
            if (contacto.getNumTelemovel() == num) {
                return contacto;
            }
        }
        System.out.println("Contacto não existe.");
        return null;
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
        System.out.println("Id invalido.");
        return null;
    }

    public void apagarContacto(Contacto contacto) {
        this.contactos.remove(contacto);
    }

    public void alterarContactonum(Contacto contacto, String num) {
        for (Contacto contacto2 : contactos) {
            if (contacto2.equals(contacto)) {
                contacto.setNumTelemovel(num);
            }
        }
    }

    // public void alterarContactoEmail(Contacto contacto, String email) {
    // for (Contacto contacto2 : contactos) {
    // if (contacto2.equals(contacto)) {
    // contacto.setEmail(email);
    // }
    // }
    // }

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
