package aula11.ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

                String inicioNome = voo.getSiglaCompanhia();
                for (String sigla : companhias.keySet()) {
                    if (sigla.equalsIgnoreCase(inicioNome)) {
                        result += String.format("%2s ", companhias.get(sigla));
                    }
                }
                result += String.format("%2s %2s %2s", voo.getOrigem(), voo.getAtraso(), voo.getPrevisao());
                result += "\n";
            }
            System.out.println(result);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        }

        // Calcular a média dos atrasos por companhia
        Map<String, List<Integer>> atrasosPorCompanhia = new HashMap<>();
        for (Voo voo : voos) {
            String siglaCompanhia = voo.getSiglaCompanhia();
            int atraso = Integer.parseInt(voo.getAtraso());

            if (!atrasosPorCompanhia.containsKey(siglaCompanhia)) {
                atrasosPorCompanhia.put(siglaCompanhia, new ArrayList<>());
            }
            atrasosPorCompanhia.get(siglaCompanhia).add(atraso);
        }

        Map<String, Double> atrasoMedioPorCompanhia = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : atrasosPorCompanhia.entrySet()) {
            String siglaCompanhia = entry.getKey();
            List<Integer> atrasos = entry.getValue();
            double atrasoMedio = Voo.calcularAtrasoMedio(atrasos);
            atrasoMedioPorCompanhia.put(siglaCompanhia, atrasoMedio);
        }

        // Ordenar atraso médio em ordem crescente
        List<Map.Entry<String, Double>> atrasoMedioOrdenado = new ArrayList<>(atrasoMedioPorCompanhia.entrySet());
        atrasoMedioOrdenado.sort(Comparator.comparingDouble(Map.Entry::getValue));

        // Imprimir tabela (Companhia, Atraso médio)
        System.out.println("Companhia\tAtraso médio");
        for (Map.Entry<String, Double> entry : atrasoMedioOrdenado) {
            String siglaCompanhia = entry.getKey();
            String companhia = companhias.get(siglaCompanhia);
            double atrasoMedio = entry.getValue();
            System.out.printf("%2s %2f", companhia, atrasoMedio);
        }

        // voos por cada origiem
        HashMap<String, Integer> origens = new HashMap<>();
        for (Voo voo : voos) {
            String origem = voo.getOrigem();

            if (!origens.containsKey(origem)) {
                origens.put(origem, 1);
            }
            int numAtual = origens.get(origem);
            origens.replace(origem, numAtual++);
        }

        try (FileWriter writer = new FileWriter("src/aula11/ex4/cidades.txt")) {
            writer.write("Origem\tVoos\n");
            for (String origem : origens.keySet()) {
                writer.write(origem + "\t" + origens.get(origem) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo cidades.txt: " + e.getMessage());
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
