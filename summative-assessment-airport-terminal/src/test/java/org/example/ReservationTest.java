package org.example;

import org.example.airport.domain.model.CommercialAircraft;
import org.example.airport.domain.model.Flight;
import org.example.airport.domain.model.Passenger;
import org.example.airport.domain.reservation.ReservationSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {
    ReservationSystem reservationSystem;
    Passenger sam;
    Passenger rikki;
    Passenger kellen;
    Passenger nicole;
    Flight flight;

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

        flight = new Flight("12345", LocalDate.now(), BigDecimal.ONE, new CommercialAircraft("12345", 100, 123.45, "Airplanes Inc."));
    }


    @Test
    @DisplayName("Creating a Flight in the Reservation System")
    public void createAFlightInTheReservationSystem() {
        assertNotNull(reservationSystem.getPassengersForFlight("12345"));
        assertEquals(2, reservationSystem.getPassengersForFlight("12345").size());
    }

    @Test
    @DisplayName("If a Flight Number Doesn't Exist Should Return Null")
    public void flightNumberDoesntExistReturnNull() {
        assertNull(reservationSystem.getPassengersForFlight("Should Return Null"));
    }

    @Test
    @DisplayName("Get list of flight numbers")
    public void getListOfFlightNumbers() {
        List<String> flightNumbers = reservationSystem.getFlightNumbers();

        assertEquals(2, flightNumbers.size());
    }

    @Test
    @DisplayName("If Flight Number Isn't In Flights Should Return Null")
    public void flightNumberNotInFlightsReturnsNull() {
        ReservationSystem system2 = new ReservationSystem();

        assertNull(system2.getFlight("Should Return Null"));
    }


    @Test
    @DisplayName("Adding a Flight To The Flights HashMap")
    public void addFlight() {
        reservationSystem.addFlight(flight);

        assertNotNull(reservationSystem.getFlight(flight.getFlightNumber()));
    }

}
