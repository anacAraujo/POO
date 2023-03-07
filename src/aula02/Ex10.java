package aula02;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numInicial;
        double numatual;
        double maior = 0;
        double menor = Integer.MAX_VALUE;
        double quantidadeNumUser = 1;

        System.out.println("Introduza um número: ");
        numInicial = scanner.nextDouble();

        double soma = numInicial;

        do {
            System.out.println("Introduza um número: ");
            numatual = scanner.nextDouble();
            quantidadeNumUser++;

            if (numatual > maior) {
                maior = numatual;
            }

            if (numatual < menor) {
                menor = numatual;
            }

            soma += numatual;

        } while (numatual != numInicial);

        double media = soma / quantidadeNumUser;

        System.out.print("Valor máximo: " + maior + "\nValor mínimo: " + menor + "\nMédia: " + media
                + "\nTotal de numeros lidos: " + quantidadeNumUser);

        scanner.close();
    }
}
