package org.example.airport.data;

import org.example.airport.domain.model.Flight;
import org.example.airport.domain.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface FlightRepository {
    HashMap<String, ArrayList<Passenger>> getFlights();
    List<Flight> getAllFlights();
    Flight getFlightByNumber(String flightNumber);
    List<String> getFlightNumbers();
    void addReservation(String flightNumber, Passenger passenger);
    void addToFlights(Flight flight);
}
