package aula07;

class Triangulo extends Forma {
    private int lado1;
    private int lado2;
    private int lado3;

    public Triangulo(int l1, int l2, int l3, String cor) {
        if (l1 + l2 < l3 || l2 + l3 < l1 || l3 + l1 < l2 || l1 <= 0 || l2 <= 0 || l3 <= 0) {
            System.out.println("Lados do triangulo invalidos.");
            return;
        }
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
        this.cor = cor;
    }

    public int getLado1() {
        return lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public int getLado3() {
        return lado3;
    }

    public void setLado1(int valorLado1) {
        if (valorLado1 + this.lado2 < this.lado3 ||
                this.lado2 + this.lado3 < valorLado1 ||
                this.lado3 + valorLado1 < this.lado2 ||
                valorLado1 <= 0) {
            System.out.println("Lados do triangulo invalidos.");
            return;
        }
        this.lado1 = valorLado1;
    }

    public void setLado2(int valorLado2) {
        if (this.lado1 + valorLado2 < this.lado3 ||
                valorLado2 + this.lado3 < this.lado1 ||
                this.lado3 + this.lado1 < valorLado2 ||
                valorLado2 <= 0) {
            System.out.println("Lados do triangulo invalidos.");
            return;
        }
        this.lado2 = valorLado2;
    }

    public void setLado3(int valorLado3) {
        if (this.lado1 + this.lado2 < valorLado3 ||
                this.lado2 + valorLado3 < this.lado1 ||
                valorLado3 + this.lado1 < this.lado2 ||
                valorLado3 <= 0) {
            System.out.println("Lados do triangulo invalidos.");
            return;
        }
        this.lado3 = valorLado3;
    }

    // TODO override
    public double area() {
        double area = (lado1 + lado2 + lado3) / 2.0d;
        return Math.sqrt(area * (area - lado1) * (area - lado2) * (area - lado3));
    }

    // TODO override
    public double perimetro() {
        return (this.lado1 + this.lado2 + this.lado3);
    }

    // Triangulos com lados iguais mas por ordem diferente são considerados iguais
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Triangulo)) {
            return false;
        }

        Triangulo outroTriangulo = (Triangulo) obj;

        if (!super.equals(obj)) {
            // TODO como tem os return, não precisa de else
            return false;
        } else if (this.lado1 == outroTriangulo.lado1) {
            if (this.lado2 == outroTriangulo.lado2) {
                return true;
            } else if (this.lado2 == outroTriangulo.lado3) {
                return true;
            }
        } else if (this.lado1 == outroTriangulo.lado2) {
            if (this.lado2 == outroTriangulo.lado3) {
                return true;
            } else if (this.lado2 == outroTriangulo.lado1) {
                return true;
            }
        } else if (this.lado1 == outroTriangulo.lado3) {
            if (this.lado2 == outroTriangulo.lado1) {
                return true;
            } else if (this.lado2 == outroTriangulo.lado2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("triangulo de lados:%d, %d e %d; %s",
                this.lado1,
                this.lado2,
                this.lado3,
                super.toString());
    }
}
