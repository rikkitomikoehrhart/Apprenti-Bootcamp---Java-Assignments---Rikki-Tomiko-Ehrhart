package org.example.airport.data;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.example.airport.domain.model.*;
import org.example.airport.domain.reservation.ReservationSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CSVUtil {
    ReservationSystem reservationSystem;
    private final String PATH = "data/reservations.csv";


    public CSVUtil(ReservationSystem reservationSystem) {
        this.reservationSystem = reservationSystem;
    }

    public void saveReservationsToCSV() {
        String[] header = {"flightNumber", "departureDate", "ticketPrice", "passengerName", "passportNumber", "aircraftModel", "aircraftType", "capacity", "fuelCapacity", "airlineName", "hasLuxuryService", "maxSpeed"};

        try {
            File directory = new File("data");
            if (!directory.exists()) {
                directory.mkdirs();
            }
        } catch (NullPointerException e) {
            System.err.println("Error creating directory: " + e.getMessage());
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(PATH))) {
            writer.writeNext(header);

            List<String> flightNumbers = reservationSystem.getFlightNumbers();

            for (String flightNumber : flightNumbers) {
                Flight flight = reservationSystem.getFlight(flightNumber);
                List<Passenger> passengers = reservationSystem.getPassengersForFlight(flightNumber);

                if (flight != null && passengers != null) {
                    for (Passenger passenger : passengers) {
                        String[] row = createRow(flight, passenger);

                        writer.writeNext(row);
                    }
                }

            }

        } catch (IOException e) {
            System.err.println("ERROR: Saving reservations to CSV. -- " + e.getMessage());
        }

    }

    public String[] createRow(Flight flight, Passenger passenger) {
        Aircraft aircraft = flight.getAircraft();
        String[] row = new String[12];

        row[0] = flight.getFlightNumber();
        row[1] = flight.getDepartureDate().toString();
        row[2] = flight.getTicketPrice().toString();
        row[3] = passenger.getName();
        row[4] = passenger.getPassportNumber();
        row[5] = aircraft.getModel();
        row[6] = aircraft.getClass().getSimpleName();
        row[7] = String.valueOf(aircraft.getCapacity());
        row[8] = String.valueOf(aircraft.getFuelCapacity());

        if (aircraft instanceof CommercialAircraft) {
            row[9] = ((CommercialAircraft) aircraft).getAirlineName();
            row[10] = "";
            row[11] = "";
        } else if (aircraft instanceof PrivateJet) {
            row[9] = "";
            row[10] = String.valueOf(((PrivateJet) aircraft).isHasLuxuryService());
            row[11] = String.valueOf(((PrivateJet) aircraft).getMaxSpeed());
        } else {
            row[9] = "";
            row[10] = "";
            row[11] = "";
        }

        return row;
    }




    public void loadReservationsFromCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(PATH))) {
            List<String[]> records = reader.readAll();

            if (records.isEmpty()) {
                return;
            }


            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);

                if (record.length < 9) {
                    System.err.println("Invalid Record. Insufficient data");
                    continue;
                }


                try {
                    Aircraft aircraft = createAircraft(record);
                    Flight flight = createFlight(record, aircraft);
                    Passenger passenger = createPassenger(record);

                    reservationSystem.addFlight(flight);
                    reservationSystem.addReservation(flight.getFlightNumber(), passenger);
                } catch (Exception e) {
                    System.err.println("Error processing record " + i + ": " + e.getMessage());
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error Loading Reservations from CSV: " + e.getMessage());
        }
    }

    private Aircraft createAircraft(String[] record) {
        String model = record[5];
        String aircraftType = record[6];
        int capacity = Integer.parseInt(record[7]);
        double fuelCapacity = Double.parseDouble(record[8]);

        if ("CommercialAircraft".equals(aircraftType)) {
            String airlineName = record[9];

            return new CommercialAircraft(model, capacity, fuelCapacity, airlineName);
        } else if ("PrivateJet".equals(aircraftType)) {
            boolean hasLuxuryService = record[10].equals("true");
            int maxSpeed = Integer.parseInt(record[11]);

            return new PrivateJet(model, capacity, fuelCapacity, hasLuxuryService, maxSpeed);
        }

        return new Aircraft(model, capacity, fuelCapacity);
    }

    private Flight createFlight(String[] record, Aircraft aircraft) {
        return new Flight(record[0], LocalDate.parse(record[1]), new BigDecimal(record[2]), aircraft);
    }

    private Passenger createPassenger(String[] record) {
        return new Passenger(record[3], record[4]);
    }
}
