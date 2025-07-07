package org.example.airport.view;

import org.example.airport.data.FlightRepository;
import org.example.airport.domain.model.Flight;

import java.util.List;

public class ViewAllFlightsHandler implements MenuHandler {
    View view;
    FlightRepository repository;



    public ViewAllFlightsHandler(View view, FlightRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void execute() {
        view.displayHeader("View All Flights");

        List<Flight> flights = repository.getAllFlights();

        for (Flight flight : flights) {
            view.printFlightInformation(flight);
        }

    }
}
