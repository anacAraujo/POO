package aula04;

class Circulo {
    private int raio;

    Circulo(int r) {
        this.raio = r;
    }

    public int getRaio() {
        return this.raio;
    }

    public void setRaio(int raio) {
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

class Triangulo {
    int lado1;
    int lado2;
    int lado3;

    Triangulo(int l1, int l2, int l3) {
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
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

class Retangulo {
    int comprimento;
    int largura;

    Retangulo(int c, int l) {
        this.comprimento = c;
        this.largura = l;
    }

    public int getComprimento() {
        return comprimento;
    }

    public int getLargura() {
        return largura;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public String toString() {
        return "retangulo de comprimento: " + comprimento + " e largura: " + largura;
    }

    public boolean equals(Retangulo outroRetangulo) {
        if (this.comprimento == outroRetangulo.comprimento && this.largura == outroRetangulo.largura) {
            return true;
        }
        return false;
    }

    public int area() {
        return (this.comprimento * this.largura);
    }

    public int perimetro() {
        return (this.comprimento + this.largura);
    }
}

public class Figuras {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(30);
        Circulo circulo2 = new Circulo(3);
        System.out.println(circulo1.getRaio());
        circulo1.setRaio(50);
        System.out.println(circulo1.getRaio());
        System.out.println(circulo1.equals(circulo2));

        Triangulo t1 = new Triangulo(3, 4, 3);
        Triangulo t2 = new Triangulo(4, 3, 3);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t1.equals(t2));

        Retangulo r1 = new Retangulo(2, 5);
        Retangulo r2 = new Retangulo(2, 5);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1.equals(r2));
    }
}
// falta ponto (c e (f