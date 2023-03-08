package aula04;

class Retangulo {
    int comprimento;
    int largura;

    Retangulo(int c, int l) {
        do {
            System.out.println("Insira um valor maior que zero.");
            break;
        } while (c <= 0 || l <= 0);
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
        do {
            System.out.println("Insira um valor maior que zero.");
            break;
        } while (comprimento <= 0);
        this.comprimento = comprimento;
    }

    public void setLargura(int largura) {
        do {
            System.out.println("Insira um valor maior que zero.");
            break;
        } while (largura <= 0);
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
