package aula02;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double valorA;
        double valorB;

        do {
            System.out.print("Valor cateto A: ");
            valorA = scanner.nextFloat();
        } while (valorA < 0);

        do {
            System.out.print("Valor cateto B: ");
            valorB = scanner.nextFloat();
        } while (valorB < 0);

        double hipotenusa = Math.sqrt(Math.pow(valorA, 2) + Math.pow(valorB, 2));
        System.out.println("Hipotenusa: " + hipotenusa);

        double angulo = Math.toDegrees(Math.atan(valorA / valorB));

        System.out.println("Angulo: " + angulo + "º");
        scanner.close();
    }
}
