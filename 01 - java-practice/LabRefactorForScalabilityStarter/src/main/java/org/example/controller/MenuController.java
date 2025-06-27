package org.example.controller;

import org.example.model.Printer;
import org.example.service.PrinterManager;
import org.example.view.ConsoleIO;




public class MenuController {
    ConsoleIO io;

    public MenuController(ConsoleIO io) {
        this.io = io;
    }

    public void display(Printer myPrinter) {
        io.displayMessage(myPrinter.toString());
    }

    public void add(PrinterManager manager, String key, Printer myPrinter) {
        manager.addPrinter(key, myPrinter);
    }

    public void print(Printer myPrinter) {
        if (myPrinter.getStatus().equals(Printer.PrinterStatus.READY)) {
            String file = io.getStringRequired("Object to print");
            myPrinter.print(file);
        } else {
            io.displayMessage("Printer not ready to accept a new print.");
        }
    }

    public void clear(Printer myPrinter) {
        if (myPrinter.getStatus().equals(Printer.PrinterStatus.COMPLETE)) {
            io.displayMessage("Retrieving " + myPrinter.getPrintModelName());
            myPrinter.clearBed();
            io.displayMessage(myPrinter.toString());
        } else {
            io.displayMessage("Print incomplete or not started.");
        }
    }
}
