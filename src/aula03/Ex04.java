package aula03;

import java.util.Random;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos alunos tem a turma?");
        int numTotalAlunos = scanner.nextInt();

        float[][] notasTurma = new float[numTotalAlunos][2];

        Random random = new Random();

        for (int i = 0; i < numTotalAlunos; i++) {
            Float notaT = random.nextFloat(20);
            notasTurma[i][0] = notaT;
            Float notaP = random.nextFloat(20);
            notasTurma[i][1] = notaP;
        }

        imprimirResultado(notasTurma);

        scanner.close();
    }

    static int notaFinal(float notaT, float notaP) {
        int notaF;
        if (notaP < 7.0 || notaT < 7.0) {
            notaF = 66;
        } else {
            Double calculo = 0.4 * notaT + 0.6 * notaP;
            notaF = (int) Math.round(calculo);
        }
        return notaF;
    }

    static void imprimirResultado(float[][] notas) {
        System.out.println("NotaT NotaP Pauta");

        for (int i = 0; i < notas.length; i++) {
            int pauta = notaFinal(notas[i][0], notas[i][1]);

            System.out.printf("%5.1f %5.1f %5d\n", notas[i][0], notas[i][1], pauta);
        }

    }
}
