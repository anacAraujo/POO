package aula12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ex1 {
    public static void main(String[] args) {

        String arquivo = "src/aula12/words.txt";
        try {
            Set<String> palavras = new HashSet<>();
            int totalPalavras = 0;

            Scanner scanner = new Scanner(new File(arquivo));
            while (scanner.hasNext()) {
                String palavra = scanner.next();
                palavras.add(palavra);
                totalPalavras++;
            }
            scanner.close();

            int numPalavrasDiferentes = palavras.size();

            System.out.println("Número Total de Palavras: " + totalPalavras);
            System.out.println("Número de Diferentes Palavras: " + numPalavrasDiferentes);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        }

    }
}
