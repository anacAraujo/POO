package aula04;

public class Car {

    private String make;
    private String model;
    private int year;
    private int kms;

    public Car(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public String toString() {
        return String.format("%2s %2s, %2d, km: %2d\n",
                this.make,
                this.model,
                this.year,
                this.kms);
    }

    public void drive(int distance) {
        // Acumular distancia percorrida
        this.kms += distance;
    }
}
