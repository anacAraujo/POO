package aula04;

class Triangulo {
    int lado1;
    int lado2;
    int lado3;

    Triangulo(int l1, int l2, int l3) {
        do {
            System.out.println("Valores inválidos.");
            break;
        } while (l1 + l2 < l3 || l2 + l3 < l1 || l3 + l1 < l2 || l1 <= 0 || l2 <= 0 || l3 <= 0);
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
    }

    public int getLado1() {
        do {
            System.out.println("Insira um valor maior que zero.");
            break;
        } while (lado1 <= 0);
        return lado1;
    }

    public int getLado2() {
        do {
            System.out.println("Insira um valor maior que zero.");
            break;
        } while (lado2 <= 0);
        return lado2;
    }

    public int getLado3() {
        do {
            System.out.println("Insira um valor maior que zero.");
            break;
        } while (lado3 <= 0);
        return lado3;
    }

    public void setLado1(int valorLado1) {
        do {

        } while (valorLado1 <= 0);
        this.lado1 = valorLado1;
    }

    public void setLado2(int valorLado2) {
        do {

        } while (valorLado2 <= 0);
        this.lado2 = valorLado2;
    }

    public void setLado3(int valorLado3) {
        do {

        } while (valorLado3 <= 0);
        this.lado3 = valorLado3;
    }

    public String toString() {
        return "triangulo de lados: " + lado1 + ", " + lado2 + ", " + lado3;
    }

    // Triangulos com lados iguais mas por ordem diferente são considerados iguais
    public boolean equals(Triangulo outroTriangulo) {
        if (this.lado1 == outroTriangulo.lado1) {
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

    public double area() {
        double area = (lado1 + lado2 + lado3) / 2.0d;
        return Math.sqrt(area * (area - lado1) * (area - lado2) * (area - lado3));
    }

    public int perimetro() {
        return (this.lado1 + this.lado2 + this.lado3);
    }

}
