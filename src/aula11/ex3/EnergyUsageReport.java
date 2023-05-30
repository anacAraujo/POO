package aula11.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EnergyUsageReport {
    private static int id = 0;
    HashMap<Integer, Customer> clients;

    public EnergyUsageReport() {
        clients = new HashMap<>();
    }

    // lê o ficheiro com os dados dos clientes e guarda os valores numa Java
    // Collection;
    public void load(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split("\\|");
            List<Double> nDoubles = new ArrayList<>();
            for (String num : data) {
                nDoubles.add(Double.parseDouble(num));
            }

            clients.put(id, new Customer(id, nDoubles));
            id++;
        }
        scanner.close();
    }

    // adiciona/remove um cliente;
    public boolean addCustomer(Customer customer) {
        if (clients.containsKey(customer.getCustomerId())) {
            return false;
        }
        clients.put(customer.getCustomerId(), customer);
        return true;
    }

    public boolean removeCustomer(int id) {
        if (!clients.containsKey(id)) {
            return false;
        }
        clients.remove(id);
        return true;
    }

    // providencia os dados de um determinado cliente;
    public Customer getCustomer(int id) {
        if (!clients.containsKey(id)) {
            return null;
        }
        return clients.get(id);
    }

    // Calcula o uso total de energia de um cliente;
    public double calculateTotalUsage(int id) {
        if (!clients.containsKey(id)) {
            return 0;
        }
        Customer customer = clients.get(id);
        double soma = 0;
        for (Double number : customer.getMeterReadings()) {
            soma += number;
        }
        double result = soma / customer.getMeterReadings().size();
        return result;
    }

    // Gera o relatório onde é listado em cada linha o ID do cliente e a energia
    // consumida.
    public void generateReport(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        for (Customer customer : clients.values()) {
            StringBuilder lineBuilder = new StringBuilder();
            lineBuilder.append(customer.getCustomerId()).append(" | ");
            for (Double num : customer.getMeterReadings()) {
                lineBuilder.append(num).append(" | ");
            }
            String line = lineBuilder.toString().trim();
            writer.write(line + "\n");
        }
        writer.close();
    }
}
