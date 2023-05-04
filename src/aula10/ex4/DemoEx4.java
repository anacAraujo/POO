package aula10.ex4;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoEx4 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileReader("words.txt"));

        ArrayList<String> words = new ArrayList<>();

        while (input.hasNext()) {
            String word = input.next();
            System.out.println(word);

            if (word.length() > 2) {
                words.add(word);
            }
        }

        System.out.println("\nPalavras com mais de 2 caracteres:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
