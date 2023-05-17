package aula12.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class DemoMovies {
    public static void main(String[] args) {

        String arquivo = "src/aula12/ex3/movies.txt";
        try {
            TreeMap<String, Movie> movies = new TreeMap<>();

            Scanner scanner = new Scanner(new File(arquivo));
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\t");

                movies.put(data[0], new Movie(data[0], data[1], data[2], data[3], data[4]));
            }
            scanner.close();

            for (String movie : movies.keySet()) {
                System.out.println(
                        String.format("%s",
                                movies.get(movie)));
            }

            // ordem decrescente de score
            System.out.println("\n\nordem decrescente de score\n");
            TreeMap<Integer, Movie> moviesScore = new TreeMap<>();
            for (String movie : movies.keySet()) {
                int key = Integer.parseInt("-" + movies.get(movie).getScore());
                moviesScore.put(key, movies.get(movie));
            }
            for (int score : moviesScore.keySet()) {
                System.out.println(
                        String.format("%s",
                                moviesScore.get(score)));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        }

    }
}
