package org.example;

import org.example.airport.data.CSVUtil;
import org.example.airport.domain.model.*;
import org.example.airport.domain.reservation.ReservationSystem;
import org.junit.jupiter.api.*;


import java.io.File;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


public class CSVUtilTest {
    private ReservationSystem reservationSystem;
    private CSVUtil csvUtil;
    private final String TEST_CSV_PATH = "data/test_reservations.csv";

    @BeforeEach
    void setUp() {
        reservationSystem = new ReservationSystem();
        csvUtil = new CSVUtil(reservationSystem);

        File dataDirectory = new File("data");
        if (!dataDirectory.exists()) {
            dataDirectory.mkdirs();
        }
    }


    @Test
    @DisplayName("Save and Load Commercial Flight Reservations")
    public void saveAndLoadCommercialFlightReservations() {
        CommercialAircraft aircraft = new CommercialAircraft("Boeing", 100, 2000.0, "American Airlines");
        Flight flight = new Flight("AA123", LocalDate.of(2025, 07, 07), new BigDecimal("500.00"), aircraft);
        Passenger sam = new Passenger("Sam Ehrhart", "123456789");
        Passenger rikki = new Passenger("Rikki Ehrhart", "987654321");
        
        reservationSystem.addFlight(flight);
        reservationSystem.addReservation("AA123", sam);
        reservationSystem.addReservation("AA123", rikki);
        
        csvUtil.saveReservationsToCSV();
        
        ReservationSystem loadSystem = new ReservationSystem();
        CSVUtil loadCsvUtil = new CSVUtil(loadSystem);
        loadCsvUtil.loadReservationsFromCSV();
        
        Flight loadedFlight = loadSystem.getFlight("AA123");

        assertNotNull(loadedFlight);
        assertEquals(flight.getFlightNumber(), loadedFlight.getFlightNumber());

        List<Passenger> reservationList = reservationSystem.getPassengersForFlight(flight.getFlightNumber());
        List<Passenger> loadedList = loadSystem.getPassengersForFlight(loadedFlight.getFlightNumber());

        assertEquals(reservationList.size(), loadedList.size());

    }

    @Test
    @DisplayName("Save and Load Private Jet Flight Reservations")
    public void saveAndLoadPrivateJetReservations() {
        PrivateJet aircraft = new PrivateJet("Boeing", 100, 2000.0, true, 1000);
        Flight flight = new Flight("AA123", LocalDate.of(2025, 07, 07), new BigDecimal("500.00"), aircraft);
        Passenger sam = new Passenger("Sam Ehrhart", "123456789");
        Passenger rikki = new Passenger("Rikki Ehrhart", "987654321");

        reservationSystem.addFlight(flight);
        reservationSystem.addReservation("AA123", sam);
        reservationSystem.addReservation("AA123", rikki);

        csvUtil.saveReservationsToCSV();

        ReservationSystem loadSystem = new ReservationSystem();
        CSVUtil loadCsvUtil = new CSVUtil(loadSystem);
        loadCsvUtil.loadReservationsFromCSV();

        Flight loadedFlight = loadSystem.getFlight("AA123");

        assertNotNull(loadedFlight);
        assertEquals(flight.getFlightNumber(), loadedFlight.getFlightNumber());

        List<Passenger> reservationList = reservationSystem.getPassengersForFlight(flight.getFlightNumber());
        List<Passenger> loadedList = loadSystem.getPassengersForFlight(loadedFlight.getFlightNumber());

        assertEquals(reservationList.size(), loadedList.size());

    }

    @Test
    @DisplayName("Empty Reserve System Is Empty")
    public void emptyReserveSystemIsEmpty() {
        csvUtil.saveReservationsToCSV();

        ReservationSystem emptySystem = new ReservationSystem();
        CSVUtil emptyCsvUtil = new CSVUtil(emptySystem);
        emptyCsvUtil.loadReservationsFromCSV();

        assertTrue(emptySystem.getFlightNumbers().isEmpty());

    }

    @Test
    @DisplayName("Missing CSV File")
    public void missingCVSFile() {
        try {
            Files.deleteIfExists(Paths.get("data/reservations.csv"));
        } catch (IOException e) {

        }

        assertDoesNotThrow(() -> {
            csvUtil.loadReservationsFromCSV();
        });

        assertTrue(reservationSystem.getFlightNumbers().isEmpty());
    }

    @Test
    @DisplayName("Test Directory Creation")
    public void testDirectoryCreation() {
        File dataDirectory = new File("data");
        if (dataDirectory.exists()) {
            try {
                Files.deleteIfExists(Paths.get("data/reservations.csv"));
                dataDirectory.delete();
            } catch (IOException e) {

            }
        }


        CommercialAircraft aircraft = new CommercialAircraft("Test", 100,1000.0, "Test Airlines");
        Flight flight = new Flight("Test123", LocalDate.now(), new BigDecimal("100.00"), aircraft);
        Passenger passenger = new Passenger("Test", "11111");

        reservationSystem.addFlight(flight);
        reservationSystem.addReservation("Test123", passenger);

        assertDoesNotThrow(() -> {
            csvUtil.saveReservationsToCSV();
        });

        assertTrue(new File("data/reservations.csv").exists());
    }




}
