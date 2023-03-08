package aula04;

class Circulo {
    private int raio;

    Circulo(int r) {
        do {
            System.out.println("Raio tem de ser maior que 0.");
            break;
        } while (raio <= 0);
        this.raio = r;
    }

    public int getRaio() {
        return this.raio;
    }

    public void setRaio(int raio) {
        do {
            System.out.println("Raio tem de ser maior que 0.");
            break;
        } while (raio <= 0);
        this.raio = raio;
    }

    public String toString() {
        return "Circulo com raio: " + this.raio;
    }

    public boolean equals(Circulo outroCirculo) {
        if (this.raio == outroCirculo.raio) {
            return true;
        } else {
            return false;
        }
    }

    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }

    public double perimetro() {
        return Math.PI * this.raio * 2.0d;
    }
}
