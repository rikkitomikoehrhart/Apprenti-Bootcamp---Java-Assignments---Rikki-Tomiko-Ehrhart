package org.example.airport.data;

import org.example.airport.domain.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;

public interface FlightRepository {

    HashMap<String, ArrayList<Passenger>> getFlights();
}
