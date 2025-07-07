package org.example.airport.domain.reservation;

import org.example.airport.domain.model.Passenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReservationSystem {
    HashMap<String, ArrayList<Passenger>> reservations;

    public ReservationSystem() {
        reservations = new HashMap<>();
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
}
