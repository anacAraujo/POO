package aula02;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numUser;

        do {
            System.out.print("Introduza um número: ");
            numUser = scanner.nextInt();
        } while (numUser < 0);

        for (int i = numUser; i > 0; i--) {
            System.out.print(i + ",");

            if (i % 10 == 0) {
                System.out.println();
            }
        }
        scanner.close();
    }
}
