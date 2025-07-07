package org.example.airport.view;

import org.example.airport.data.FlightSampleDataRepository;
import org.example.airport.domain.model.MenuOption;

public class AirportTerminalApp {


    public static void main(String[] args) {
        View view = new View();
        FlightSampleDataRepository repository = new FlightSampleDataRepository();

        ViewAllFlightsHandler viewAllFlights = new ViewAllFlightsHandler(view, repository);
        AddPassengerHandler addPassenger = new AddPassengerHandler(view, repository);
        ViewPassengersHandler viewPassengers = new ViewPassengersHandler(view, repository);

        while (true) {
            MenuOption choice = view.chooseMainMenuOption();

            switch(choice) {
                case VIEW_ALL_FLIGHTS:
                    viewAllFlights.execute();
                    continue;
                case ADD_PASSENGER:
                    addPassenger.execute();
                    continue;
                case VIEW_PASSENGERS:
                    viewPassengers.execute();
                    continue;
                case SAVE:
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }
}
