package aula11.ex4;

import java.util.List;

public class Voo {

    private String hora, nome, origem, atraso, previsao;

    public Voo(String hora, String nome, String origem, String atraso) {
        this.hora = hora;
        this.nome = nome;
        this.origem = origem;
        this.atraso = atraso;
        this.previsao = "";

        if (this.atraso != "") {
            int minutosAtraso = Integer.parseInt(atraso);
            int minutosHora = Integer.parseInt(hora.substring(3));

            int totalMinutos = minutosHora + minutosAtraso;

            int novaHora = Integer.parseInt(hora.substring(0, 2));
            int novaMinutos = totalMinutos % 60;
            novaHora += totalMinutos / 60;
            novaHora = novaHora % 24;

            String horaPrevista = String.format("%02d:%02d", novaHora, novaMinutos);
            this.previsao = horaPrevista;
        }
    }

    public String getHora() {
        return hora;
    }

    public String getNome() {
        return nome;
    }

    public String getOrigem() {
        return origem;
    }

    public String getAtraso() {
        return atraso;
    }

    public String getPrevisao() {
        return previsao;
    }

    public String getSiglaCompanhia() {
        return this.nome.length() < 2 ? this.nome : this.nome.substring(0, 2);
    }

    public static double calcularAtrasoMedio(List<Integer> atrasos) {
        int totalAtrasos = 0;
        for (int atraso : atrasos) {
            totalAtrasos += atraso;
        }
        return (double) totalAtrasos / atrasos.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hora == null) ? 0 : hora.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((origem == null) ? 0 : origem.hashCode());
        result = prime * result + ((atraso == null) ? 0 : atraso.hashCode());
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
        Voo other = (Voo) obj;
        if (hora == null) {
            if (other.hora != null)
                return false;
        } else if (!hora.equals(other.hora))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (origem == null) {
            if (other.origem != null)
                return false;
        } else if (!origem.equals(other.origem))
            return false;
        if (atraso == null) {
            if (other.atraso != null)
                return false;
        } else if (!atraso.equals(other.atraso))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String atrasoString = "";
        if (this.atraso != null) {
            atrasoString = this.atraso;
        }
        return String.format("%2s %2s %2s %2s",
                this.hora,
                this.nome,
                this.origem,
                atrasoString);
    }
}
