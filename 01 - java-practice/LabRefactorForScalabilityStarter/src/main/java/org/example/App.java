package org.example;

import org.example.controller.MenuController;
import org.example.model.Printer;
import org.example.service.PrinterManager;
import org.example.service.PrinterMonitor;
import org.example.view.ConsoleIO;

/**
 * App class for the 3D Printer Manager Application
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConsoleIO io = ConsoleIO.getInstance();
        Printer myPrinter = new Printer("My Cool 3D Printer");
        PrinterMonitor monitor = new PrinterMonitor(myPrinter);
        PrinterManager manager = new PrinterManager();
        MenuController menu = new MenuController(io);

        manager.haltMonitors();

//        boolean running = true;
//
//        io.displayMessage("Printer monitor online");
//
//        while (running) {
//            io.displayMessage("[D]isplay printer status");
//            io.displayMessage("[P]rint an object");
//            io.displayMessage("[C]lear the print bed");
//            io.displayMessage("e[X]it");
//            String choice = io.getStringRequired("");
//
//            switch (choice) {
//                case "D":
//
//                case "P":
//
//                case "C":
//
//                case "X":
//                    running = false;
//                    break;
//            }
//        }
//        io.displayMessage("Halting printer monitors");
//        monitor.cancel();
//        io.displayMessage("Goodbye!");
//        System.exit(0);
    }
}
