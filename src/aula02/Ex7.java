package aula02;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduza as coordenas do ponto p1\nx: ");
        double x1 = scanner.nextDouble();

        System.out.print("Introduza as coordenas do ponto p1\ny: ");
        double y1 = scanner.nextDouble();

        System.out.print("Introduza as coordenas do ponto p2\nx: ");
        double x2 = scanner.nextDouble();

        System.out.print("Introduza as coordenas do ponto p2\ny: ");
        double y2 = scanner.nextDouble();

        double distancia = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        System.out.print("Distância: " + distancia);

        scanner.close();
    }
}
