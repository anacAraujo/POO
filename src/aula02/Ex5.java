package aula02;

import java.util.Scanner;

public class Ex5 {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      float v1, d1, v2, d2;

      do {
         System.out.println("Velocidade primeiro trajeto: ");
         v1 = scanner.nextFloat();
      } while (v1 <= 0);

      do {
         System.out.println("Distância primeiro trajeto:");
         d1 = scanner.nextFloat();
      } while (d1 <= 0);

      do {
         System.out.println("Velocidade segundo trajeto: ");
         v2 = scanner.nextFloat();
      } while (v2 <= 0);

      do {
         System.out.println("Distância segundo trajeto:");
         d2 = scanner.nextFloat();
      } while (d2 <= 0);

      float velocidadeFinal = (d1 + d2) / ((d1 / v1) + (d2 / v2));
      System.out.println("velocidade média final: " + velocidadeFinal);

      scanner.close();
   }
}
