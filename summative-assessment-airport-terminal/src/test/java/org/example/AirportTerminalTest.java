package org.example;

import org.example.airport.domain.model.CommercialAircraft;
import org.example.airport.domain.model.Flight;
import org.example.airport.domain.model.PrivateJet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTerminalTest {



    // Creating Different Aircraft Types and Associating them with Flights
    @Test
    @DisplayName("Creating A Commercial Flight")
    public void creatingACommercialFlight() {
        Flight flight = new Flight("TEST123", LocalDate.now(), BigDecimal.valueOf(100.00), new CommercialAircraft("Model", 100, 123.45, "Delta"));

        assertEquals("org.example.airport.domain.model.CommercialAircraft", flight.getAircraft().getClass().getName());
    }

    @Test
    @DisplayName("Creating A Private Jet Flight")
    public void creatingAPrivateJetFlight() {
        Flight flight = new Flight("TEST123", LocalDate.now(), BigDecimal.valueOf(100.00), new PrivateJet("Model", 100, 123.45, true, 1000));

        assertEquals("org.example.airport.domain.model.PrivateJet", flight.getAircraft().getClass().getName());
    }
}
