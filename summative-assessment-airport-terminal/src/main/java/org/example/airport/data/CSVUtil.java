package org.example.airport.data;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import org.example.airport.domain.model.*;
import org.example.airport.domain.reservation.ReservationSystem;

import java.io.FileWriter;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CSVUtil {
    ReservationSystem reservationSystem;
    private final String PATH = "reservations.csv";


    public CSVUtil(ReservationSystem reservationSystem) {
        this.reservationSystem = reservationSystem;
    }

    public void saveReservationsToCSV() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(PATH))) {
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
            System.out.println("ERROR: " + e);
        }

    }


    public void loadReservationsFromCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(PATH))) {
            List<String[]> records = reader.readAll();

            for (String[] record : records) {
                Aircraft aircraft;

                if (record[6].equals("CommercialAircraft")) {
                    aircraft = new CommercialAircraft(record[5], 0, 0 , "");
                } else {
                    aircraft = new PrivateJet(record[5], 0, 0, false, 0);
                }
                
                Flight flight = new Flight(record[0], LocalDate.parse(record[1]), BigDecimal.valueOf(Long.parseLong(record[2])), aircraft);
                Passenger passenger = new Passenger(record[3], record[4]);


                reservationSystem.addFlight(flight);
                reservationSystem.addReservation(flight.getFlightNumber(), passenger);

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

}
