package aula07;

class Retangulo extends Forma {
    private int comprimento;
    private int largura;

    public Retangulo(int c, int l, String cor) {
        if (c <= 0 || l <= 0) {
            System.out.println("Insira um valor maior que zero.");
            return;
        }
        this.comprimento = c;
        this.largura = l;
        this.cor = cor;
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

    @Override
    public double area() {
        return (this.comprimento * this.largura);
    }

    @Override
    public double perimetro() {
        return 2 * (this.comprimento + this.largura);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Retangulo)) {
            return false;
        }

        Retangulo outroRetangulo = (Retangulo) obj;
        if (this.comprimento == outroRetangulo.comprimento && this.largura == outroRetangulo.largura
                && super.equals(obj)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Retangulo de comprimento:%d; largura:%d; %s",
                this.comprimento,
                this.largura,
                this.toString());
    }
}
