package aula03;

import java.util.Random;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Random random = new Random();
        int userNum;
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        String resposta = "S";

        while (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
            int randomNum = random.nextInt(100) + 1;
            do {
                System.out.println("Insira um número: ");
                userNum = scanner.nextInt();
                contador++;
                if (userNum > randomNum) {
                    System.out.println("Demasiado alto!");
                }
                if (userNum < randomNum) {
                    System.out.println("Demasiado baixo!");
                }
            } while (userNum != randomNum);

            System.out.println("Acertou! Tentativas: " + contador);

            System.out.println("Pretende continuar? Prima (S)im");
            resposta = scanner.next();
        }

        scanner.close();
    }
}
