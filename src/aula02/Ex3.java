package aula02;

import java.util.Scanner;

public class Ex3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Quantidade de água: ");
    float water = scanner.nextFloat();

    System.out.println("Temperatura inicial: ");
    float initialTemperature = scanner.nextFloat();

    System.out.println("Temperatura final: ");
    float finalTemperature = scanner.nextFloat();

    float energy = water * (finalTemperature - initialTemperature);

    System.out.println("Energia necessária: " + energy);

    scanner.close();
  }
}