package aula07;

class Circulo extends Forma {
    private int raio;

    public Circulo(int r, String cor) {
        if (r <= 0 || cor == "") {
            System.out.println("Valores invalidos.");
            return;
        }
        this.raio = r;
        this.cor = cor;
    }

    public int getRaio() {
        return this.raio;
    }

    public String getCor() {
        return this.cor;
    }

    public void setRaio(int raio) {
        if (raio <= 0) {
            System.out.println("Raio tem de ser maior que 0.");
            return;
        }
        this.raio = raio;
    }

    public String toString() {
        return String.format("Circulo com raio:%d; %s",
                this.raio,
                super.toString());
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Circulo)) {
            return false;
        }

        Circulo outroCirculo = (Circulo) obj;

        if (this.raio == outroCirculo.raio && super.equals(obj)) {
            return true;
        }
        return false;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double perimetro() {
        return Math.PI * this.raio * 2.0d;
    }
}
