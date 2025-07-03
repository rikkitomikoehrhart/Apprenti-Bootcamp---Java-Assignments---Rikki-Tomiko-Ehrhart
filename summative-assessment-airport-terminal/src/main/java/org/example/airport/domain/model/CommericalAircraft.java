package org.example.airport.domain.model;

public class CommericalAircraft extends Aircraft {
    private String airlineName;

    public CommericalAircraft(String model, int capacity, double fuelCapacity, String airlineName) {
        super(model, capacity, fuelCapacity);

        this.airlineName = airlineName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @Override
    public String toString(){
        return String.format("Airline: %s%n", this.airlineName) + super.toString();
    }
}
