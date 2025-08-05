package com.example.Simple.Bistro.API.Demo.model;

public class Item {
    private Integer itemID;
    private String itemName;

    public Item() {}

    public Item(Integer itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item{itemID=" + itemID + ", itemName=" + itemName + "}";
    }
}
