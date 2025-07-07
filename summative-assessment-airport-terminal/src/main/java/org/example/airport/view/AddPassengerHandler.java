package org.example.airport.view;

import org.example.airport.data.FlightRepository;
import org.example.airport.domain.model.Passenger;

public class AddPassengerHandler implements MenuHandler {
    private View view;
    private FlightRepository repository;

    public AddPassengerHandler(View view, FlightRepository repository) {
        this.view = view;
        this.repository = repository;
    }


    @Override
    public void execute() {
        view.displayHeader("Add Passenger");
        
        String flightNumber = view.getFlightNumberFromUser();
        String travelerName = view.getTravelerNameFromUser();
        String travelerPassportNumber = view.getTravelerPassportNumberFromUser();

        repository.addReservation(flightNumber, new Passenger(travelerName, travelerPassportNumber));

    }
}
