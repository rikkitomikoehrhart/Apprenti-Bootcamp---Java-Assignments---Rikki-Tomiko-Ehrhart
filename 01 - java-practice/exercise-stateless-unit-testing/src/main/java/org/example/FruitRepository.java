package org.example;


import java.util.ArrayList;

public class FruitRepository {
    private ArrayList<Fruit> fruitBasket;


    public FruitRepository() {
        fruitBasket = new ArrayList<>();
    }

    public void save(Fruit fruit) {
        fruitBasket.add(fruit);
    }

    public void delete(String name) {
        fruitBasket.removeIf(fruit -> fruit.getName().equals(name));
    }

    public Fruit find(String name) {
        for (Fruit fruit : fruitBasket) {
            if (fruit.getName().equals(name)) {
                return fruit;
            }
        }
        return null;
    }
}
