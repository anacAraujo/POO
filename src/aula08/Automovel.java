package aula08;

public abstract class Automovel {
    private String matricula;
    private String marca;
    private String modelo;
    private double potencia;

    public Automovel(String matricula, String marca, String modelo, double potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public void validMaricula() {

    }

    public void validMarca() {

    }

    public void validModelo() {

    }

    public void validPotencia() {

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
