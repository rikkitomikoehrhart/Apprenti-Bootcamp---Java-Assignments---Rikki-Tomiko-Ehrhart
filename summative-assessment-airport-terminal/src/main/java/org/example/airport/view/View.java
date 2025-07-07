package org.example.airport.view;


import org.example.airport.domain.model.Flight;
import org.example.airport.domain.model.MenuOption;
import org.example.airport.domain.model.Passenger;

public class View {
    UIUtils ui = new UIUtils();
    private final String DISPLAY_FLIGHT_FORMAT = "%-7s | %-15s | $%-10.02f | %s : %s ";
    private final String DISPLAY_PASSENGER_FORMAT = "%-7s |   %s";




    public MenuOption chooseMainMenuOption() {
        String[] menu = MenuOption.getMenuForDisplay();
        displayHeader("Main Menu");

        for (String menuItem: menu) {
            ui.println(menuItem);
        }

        return MenuOption.getMenuOptionFromValue(ui.readInt("Choose [0-5]: "));
    }


    public void printFlightInformation(Flight flight) {
        ui.printf(DISPLAY_FLIGHT_FORMAT, flight.getFlightNumber(), flight.getDepartureDate(), flight.getTicketPrice(), flight.getAircraft().getClass().getSimpleName(), flight.getAircraft().getModel());
    }

    public void printPassengerInformation(String flightNumber, Passenger passenger) {
        ui.printf(DISPLAY_PASSENGER_FORMAT, flightNumber, passenger.getName());
    }

    public String getFlightNumberFromUser() {
        return ui.readString("Please enter the Flight Number: ");
    }

    public String getTravelerNameFromUser() {
        return ui.readString("Please enter the Name of the Traveler: ");
    }

    public String getTravelerPassportNumberFromUser() {
        return ui.readString("Please enter the Traveler's Passport Number: ");
    }


    public void displayHeader(String header) {
        int length = header.length();
        ui.print("");
        ui.println(header);
        ui.println("=".repeat(length));
    }
}
