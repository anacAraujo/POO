package aula02;

import java.util.Scanner;

public class Ex4 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Indique o montante investido: ");
    float montante = scanner.nextFloat();

    System.out.println("Idique a taxa de juro mensal: ");
    float taxa = scanner.nextFloat();

    float valorAtual = montante;

    for (int i = 0; i < 3; i++) {
      float juros = (taxa / 100f) * valorAtual;
      valorAtual = valorAtual + juros;
    }

    System.out.println("Valor total ao final de 3 meses: " + valorAtual);

    scanner.close();
  }
}
