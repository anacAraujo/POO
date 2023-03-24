package aula06;

public class Contacto {
    private static int currentID = 1;

    private int id;
    private Pessoa pessoa;
    private String numTelemovel;
    private String email;

    public Contacto(Pessoa pessoa, String numTelemovel, String email) {
        if (!Contacto.validContact(pessoa, numTelemovel, email)) {
            System.out.println("Contacto invalido.");
            return;
        }
        this.id = currentID;
        this.numTelemovel = numTelemovel;
        this.email = email;
        this.pessoa = pessoa;

        Contacto.currentID++;
    }

    public int getId() {
        return this.id;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public String getNumTelemovel() {
        return this.numTelemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setNumTelemovel(String numTelemovel) {
        this.numTelemovel = numTelemovel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static boolean validNumber(String numTelemovel) {
        if (numTelemovel.matches("[9]\\d{8}")) {
            return true;
        }
        return false;
    }

    public static boolean validEmail(String email) {
        return email.matches("[a-z]+[@]{1}[a-z]+[.]{1}[a-z]+");
    }

    public static boolean validContact(Pessoa pessoa, String numTelemovel, String email) {
        if (!Pessoa.validPessoa(pessoa.getName(), pessoa.getCC())) {
            return false;
        }
        if (numTelemovel == null && email == null) {
            return false;
        }
        if (numTelemovel != null && !validNumber(numTelemovel)) {
            return false;
        }
        if (email != null && !validEmail(email)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Contacto)) {
            return false;
        }

        Contacto c = (Contacto) obj;

        return this.id == c.id;
    }

    @Override
    public String toString() {
        return String.format("ID: %d; %s; Telemovel: %s; Email: %s\n",
                this.id,
                this.pessoa.toString(),
                this.numTelemovel,
                this.email);
    }

}
