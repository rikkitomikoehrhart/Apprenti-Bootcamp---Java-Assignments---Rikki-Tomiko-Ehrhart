package org.example.airport.domain.reservation;

import org.example.airport.domain.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;

public class ReservationSystem {
    HashMap<String, ArrayList<Passenger>> reservations;

    public ReservationSystem() {
        reservations = new HashMap<>();
    }


}
