package org.example;

public class Box<T> {
    private T object;
    private String label;

    public Box(T object, String label) {
        this.object = object;
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public String getInfo() {
        return this.label + " " + this.object;
    }
}
