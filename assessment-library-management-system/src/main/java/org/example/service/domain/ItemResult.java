package org.example.service.domain;

import org.example.model.inventory.InventoryItem;

import java.util.ArrayList;
import java.util.List;

public class ItemResult {
    private ArrayList<String> messages = new ArrayList<>();
    private InventoryItem item;

    public List<String> getErrorMessages() {
        return new ArrayList<>(messages);
    }

    public void addErrorMessage(String message) {
        messages.add(message);
    }

    public boolean isSuccess() {
        return messages.isEmpty();
    }

    public InventoryItem getItem() {
        return item;
    }

    public void setItem(InventoryItem item) {
        this.item = item;
    }


}
