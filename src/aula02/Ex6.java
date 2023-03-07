package aula02;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduza um tempo tem segundos: ");
        int totalSecs = scanner.nextInt();

        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;

        System.out.print(hours + ":" + minutes + ":" + seconds);

        scanner.close();
    }
}
