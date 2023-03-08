package aula04;

import java.util.Scanner;

public class Figuras {
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

        for (int i = 0; i < 3; i++) {
            System.out.println(
                    "1 - Adicionar 5 circulos;\n2 - Adicionar 5 triangulos;\n3 - Adicionar 5 retangulos;");
            int inputUser = sc.nextInt();
            switch (inputUser) {
                case 1:
                    for (int c = 0; c < circulos.length; c++) {
                        System.out.print("Raio: ");
                        int raioUser = sc.nextInt();
                        circulos[c] = new Circulo(raioUser);
                    }
                    break;
                case 2:
                    for (int t = 0; t < triangulos.length; t++) {
                        System.out.print("Lado 1: ");
                        int lado1User = sc.nextInt();
                        System.out.print("Lado 2: ");
                        int lado2User = sc.nextInt();
                        System.out.print("Lado 3: ");
                        int lado3User = sc.nextInt();
                        triangulos[t] = new Triangulo(lado1User, lado2User, lado3User);
                    }
                    break;
                case 3:
                    for (int r = 0; r < retangulos.length; r++) {
                        System.out.print("Comprmento: ");
                        int compUser = sc.nextInt();
                        System.out.print("Largura: ");
                        int larguraUser = sc.nextInt();
                        retangulos[r] = new Retangulo(compUser, larguraUser);
                    }
                    break;
                default:
                    System.out.println("Insira um numero entre 1 e 3.");
                    break;
            }
        }

        for (int i = 0; i < 5; i++) {
            int nextFigura = i + 1;
            if (nextFigura == 6) {
                nextFigura = 1;
            }

            System.out.println(circulos[i]);
            System.out.println(circulos[i].equals(circulos[nextFigura]));

            System.out.println(triangulos[i]);
            System.out.println(triangulos[i].equals(triangulos[nextFigura]));

            System.out.println(retangulos[i]);
            System.out.println(retangulos[i].equals(retangulos[nextFigura]));
        }

        sc.close();
    }
}