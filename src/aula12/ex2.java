package aula12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class ex2 {
    public static void main(String[] args) {
        String arquivo = "src/aula12/A_cidade_e_as_serras.txt";
        TreeMap<Character, TreeMap<String, Integer>> palavras = new TreeMap<>();

        try {
            Scanner scanner = new Scanner(new File(arquivo));

            while (scanner.hasNext()) {
                String palavra = scanner.next().toLowerCase();
                palavra = palavra.replaceAll("[^a-z]", "");

                if (palavra.length() < 3) {
                    continue;
                }

                if (!palavras.keySet().contains(palavra.charAt(0))) {
                    palavras.put(palavra.charAt(0), new TreeMap<>());
                    palavras.get(palavra.charAt(0)).put(palavra, 1);
                    continue;
                }

                if (palavras.get(palavra.charAt(0)).containsKey(palavra)) {
                    int ocorrencias = palavras.get(palavra.charAt(0)).get(palavra);
                    palavras.get(palavra.charAt(0)).put(palavra, ocorrencias + 1);
                    continue;
                }

                palavras.get(palavra.charAt(0)).put(palavra, 1);

            }
            scanner.close();

            String result = "";
            for (Character character : palavras.keySet()) {
                result += character + ": ";

                for (String word : palavras.get(character).keySet()) {
                    result += word + ", " + palavras.get(character).get(word) + "; ";
                }
                result += "\n";
            }
            System.out.println(result);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        }

    }
}
