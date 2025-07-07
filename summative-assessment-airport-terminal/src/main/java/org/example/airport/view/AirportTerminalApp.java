package org.example.airport.view;

import org.example.airport.data.FlightSampleDataRepository;
import org.example.airport.domain.model.MenuOption;

public class AirportTerminalApp {
    private View view = new View();
    private FlightSampleDataRepository repository = new FlightSampleDataRepository();

    private ViewAllFlightsHandler viewAllFlightsHandler = new ViewAllFlightsHandler(view, repository);

    public void main(String[] args) {


        while (true) {
            MenuOption choice = view.chooseMainMenuOption();

            switch(choice) {
                case VIEW_ALL_FLIGHTS:
                    viewAllFlightsHandler.execute();
                    return;
                case ADD_PASSENGER:
                    break;
                case VIEW_PASSENGERS:
                    break;
                case SAVE:
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }
}
