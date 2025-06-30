package org.example;

import org.example.learn.memories.data.MemoryFileRepository;
import org.example.learn.memories.domain.MemoryService;
import org.example.learn.memories.ui.ConsoleIO;
import org.example.learn.memories.ui.Controller;
import org.example.learn.memories.ui.View;

public class App {
    public static void main(String[] args) {
        // "./data/memories.txt" is the path to our "production" data file.
        MemoryFileRepository repository = new MemoryFileRepository("./data/memories.txt");

        // repository satisfies the Memory Repository dependency.
        MemoryService service = new MemoryService(repository);

        ConsoleIO io = new ConsoleIO();
        // io satisfies the View dependency
        View view = new View(io);

        // view satisfies the View dependency
        // service satisfies teh MemoryService dependency
        Controller controller = new Controller(view, service);

        // Run the app!
        controller.run();
    }
}
