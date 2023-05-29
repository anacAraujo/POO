package aula12.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
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
            TreeMap<Double, Movie> moviesScore = new TreeMap<>(Comparator.reverseOrder());
            movies.forEach((movie, details) -> moviesScore.put(Double.parseDouble(details.getScore()), details));
            moviesScore.forEach((score, movie) -> System.out.println(String.format("%s", movie)));

            // ordem crescente de tempo de duracao
            System.out.println("\n\nordem crescente de tempo de duracao\n");
            TreeMap<Integer, Movie> moviesTime = new TreeMap<>();
            movies.forEach((movie, details) -> moviesTime.put(Integer.parseInt(details.getTime()), details));
            moviesTime.forEach((time, movie) -> System.out.println(String.format("%s", movie)));

            // Gêneros distintos e contagem
            System.out.println("\n\nGêneros distintos e contagem\n");
            TreeMap<String, Integer> genresCount = new TreeMap<>();
            movies.forEach((movie, details) -> genresCount.merge(details.getGenre(), 1, Integer::sum));
            genresCount.forEach((genre, count) -> System.out.println(String.format("%s: %d", genre, count)));

            // Filmes com score > 60 do gênero indicado pelo usuário
            Scanner sc = new Scanner(System.in);
            System.out.print("\n\nIndica um genero: ");
            String genreInput = sc.nextLine();
            System.out.println("\n\nFilmes com score > 60 do gênero " + genreInput + "\n");
            PrintWriter writer = new PrintWriter("myselection.txt");
            moviesScore.forEach((score, movie) -> {
                if (Double.parseDouble(movie.getScore()) > 60 && movie.getGenre().equalsIgnoreCase(genreInput)) {
                    System.out.println(movie);
                    writer.println(movie);
                }
            });
            sc.close();
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        }

    }
}
