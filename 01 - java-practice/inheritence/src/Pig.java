// Inheritance
public class Pig extends Animal {

    public Pig(String name, int age) {
        // Calls the parent constructor (in this case, Animal)
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.printf("The %s says Oink!%n", this.name);
    }
}
