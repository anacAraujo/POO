package aula11.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> pares = new HashMap<>();
        Scanner input = null;
        try {
            input = new Scanner(new File("src/aula11/ex1/words.txt"));

            input.useDelimiter(" |\\.");

            String palavraAnterior = "";

            while (input.hasNext()) {
                String palavraAtual = input.next();

                if (palavraAtual.length() < 3) {
                    continue;
                }

                System.out.println(palavraAtual);

                if (palavraAnterior != "") {
                    if (!pares.containsKey(palavraAnterior)) {
                        pares.put(palavraAnterior, new HashMap<>());
                    }

                    Integer ocorrencias = pares.get(palavraAnterior).get(palavraAtual);

                    if (ocorrencias == null) {
                        ocorrencias = 0;
                    }

                    pares.get(palavraAnterior).put(palavraAtual, ocorrencias + 1);
                }
                palavraAnterior = palavraAtual;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não existente!");
        } finally {
            if (input != null)
                input.close();
        }

        String result = "";
        for (String palavra : pares.keySet()) {
            result += palavra + "={";

            for (String outraPalavra : pares.get(palavra).keySet()) {

                result += String.format("%s=%d ", outraPalavra, pares.get(palavra).get(outraPalavra));

            }
            result += "}\n";
        }
        System.out.println(result);

    }
}