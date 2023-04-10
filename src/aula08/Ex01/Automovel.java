package aula08.Ex01;

public abstract class Automovel implements KmPercorridosInterface {

    private String matricula;
    private String marca;
    private String modelo;
    private double potencia;
    private int kmAtuais;
    private int kmTotal;

    public Automovel(String matricula, String marca, String modelo, double potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.kmAtuais = 0;
        this.kmTotal = 0;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public boolean validAutomovel(String matricula) {
        if (this.matricula.equals(matricula) || marca == null || modelo == null || potencia <= 0) {
            return false;
        }
        return true;
    }

    // public void validMarca() {

    // }

    // public void validModelo() {

    // }

    // public void validPotencia() {

    // }

    public void trajeto(int quilometros) {
        if (quilometros <= 0) {
            System.out.println("Número inválido: " + quilometros + "km.");
            return;
        }
        this.kmAtuais = quilometros;
        this.kmTotal += quilometros;
    }

    public int ultimoTrajeto() {
        return this.kmAtuais;
    }

    public int distanciaTotal() {
        return this.kmTotal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
        Automovel other = (Automovel) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Matricula: %s; Marca: %s; Modelo: %s; Potencia: %f",
                this.matricula,
                this.marca,
                this.modelo,
                this.potencia);
    }
}
