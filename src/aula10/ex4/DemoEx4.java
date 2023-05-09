package aula10.ex4;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class DemoEx4 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileReader("src/aula10/ex4/words.txt"));

        ArrayList<String> wordsMoreThenTwo = new ArrayList<>();

        while (input.hasNext()) {
            String word = input.next();
            System.out.println(word);

            if (word.length() > 2) {
                wordsMoreThenTwo.add(word);
            }
        }

        System.out.println("\nPalavras com mais de 2 caracteres:");
        for (String word : wordsMoreThenTwo) {
            System.out.println(word);
        }

        System.out.println("\nPalavras que acabam em 's':");
        for (String word : wordsMoreThenTwo) {
            if (word.endsWith("s")) {
                System.out.println(word);
            }
        }

        System.out.println("\nRemover palavras com caracteres especiais:");
        Iterator<String> itr = wordsMoreThenTwo.iterator();
        while (itr.hasNext()) {
            String word = itr.next();
            if (!word.matches("[a-zA-Z]+")) {
                itr.remove();
            }
        }

        for (String word : wordsMoreThenTwo) {
            System.out.println(word);
        }

    }
}
