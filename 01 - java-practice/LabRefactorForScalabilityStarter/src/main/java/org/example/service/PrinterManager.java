package org.example.service;


import org.example.model.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrinterManager {
    public Map<String, Printer> printersById;
    List<PrinterMonitor> monitors;

    public PrinterManager() {
        printersById = new HashMap<>();
        monitors = new ArrayList<>();
    }

    public void addPrinter(String key, Printer printer) {
        printersById.put(key, printer);
    }

    public Printer getPrinter(String key) {
        return printersById.get(key);
    }

    public ArrayList<String> getAllPrinterIDs() {
        ArrayList<String> ids = new ArrayList<>();

        for (Map.Entry<String, Printer> entry : printersById.entrySet()) {
            ids.add(entry.getKey());
        }

        return ids;
    }

    public void haltMonitors() {
        // I'm not sure what to do here...
    }

}
