package aula10.ex4;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoEx4 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileReader("words.txt"));

        ArrayList<String> wordsMoreThenTwo = new ArrayList<>();
        ArrayList<String> wordsEndS = new ArrayList<>();

        while (input.hasNext()) {
            String word = input.next();
            System.out.println(word);

            if (word.length() > 2 && word.matches("[a-zA-Z]+")) {
                wordsMoreThenTwo.add(word);
            }

            if (word.endsWith("s") && word.matches("[a-zA-Z]+")) {
                wordsEndS.add(word);
            }
        }

        System.out.println("\nPalavras com mais de 2 caracteres:");
        for (String word : wordsMoreThenTwo) {
            System.out.println(word);
        }

        System.out.println("\nPalavras que acabam em 's':");
        for (String word : wordsEndS) {
            System.out.println(word);
        }
    }
}
