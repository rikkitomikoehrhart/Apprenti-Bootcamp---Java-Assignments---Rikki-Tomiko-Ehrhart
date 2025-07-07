package org.example.airport.view;

import org.example.airport.data.FlightRepository;
import org.example.airport.domain.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewPassengersHandler implements MenuHandler {
    private View view;
    private FlightRepository repository;

    public ViewPassengersHandler(View view, FlightRepository repository) {
        this.view = view;
        this.repository = repository;
    }


    @Override
    public void execute() {
        view.displayHeader("View All Passengers");

        HashMap<String, ArrayList<Passenger>> repo = repository.getFlights();

        for (String flightNumber : repo.keySet()) {
            for (Passenger passenger : repo.get(flightNumber)) {
                view.printPassengerInformation(flightNumber, passenger);
            }
        }

    }
}
