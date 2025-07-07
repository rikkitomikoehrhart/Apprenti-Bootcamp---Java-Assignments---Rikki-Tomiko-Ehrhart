package org.example.airport.data;

import org.example.airport.domain.model.*;
import org.example.airport.domain.reservation.ReservationSystem;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSampleDataRepository implements FlightRepository {
    private final List<Flight> sampleFlights;
    private final HashMap<String, ArrayList<Passenger>> repository;

    public FlightSampleDataRepository() {
        sampleFlights = createSampleFlights();
        repository = createSampleRepo();
    }

    private List<Flight> createSampleFlights() {
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight("EE123", LocalDate.of(2026, 1, 13), new BigDecimal("113.23"), new CommercialAircraft("SR-9086", 102, 72619.90, "American Airlines")));
        flights.add(new Flight("EE113", LocalDate.of(2025, 12,13), new BigDecimal("131.31"), new CommercialAircraft("RS-8690", 321, 198619.90, "Delta")));
        flights.add(new Flight("EE121", LocalDate.of(2025, 7, 26), new BigDecimal("351.90"), new CommercialAircraft("SE-1990", 100, 1000, "Jet Blue")));
        flights.add(new Flight("EE311", LocalDate.of(2025, 10, 2), new BigDecimal("111.11"), new CommercialAircraft("RE-1986", 150,15000, "Alaska Air")));


        flights.add(new Flight("MM106", LocalDate.of(2026, 1, 6), new BigDecimal("106.23"), new PrivateJet("KN-1616", 10, 120.00, true, 150)));
        flights.add(new Flight("MM203", LocalDate.of(2025, 8, 2), new BigDecimal("161.60"), new PrivateJet("NK-0203", 25, 42000, false, 175)));
        flights.add(new Flight("MM302", LocalDate.of(2025, 9, 3), new BigDecimal("302.23"), new PrivateJet("KN-0302", 13, 1300, true, 130)));
        flights.add(new Flight("MM601", LocalDate.of(2026, 2, 3), new BigDecimal("203.32"), new PrivateJet("NK-2023", 20, 1000, false, 160)));


        return flights;
    }

    private HashMap<String, ArrayList<Passenger>> createSampleRepo() {
        HashMap<String, ArrayList<Passenger>> repo = new HashMap<>();

        ArrayList<Passenger> passengers1 = new ArrayList<>();
        passengers1.add(new Passenger("Sam Ehrhart", "123456789"));
        passengers1.add(new Passenger("Rikki Ehrhart", "213456789"));
        passengers1.add(new Passenger("Beverley Scott", "231456789"));
        repo.put("EE123", passengers1);
        repo.put("MM106", passengers1);

        ArrayList<Passenger> passengers2 = new ArrayList<>();
        passengers2.add(new Passenger("Sherri Davis", "234156789"));
        passengers2.add(new Passenger("Tomiko Kawamura", "234516789"));
        passengers2.add(new Passenger("William Kennedy", "234561789"));
        repo.put("EE113", passengers2);
        repo.put("MM203", passengers2);

        ArrayList<Passenger> passengers3 = new ArrayList<>();
        passengers3.add(new Passenger("Judi Hess", "234567189"));
        passengers3.add(new Passenger("Merlin Hess", "234567819"));
        passengers3.add(new Passenger("Pamela Scott", "234567891"));
        repo.put("EE121", passengers3);
        repo.put("MM302", passengers3);

        ArrayList<Passenger> passengers4 = new ArrayList<>();
        passengers4.add(new Passenger("Cat Riley", "324567891"));
        passengers4.add(new Passenger("Walter Riley", "342567891"));
        passengers4.add(new Passenger("Laura Fick", "345267891"));
        repo.put("EE311", passengers4);
        repo.put("MM601", passengers4);

        return repo;
    }

    @Override
    public HashMap<String, ArrayList<Passenger>> getFlights() {
        return new HashMap<>(repository);
    }

    @Override
    public List<Flight> getAllFlights() {
        return new ArrayList<>(sampleFlights);
    }

    @Override
    public Flight getFlightByNumber(String flightNumber) {
        return sampleFlights.stream().filter(flight -> flight.getFlightNumber().equals(flightNumber)).findFirst().orElse(null);
    }

    @Override
    public List<String> getFlightNumbers() {
        return repository.keySet().stream().collect(Collectors.toList());
    }

    @Override
    public void addReservation(String flightNumber, Passenger passenger) {
        if (repository.containsKey(flightNumber)) {
            repository.get(flightNumber).add(passenger);
        } else {
            repository.put(flightNumber, new ArrayList<>(Arrays.asList(passenger)));
        }
    }

    @Override
    public void addToFlights(Flight flight) {
        if (!sampleFlights.contains(flight)) {
            sampleFlights.add(flight);
        }
    }


    public void populateReservationSystem(ReservationSystem reservationSystem) {
        for (Flight flight : sampleFlights) {
            reservationSystem.addFlight(flight);
        }

        for (String flightNumber : repository.keySet()) {
            for (Passenger passenger : repository.get(flightNumber)) {
                reservationSystem.addReservation(flightNumber, passenger);
            }
        }
    }

}
