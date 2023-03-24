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
    public boolean equals(Object obj) {
        if (!(obj instanceof Pessoa)) {
            return false;
        }
        Pessoa outraPessoa = (Pessoa) obj;
        if (this.nome == outraPessoa.nome && this.cc == outraPessoa.cc && this.dataNasc == outraPessoa.dataNasc) {
            return true;
        }
        return false;
    }
}
