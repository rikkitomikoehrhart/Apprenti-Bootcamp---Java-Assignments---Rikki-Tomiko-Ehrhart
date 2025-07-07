package org.example.airport.data;

import com.opencsv.CSVWriter;
import org.example.airport.domain.model.Flight;
import org.example.airport.domain.model.Passenger;
import org.example.airport.domain.reservation.ReservationSystem;

import java.io.FileWriter;
import java.util.List;

public class CSVUtil {
    ReservationSystem reservationSystem;
    private final String PATH = "reservations.csv";


    public CSVUtil(ReservationSystem reservationSystem) {
        this.reservationSystem = reservationSystem;
    }

    public void saveReservationsToCSV() {
        String[] header = {"flightNumber", "departureDate", "ticketPrice", "passengerName", "passportNumber", "aircraftModel", "aircraftType"};

        try (CSVWriter writer = new CSVWriter(new FileWriter(PATH))) {
            writer.writeNext(header);

            List<String> flightNumbers = reservationSystem.getFlightNumbers();

            for (String flightNumber : flightNumbers) {
                Flight flight = reservationSystem.getFlight(flightNumber);
                List<Passenger> passengers = reservationSystem.getPassengersForFlight(flightNumber);

                if (flight != null) {
                    for (Passenger passenger : passengers) {
                        String[] row = {flightNumber, String.valueOf(flight.getDepartureDate()), String.valueOf(flight.getTicketPrice()), passenger.getName(), passenger.getPassportNumber(), flight.getAircraft().getModel(), flight.getAircraft().getClass().getSimpleName()};

                        writer.writeNext(row);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
