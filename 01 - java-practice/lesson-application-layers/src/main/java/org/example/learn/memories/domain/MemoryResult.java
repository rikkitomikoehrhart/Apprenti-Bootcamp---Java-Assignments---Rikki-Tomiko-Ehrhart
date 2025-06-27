package org.example.learn.memories.domain;

import org.example.learn.memories.models.Memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryResult {
    private ArrayList<String> messages = new ArrayList<>();
    private Memory memory;

    public List<String> getErrorMessages() {
        return new ArrayList<>(messages);
    }

    public void addErrorMessage(String message) {
        messages.add(message);
    }

    public boolean isSuccess() {
        return messages.isEmpty();
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
}
