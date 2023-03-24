package aula06;

class Conjunto {
    private int[] conjunto;
    private int currentPos = 0;

    public Conjunto() {
        conjunto = new int[100];
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
        for (int i = 0; i < currentPos; i++) {
            if (this.conjunto[i] == n) {
                return true;
            }
        }
        return false;
    }

    // - para remover um elemento do conjunto. Caso este elemento não se encontre no
    // conjunto, a função não faz nada.
    public void remove(int n) {
        if (!contains(n)) {
            return;
        }
        int pos = 0;
        for (int i = 0; i < currentPos; i++) {
            if (this.conjunto[i] == n) {
                pos = i;
                break;
            }
        }
        for (int j = pos; j < currentPos - 1; j++) {
            this.conjunto[j] = this.conjunto[j + 1];
        }
        currentPos--;
    }

    // para apagar todos os elementos do conjunto
    public void empty() {
        this.currentPos = 0;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < currentPos; i++) {
            result += String.format("%2d", this.conjunto[i]);
        }
        return result;
    }

    // - para calcular o número de elementos no conjunto.
    public int size() {
        return currentPos;
    }

    // para construir um conjunto novo que representa a união de dois conjuntos. O
    // conjunto resultante não deve conter elementos repetidos.
    public Conjunto combine(Conjunto add) {
        Conjunto juncao = new Conjunto();
        for (int i = 0; i < currentPos; i++) {
            juncao.insert(this.conjunto[i]);
        }
        for (int i = 0; i < currentPos; i++) {
            juncao.insert(add.conjunto[i]);
        }
        return juncao;
    }

    // para construir um conjunto novo que representa a diferença do this e dos
    // elementos do conjunto representado pelo objeto dif
    public Conjunto subtract(Conjunto dif) {
        Conjunto subtracao = new Conjunto();
        for (int i = 0; i < currentPos; i++) {
            if (!dif.contains(this.conjunto[i])) {
                subtracao.insert(this.conjunto[i]);
            }
        }
        return subtracao;
    }

    // para construir um conjunto novo que representa a intersecção do this com os
    // elementos do conjunto representado pelo objeto inter. O conjunto resultante
    // não pode conter elementos repetidos.
    public Conjunto intersect(Conjunto inter) {
        Conjunto intersecao = new Conjunto();
        for (int i = 0; i < currentPos; i++) {
            if (inter.contains(this.conjunto[i])) {
                intersecao.insert(this.conjunto[i]);
            }
        }
        return intersecao;
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
        System.out.println("Uniao:" + c1.combine(c2));
        System.out.println("Interseção:" + c1.intersect(c2));
        System.out.println("Diferença:" + c1.subtract(c2));
        c1.empty();
        System.out.println("c1:" + c1);
    }
}