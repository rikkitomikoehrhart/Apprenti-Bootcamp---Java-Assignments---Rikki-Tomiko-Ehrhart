package org.example.model;

import org.example.service.PrinterManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {
    Printer printer;
    PrinterManager printerManager;

    @BeforeEach
    public void setUp() {
        printerManager = new PrinterManager();
        printer = new Printer("Test Printer");
    }


    // Printer.java
    @Test
    @DisplayName("Printer.java getStatus() returns a status")
    void getPrinterReturnsAStatus() {
        assertEquals(Printer.PrinterStatus.READY, printer.getStatus());
    }

    @Test
    @DisplayName("Printer.java setStatus() sets a printer's status")
    void setStatusSetsAPrinterStatus() {
        printer.setStatus(Printer.PrinterStatus.PRINTING);
        assertEquals(Printer.PrinterStatus.PRINTING, printer.getStatus());
    }

    @Test
    @DisplayName("Printer.java getPrintModelName() returns a printModelName")
    void getPrintModelNameReturnsAPrintModelName() {
        String expected = "Print Model Name";
        printer.print(expected);
        assertEquals(expected, printer.getPrintModelName());
    }

    @Test
    @DisplayName("Printer.java clearBed() resets printerModelName and status")
    void clearBedResetsPrinterModelNameAndStatus() {
        printer.print("Print Model Name");
        printer.clearBed();
        assertNull(printer.getPrintModelName());
        assertEquals(Printer.PrinterStatus.READY, printer.getStatus());
    }

    @Test
    @DisplayName("Printer.java setName() and getName() sets and returns the printer name, respectively")
    public void setNameAndGetNameSetsAndReturnsThePrinterName() {
        String expected = "Printer Test";
        printer.setName(expected);
        assertEquals(expected, printer.getName());
    }


    // PrinterManager.java
    @Test
    @DisplayName("PrinterManager.java addPrinter() adds a printer to the map")
    public void addPrinterAddsAPrinterToTheMap() {
        printerManager.addPrinter("1", printer);

        assertEquals(1, printerManager.printersById.size());
    }

    @Test
    @DisplayName("PrinterManager.java getPrinter() returns a printer by its key")
    public void getPrinterReturnsAPrinterByItsKey() {
        printerManager.addPrinter("1", printer);

        assertEquals(printer, printerManager.getPrinter("1"));
    }

    @Test
    @DisplayName("PrinterManager.java getAllPrinterIDs() returns an ArrayList of the printer ids")
    public void getAllPrinterIDsReturnsAnArrayListOfIDs() {
        printerManager.addPrinter("1", printer);
        printerManager.addPrinter("100", printer);
        printerManager.addPrinter("Testing", printer);

        ArrayList<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("100");
        ids.add("Testing");

        ArrayList<String> actual = printerManager.getAllPrinterIDs();

        assertEquals(ids, actual);
    }



}