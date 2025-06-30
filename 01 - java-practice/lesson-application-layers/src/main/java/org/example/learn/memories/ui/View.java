package org.example.learn.memories.ui;

import org.example.learn.memories.models.Memory;
import java.util.List;

public class View {
    private final TextIO io;

    public View(TextIO io) {
        this.io = io;
    }

    public int chooseMenuOption() {
        displayHeader("Main Menu");
        io.println("0. Exit");
        io.println("1. View Memories");
        io.println("2. Add a Memory");
        io.println("3. Update a Memory");
        io.println("4. Delete a Memory");
        return io.readInt("Choose [0-4]: ", 0, 4);
    }

    public Memory chooseMemory(List<Memory> memories) {
        displayMemories(memories);
        Memory result = null;
        if (memories.size() > 0) {
            int memoryId = io.readInt("Choose a Memory ID: ");
            for (Memory m : memories) {
                if (m.getId() == memoryId) {
                    result = m;
                    break;
                }
            }
        }
        return result;
    }

    public boolean isPublic() {
        io.println("1. Public");
        io.println("2. Private");
        return io.readInt("Choose [1-2]: ", 1, 2) == 1;
    }

    public void displayHeader(String message) {
        int length = message.length();
        io.println("");
        io.println(message);
        io.println("=".repeat(length));
    }





}
