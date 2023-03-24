package aula06;

import java.util.ArrayList;
import java.util.List;

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
