package org.example;

import org.example.airport.domain.model.Passenger;
import org.example.airport.domain.reservation.ReservationSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {
    ReservationSystem reservationSystem;
    Passenger sam;
    Passenger rikki;
    Passenger kellen;
    Passenger nicole;


    @BeforeEach
    void setUp() {
        reservationSystem = new ReservationSystem();

        sam = new Passenger("Sam Ehrhart", "123456789");
        rikki = new Passenger("Rikki Ehrhart", "987654321");
        kellen = new Passenger("Kellen Morhmann", "321654987");
        nicole = new Passenger("Nicole Morhmann", "789456123");

        reservationSystem.addReservation("12345", sam);
        reservationSystem.addReservation("12345", rikki);

        reservationSystem.addReservation("56789", kellen);
        reservationSystem.addReservation("56789", nicole);
    }


    @Test
    @DisplayName("Creating a Flight in the Reservation System")
    public void createAFlightInTheReservationSystem() {
        assertNotNull(reservationSystem.getPassengersForFlight("12345"));
        assertEquals(2, reservationSystem.getPassengersForFlight("12345").size());

    }

    @Test
    @DisplayName("Get list of flight numbers")
    public void getListOfFlightNumbers() {
        List<String> flightNumbers = reservationSystem.getFlightNumbers();

        assertEquals(2, flightNumbers.size());
    }


}
