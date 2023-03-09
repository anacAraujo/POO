package aula04;

import java.util.Scanner;

public class CarDemo {

    static Scanner sc = new Scanner(System.in);

    static int registerCars(Car[] cars) {
        // pede dados dos carros ao utilizador e acrescenta ao vetor
        // registo de carros termina quando o utilizador inserir uma linha vazia
        // devolve número de carros registados
        int numCarsUser = 0;
        String carroUser = "";
        do {
            System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
            carroUser = sc.nextLine();

            if (carroUser == "") {
                return numCarsUser;
            }

            String[] partesCarro = carroUser.split(" ");

            boolean isValid = validation(partesCarro);
            if (!isValid) {
                System.out.println("Dados mal formatados. Tente novamente.");
                continue;
            }

            String marca = partesCarro[0];
            String modelo = "";
            for (int i = 1; i < partesCarro.length - 2; i++) {
                modelo += partesCarro[i] + " ";
            }
            int ano = Integer.parseInt(partesCarro[partesCarro.length - 2]);
            int kms = Integer.parseInt(partesCarro[partesCarro.length - 1]);

            cars[numCarsUser] = new Car(marca, modelo, ano, kms);

            numCarsUser++;
        } while (carroUser != "" && numCarsUser < 10);

        return numCarsUser;
    }

    static boolean validation(String[] partesCarro) {
        if (partesCarro.length < 4) {
            return false;
        }
        if (!partesCarro[partesCarro.length - 2].matches("\\d{4}")) {
            return false;
        }
        if (!partesCarro[partesCarro.length - 1].matches("\\d+")) {
            return false;
        }
        return true;
    }

    static void registerTrips(Car[] cars, int numCars) {
        // pede dados das viagens ao utilizador e atualiza informação do carro
        // registo de viagens termina quando o utilizador inserir uma linha vazia

        String tripsUser = "";
        do {
            System.out.print("Registe uma viagem no formato \"carro:distância\": ");
            tripsUser = sc.nextLine();

            if (tripsUser == "") {
                break;
            }

            String[] trips = tripsUser.split(":");

            if (trips.length < 2 || !trips[0].matches("\\d") || !trips[1].matches("\\d+")) {
                System.out.println("Dados mal formatados. Tente novamente.");
                continue;
            }

            int carro = Integer.parseInt(trips[0]);
            int distanciaCrro = Integer.parseInt(trips[1]);

            if (carro >= numCars) {
                System.out.println("Carro inválido. Tente novamente.");
                continue;
            }
            cars[carro].drive(distanciaCrro);

        } while (tripsUser != "");

    }

    static void listCars(Car[] cars, int numCars) {
        // lista todos os carros registados
        // Exemplo de resultado
        // Carros registados:
        // Toyota Camry, 2010, kms: 234346
        // Renault Megane Sport Tourer, 2015, kms: 32536

        String listCars = "";

        System.out.println("\nCarros registados:");

        for (int i = 0; i < numCars; i++) {
            listCars += cars[i].toString();
        }

        System.out.println(listCars);
    }

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        int numCars = registerCars(cars);

        if (numCars > 0) {
            listCars(cars, numCars);
            registerTrips(cars, numCars);
            listCars(cars, numCars);
        }

        sc.close();

    }
}