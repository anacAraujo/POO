package aula07;

public abstract class Forma {
    public abstract double perimetro();

    public abstract double area();

    public String cor;

    @Override
    public boolean equals(Object obj) {
        Forma outro = (Forma) obj;

        if (this.cor == outro.cor) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Cor:%s", this.cor);
    }
}
