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
            if (partesCarro.length < 4) {
                continue;
            }

            // System.out.println(validation(partesCarro));
            // if (validation(partesCarro) == false) {
            // System.out.println("Dados mal formatados. Tente novamente.");
            // continue;
            // }
            String marca = partesCarro[0];
            String modelo = partesCarro[1];
            int ano = Integer.parseInt(partesCarro[2]);
            int kms = Integer.parseInt(partesCarro[3]);

            cars[numCarsUser] = new Car(marca, modelo, ano, kms);

            numCarsUser++;
        } while (carroUser != "");

        return numCarsUser;

    }

    // static boolean validation(String[] partesCarro) {
    // boolean estado = false;
    // if (partesCarro[0].matches("\\[a-zA-Z]")) {
    // estado = true;
    // System.out.println("1: " + estado);
    // if (partesCarro[1].matches("\\W+||\\W+")) {
    // System.out.println("2: " + estado);
    // if (partesCarro[2].matches("\\d{4}")) {
    // System.out.println("3: " + estado);
    // if (partesCarro[3].matches("\\d[^.,]")) {
    // estado = true;
    // System.out.println("4: " + estado);
    // }
    // }
    // }
    // }
    // return estado;
    // }

    static void registerTrips(Car[] cars, int numCars) {
        // pede dados das viagens ao utilizador e atualiza informação do carro
        // registo de viagens termina quando o utilizador inserir uma linha vazia

        String tripsUser = "";
        do {
            System.out.print("Registe uma viagem no formato \"carro:distância\": ");
            tripsUser = sc.nextLine();
            String[] trips = tripsUser.split(":");
            if (trips.length < 2) {
                continue;
            }
            int carro = Integer.parseInt(trips[0]);
            int distanciaCrro = Integer.parseInt(trips[1]);

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