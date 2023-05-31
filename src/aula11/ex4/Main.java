package aula11.ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Voo> voos = new ArrayList<>();
        HashMap<String, String> companhias = new HashMap<>();
        String result = String.format("%2s %2s %2s %2s %2s %2s\n", "Hora", "Voo", "Companhia", "Origem", "Atraso",
                "Obs");

        try {
            Scanner scVoos = new Scanner(new File("src/aula11/ex4/voos.txt"));
            Scanner scCompanhias = new Scanner(new File("src/aula11/ex4/companhias.txt"));

            scVoos.nextLine();
            while (scVoos.hasNextLine()) {
                String line = scVoos.nextLine();
                String[] data = line.split("\\t");
                System.out.println("1: " + data[0] + " 2: " + data[1]);
                String atraso = "";
                if (data.length > 3) {
                    atraso = data[3];
                }
                voos.add(new Voo(data[0], data[1], data[2], atraso));
            }
            scVoos.close();

            scCompanhias.nextLine();
            while (scCompanhias.hasNextLine()) {
                String line = scCompanhias.nextLine();
                String[] data = line.split("\\t");

                companhias.put(data[0], data[1]);
            }

            for (Voo voo : voos) {
                result += String.format("%2s %2s ", voo.getHora(), voo.getNome());

                String inicioNome = voo.getNome().length() < 2 ? voo.getNome() : voo.getNome().substring(0, 2);
                for (String sigla : companhias.keySet()) {
                    if (sigla.equalsIgnoreCase(inicioNome)) {
                        result += String.format("%2s ", companhias.get(sigla));
                    }
                }
                result += String.format("%2s %2s ", voo.getOrigem(), voo.getAtraso());
                result += "\n";
            }
            System.out.println(result);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("src/aula11/ex4/Infopublico.txt");
            writer.write(result);
            writer.close();
            System.out.println("Tabela salva com sucesso no arquivo Infopublico.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a tabela no arquivo Infopublico.txt");
            e.printStackTrace();
        }
    }
}
