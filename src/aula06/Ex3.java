package aula06;

class Conjunto {
    private static int currentPos = 0;

    int[] conjunto;

    public Conjunto() {
        conjunto = new int[10];
    }

    // – para inserir um elemento novo no conjunto. Caso este elemento já exista,
    // a função não faz nada. Inicialmente não se sabe quantos elementos vamos
    // inserir.
    public void insert(int n) {
        if (contains(n)) {
            return;
        }
        conjunto[currentPos] = n;
        currentPos++;
    }

    // – para indicar se um dado elemento está no conjunto.
    public boolean contains(int n) {
        for (int i = 0; i < conjunto.length; i++) {
            if (this.conjunto[i] == n) {
                return true;
            }
        }
        return false;
    }

    // - para remover um elemento do conjunto. Caso este elemento não se encontre no
    // conjunto, a função não faz nada.
    public void remove(int n) {
        if (this.conjunto == null) {
            System.out.println("Conjunto não existe.");
            return;
        }
        int pos;
        for (int i = 0; i < conjunto.length; i++) {
            if (this.conjunto[i] == n) {
                pos = i;
                for (int j = pos; j < conjunto.length - 1; j++) {
                    this.conjunto[j] = this.conjunto[j + 1];
                }
            }
        }

    }

    // para apagar todos os elementos do conjunto
    public void empty() {
        if (this.conjunto == null) {
            System.out.println("Conjunto não existe.");
            return;
        }

    }

    public String toString() {
        String result = "";
        for (int i = 0; i < conjunto.length; i++) {
            result += String.format("%2d", this.conjunto[i]);
        }
        return result;
    }

    // - para calcular o número de elementos no conjunto.
    public int size() {
        return this.conjunto.length;
    }
}

public class Ex3 {
    public static void main(String[] args) {
        Conjunto c1 = new Conjunto();
        c1.insert(4);
        c1.insert(7);
        c1.insert(6);
        c1.insert(5);
        Conjunto c2 = new Conjunto();
        int[] test = { 7, 3, 2, 5, 4, 6, 7 };
        for (int el : test)
            c2.insert(el);
        c2.remove(3);
        c2.remove(5);
        c2.remove(6);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("Número de elementos em c1: " + c1.size());
        System.out.println("Número de elementos em c2: " + c2.size());

        System.out.println("c1 contém 6?: " + ((c1.contains(6) ? "sim" : "não")));
        System.out.println("c2 contém 6?: " + ((c2.contains(6) ? "sim" : "não")));
        // System.out.println("União:" + c1.combine(c2));
        // System.out.println("Interseção:" + c1.intersect(c2));
        // System.out.println("Diferença:" + c1.subtract(c2));
        c1.empty();
        System.out.println("c1:" + c1);
    }
}