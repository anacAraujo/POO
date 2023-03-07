package aula03;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {

        int[] valores = leituraValores();

        int mes = valores[0];

        int ano = valores[1];

        int diaInicio = valores[2];

        int diasMes = diasMes(mes, ano);

        imprimirCalendario(mes, ano, diaInicio, diasMes);
    }

    static int[] leituraValores() {
        Scanner scanner = new Scanner(System.in);
        int inicio_mes = 0;
        String data;
        int mes = 0;
        int ano = 0;

        do {
            System.out.print("Introduza uma data: ");
            data = scanner.next();

            String[] parts = data.split("/");
            String pmes = parts[0];
            mes = Integer.parseInt(pmes);

            String pano = parts[1];
            ano = Integer.parseInt(pano);

        } while (mes < 1 || mes > 12 || ano < 999);

        do {
            System.out.print(
                    "1 = Segunda, 2 = Terça, 3 = Quarta, 4 = Quinta, 5 = Sexta, 6 = Sábado, 7 = Domingo\nEm que dia da semana começa este mês? ");
            inicio_mes = scanner.nextInt();
        } while (inicio_mes < 1 || inicio_mes > 7);

        int[] valores = { mes, ano, inicio_mes };

        scanner.close();

        return valores;
    }

    static int diasMes(int mes, int ano) {
        int qntDiasMes;
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            qntDiasMes = 30;
        } else if (mes == 2) {
            qntDiasMes = (ano % 4 == 0) ? 29 : 28;
        } else {
            qntDiasMes = 31;
        }
        return qntDiasMes;
    }

    static void imprimirCalendario(int mes, int ano, int inicioMes, int diasMes) {
        int diaSemanaAtual = inicioMes;
        int diaAtual = 1;

        String[] meses = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String nomeMes = meses[mes];

        System.out.printf("%12s %6d\n", nomeMes, ano);
        System.out.print("  Su Mo Tu We Th Fr Sa\n");

        for (int i = 1; i < diaSemanaAtual; i++) {
            System.out.print("   ");
        }

        for (int i = 1; i < diasMes; i++) {
            System.out.printf("%3d", diaAtual);
            diaAtual++;
            diaSemanaAtual++;
            if (diaSemanaAtual > 7) {
                System.out.print("\n");
                diaSemanaAtual = 1;
            }
        }

    }
}
