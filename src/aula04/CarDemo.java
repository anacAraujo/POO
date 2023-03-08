package aula04;

import java.util.Scanner;

// Originalmente a class CarA tinha a designação Car que foi mudada por fazer interferência com a class Car do ficheiro SimpleCarDemo
class CarA {
    public String make;
    public String model;
    public int year;
    public int kms;

    public CarA(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public void drive(int distance) {
        // TODO: acumular distância percorrida
        System.out.println();
    }

}

public class CarDemo {

    static Scanner sc = new Scanner(System.in);

    static int registerCars(CarA[] cars) {
        // TODO: pede dados dos carros ao utilizador e acrescenta ao vetor
        // registo de carros termina quando o utilizador inserir uma linha vazia
        // devolve número de carros registados
        int numCarsUser = 0;
        String carroUser = "a";
        do {
            System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
            carroUser = sc.next();
            String[] partesCarro = carroUser.split(" ");
            String marca = partesCarro[0];
            String modelo = partesCarro[1];
            String ano = partesCarro[2];
            String kms = partesCarro[3];
            numCarsUser++;
        } while (carroUser != "");

        return numCarsUser;

    }

    static void registerTrips(CarA[] cars, int numCars) {
        // TODO: pede dados das viagens ao utilizador e atualiza informação do carro
        // registo de viagens termina quando o utilizador inserir uma linha vazia
        System.out.print("Registe uma viagem no formato \"carro:distância\": ");
    }

    static void listCars(CarA[] cars) {
        System.out.println("\nCarros registados: ");
        // TODO: lista todos os carros registados
        // Exemplo de resultado
        // Carros registados:
        // Toyota Camry, 2010, kms: 234346
        // Renault Megane Sport Tourer, 2015, kms: 32536

        System.out.println("\n");
    }

    public static void main(String[] args) {

        CarA[] cars = new CarA[10];

        int numCars = registerCars(cars);

        if (numCars > 0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}