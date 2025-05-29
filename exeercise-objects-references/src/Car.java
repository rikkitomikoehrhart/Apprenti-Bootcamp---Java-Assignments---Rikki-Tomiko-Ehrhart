public class Car {
    String brand;
    String model;
    int year;

    public Car(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.printf("Car: %s %s (%d)%n", brand, model, year);
    }


}
