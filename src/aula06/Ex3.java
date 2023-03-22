package aula06;

class Conjunto {
    int[] conjunto;

    public Conjunto() {

    }

    // – para inserir um elemento novo no conjunto. Caso este elemento já exista,
    // a função não faz nada. Inicialmente não se sabe quantos elementos vamos
    // inserir.
    public void insert(int n) {

    }

    // – para indicar se um dado elemento está no conjunto.
    public boolean contains(int n) {
        return false;
    }

    // - para remover um elemento do conjunto. Caso este elemento não se encontre no
    // conjunto, a função não faz nada.
    public void remove(int n) {

    }

    // para apagar todos os elementos do conjunto
    public void empty() {

    }

    public String toString() {
        return "";
    }

    // - para calcular o número de elementos no conjunto.
    public int size() {
        int a = 1;
        return a;
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