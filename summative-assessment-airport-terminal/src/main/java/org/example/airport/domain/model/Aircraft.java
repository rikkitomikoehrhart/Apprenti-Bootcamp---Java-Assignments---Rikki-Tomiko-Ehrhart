package org.example.airport.domain.model;

public class Aircraft {
    private String model;
    private int capacity;           // of passengers
    private double fuelCapacity;    // in liters

    public Aircraft(String model, int capacity, double fuelCapacity) {
        this.model = model;
        this.capacity = capacity;
        this.fuelCapacity = fuelCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public String toString() {
        return String.format("Model: %s%nPassenger Capacity: %f%nFuel Capacity (in liters): %f%n", this.model, this.capacity, this.fuelCapacity);
    }
}
