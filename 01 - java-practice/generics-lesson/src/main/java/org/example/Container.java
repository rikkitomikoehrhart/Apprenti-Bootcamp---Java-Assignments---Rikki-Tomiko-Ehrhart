package org.example;

// Creating a Generic Container than can hold any type of object
public class Container<T> {
    private T value;        // The stored item.

    // this method lets us put something in the box
    public void set(T value) {
        this.value = value;
    }


    // This method lets us take something out of the box
    public T get() {
        return value;
    }

    /*
    The generic type is represented with a single upper case letter 'T' for type

    Other commonly used generic types are:

        * E for Element
        * K for Key
        * V for Value

    */
}
