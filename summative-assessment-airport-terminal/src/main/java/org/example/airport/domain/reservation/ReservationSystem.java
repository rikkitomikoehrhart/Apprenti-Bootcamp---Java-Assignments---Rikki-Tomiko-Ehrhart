package org.example.airport.domain.reservation;

import org.example.airport.domain.model.Flight;
import org.example.airport.domain.model.Passenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationSystem {
    HashMap<String, ArrayList<Passenger>> reservations;
    HashMap<String, Flight> flights;

    public ReservationSystem() {
        reservations = new HashMap<>();
        flights = new HashMap<>();
    }

    public void addReservation(String flightNumber, Passenger passenger) {
        if (reservations.containsKey(flightNumber)) {
            reservations.get(flightNumber).add(passenger);
        } else {
            reservations.put(flightNumber, new ArrayList<>(Arrays.asList(passenger)));
        }
    }

    public List<Passenger> getPassengersForFlight(String flightNumber) {
        return reservations.containsKey(flightNumber) ? reservations.get(flightNumber) : null;
    }

    public List<String> getFlightNumbers() {
        return reservations.keySet().stream().collect(Collectors.toList());
    }


    public void addFlight(Flight flight) {
        if (!flights.containsKey(flight.getFlightNumber())) {
            flights.put(flight.getFlightNumber(), flight);
        }
    }

    public Flight getFlight(String flightNumber) {
        return flights.containsKey(flightNumber) ? flights.get(flightNumber) : null;
    }

}
