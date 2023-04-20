package aula06;

public class Pessoa {
    private String nome;
    private int cc;
    private DateYMD dataNasc;

    public Pessoa(String nome, int cc, DateYMD dataNasc) {
        if (!DateYMD.valid(dataNasc.getDay(), dataNasc.getMonth(), dataNasc.getYear())) {
            System.out.println("Data invalida.");
            return;
        }
        if (!validPessoa(nome, cc)) {
            System.out.println("Dados invalidos.");
            return;
        }
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }

    public static boolean validPessoa(String nome, int numcc) {
        String cc = Integer.toString(numcc);
        if (!nome.strip().matches("[a-zA-Z\s]+") || !cc.matches("[0-9]{8}")) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.nome;
    }

    public int getCC() {
        return this.cc;
    }

    public DateYMD getDataNasc() {
        return this.dataNasc;
    }

    @Override
    public String toString() {
        return String.format("%s; CC: %d; Data de nascimento: %s",
                this.nome,
                this.cc,
                this.dataNasc.toString());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + cc;
        result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cc != other.cc)
            return false;
        if (dataNasc == null) {
            if (other.dataNasc != null)
                return false;
        } else if (!dataNasc.equals(other.dataNasc))
            return false;
        return true;
    }

}
