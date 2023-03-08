package aula04;

class Retangulo {
    private int comprimento;
    private int largura;

    public Retangulo(int c, int l) {
        if (c <= 0 || l <= 0) {
            System.out.println("Insira um valor maior que zero.");
            return;
        }
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
        if (comprimento <= 0) {
            System.out.println("Insira um valor maior que zero.");
            return;
        }
        this.comprimento = comprimento;
    }

    public void setLargura(int largura) {
        if (largura <= 0) {
            System.out.println("Insira um valor maior que zero.");
            return;
        }
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
        return 2 * (this.comprimento + this.largura);
    }
}
