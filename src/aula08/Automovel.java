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
    public String toString() {
        return String.format("Matricula: %s; Marca: %s; Modelo: %s; Potencia: %d",
                this.matricula,
                this.marca,
                this.modelo,
                this.potencia);
    }
}
