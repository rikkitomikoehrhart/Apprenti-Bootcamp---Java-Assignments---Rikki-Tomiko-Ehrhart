import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // polymorphism
        // poly = many
        // morphic = type
        Pig a1 = new Pig("Pig", 1);

        a1.makeSound();

        ArrayList<Animal> zoo = new ArrayList<>();
        zoo.add(new Pig("Pig", 1));
        zoo.add(new Dog("Dog", 1, "Mutt"));
        zoo.add(new Dog("Joe", 17, "Chihweenie"));

        for (int i = 0; i < zoo.size(); i++) {
            zoo.get(i).makeSound();
        }

    }

}