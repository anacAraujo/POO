package aula03;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userNum;
        do {
            System.out.print("Insira um número: ");
            userNum = scanner.nextInt();
        } while (userNum <= 0);

        int soma = 0;

        for (int i = 1; i <= userNum; i++) {
            if (numPrimos(i)) {
                soma = soma + i;
            }
        }

        System.out.println(soma);

        scanner.close();
    }

    static boolean numPrimos(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
