package aula11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        HashMap<String, Integer> pares = new HashMap<>();

        try (Scanner input = new Scanner(new File("src/aula11/words.txt"))) {
            input.useDelimiter("\t\n.,:'‘’;?!-*{}=+&/()[]”“\"\'");

            String palavraAnterior = "";

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());

                String palavraAtual = input.nextLine();

                if (palavraAnterior != "") {

                    String par = palavraAnterior + " " + palavraAtual;

                    pares.put(par, null);
                }
                palavraAnterior = palavraAtual;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não existente!");
        }
    }
}