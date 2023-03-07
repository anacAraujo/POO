package aula03;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int montante;
        float taxa;

        do {
            System.out.print("Montante investido: ");
            montante = scanner.nextInt();
        } while (montante < 0 || montante % 1000 != 0);

        do {
            System.out.print("Taxa de juro mensal: ");
            taxa = scanner.nextFloat();
        } while (taxa < 0 || taxa > 5);

        float valorAtual = montante;
        for (int i = 1; i <= 12; i++) {
            float juros = (taxa / 100) * montante;
            valorAtual = valorAtual + juros;
            System.out.println("Mes " + i + ": " + valorAtual);
        }

        scanner.close();
    }
}
