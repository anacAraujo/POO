package aula02;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Temperatura em graus Celsius: ");

        float tempC = scanner.nextFloat();

        float tempF = 1.8f * tempC + 32f;

        System.out.println("Temperatura em graus Fahenheit: " + tempF);

        scanner.close();
    }
}
