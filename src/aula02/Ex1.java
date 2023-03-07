package aula02;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Distância em quilómetros: ");

    float userNumKm = scanner.nextFloat();

    float convertNum = 1.609f;

    float userNumMilhas = userNumKm / convertNum;

    System.out.println("Distância em milhas: " + userNumMilhas);

    scanner.close();
    }
}
