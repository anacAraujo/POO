package aula07;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        /*
         * Circulo circulo1 = new Circulo(30);
         * Circulo circulo2 = new Circulo(3);
         * System.out.println(circulo1.getRaio());
         * circulo1.setRaio(50);
         * System.out.println(circulo1.getRaio());
         * System.out.println(circulo1.equals(circulo2));
         * 
         * Triangulo t1 = new Triangulo(3, 4, 3);
         * Triangulo t2 = new Triangulo(4, 3, 3);
         * System.out.println(t1);
         * System.out.println(t2);
         * System.out.println(t1.equals(t2));
         * 
         * Retangulo r1 = new Retangulo(2, 5);
         * Retangulo r2 = new Retangulo(2, 5);
         * System.out.println(r1);
         * System.out.println(r2);
         * System.out.println(r1.equals(r2));
         */
        Circulo[] circulos = new Circulo[5];
        Triangulo[] triangulos = new Triangulo[5];
        Retangulo[] retangulos = new Retangulo[5];

        Scanner sc = new Scanner(System.in);

        int inputUser = 0;
        int numCirculos = 0;
        int numTriangulos = 0;
        int numRetangulos = 0;

        do {
            System.out.println(
                    "1 - Adicionar circulo;\n2 - Adicionar triangulo;\n3 - Adicionar retangulo;\n4 - Imprimir\n5 - SAIR");
            inputUser = sc.nextInt();
            switch (inputUser) {
                case 1:
                    System.out.print("Raio: ");
                    int raioUser = sc.nextInt();
                    System.out.print("Cor: ");
                    String corC = sc.next();
                    circulos[numCirculos] = new Circulo(raioUser, corC);
                    numCirculos++;
                    break;
                case 2:
                    System.out.print("Lado 1: ");
                    int lado1User = sc.nextInt();
                    System.out.print("Lado 2: ");
                    int lado2User = sc.nextInt();
                    System.out.print("Lado 3: ");
                    int lado3User = sc.nextInt();
                    System.out.print("Cor: ");
                    String corT = sc.next();
                    triangulos[numTriangulos] = new Triangulo(lado1User, lado2User, lado3User, corT);
                    numTriangulos++;
                    break;
                case 3:
                    System.out.print("Comprmento: ");
                    int compUser = sc.nextInt();
                    System.out.print("Largura: ");
                    int larguraUser = sc.nextInt();
                    System.out.print("Cor: ");
                    String corR = sc.next();
                    retangulos[numRetangulos] = new Retangulo(compUser, larguraUser, corR);
                    numRetangulos++;
                    break;
                case 4:
                    for (int i = 0; i < numCirculos; i++) {
                        int nextFigura = i + 1;
                        if (nextFigura == numCirculos) {
                            nextFigura = 0;
                        }
                        System.out.println(circulos[i]);
                        if (nextFigura < numCirculos && nextFigura != i) {
                            System.out.println(circulos[i] + " é igual ao " + circulos[nextFigura] + " ? "
                                    + circulos[i].equals(circulos[nextFigura]));
                        }
                    }

                    for (int i = 0; i < numTriangulos; i++) {
                        int nextFigura = i + 1;
                        if (nextFigura == numTriangulos) {
                            nextFigura = 0;
                        }
                        System.out.println(triangulos[i]);
                        if (nextFigura < numTriangulos && nextFigura != i) {
                            System.out.println(triangulos[i] + " é igual ao " + triangulos[nextFigura] + " ? "
                                    + triangulos[i].equals(triangulos[nextFigura]));
                        }
                    }

                    for (int i = 0; i < numRetangulos; i++) {
                        int nextFigura = i + 1;
                        if (nextFigura == numRetangulos) {
                            nextFigura = 0;
                        }
                        System.out.println(retangulos[i]);
                        if (nextFigura < numRetangulos && nextFigura != i) {
                            System.out.println(retangulos[i] + " é igual ao " + retangulos[nextFigura] + " ? "
                                    + retangulos[i].equals(retangulos[nextFigura]));
                        }
                    }
                    break;
                default:
                    System.out.println("Insira um numero entre 1 e 5.");
                    break;
            }
        } while (inputUser != 5);

        sc.close();
    }
}