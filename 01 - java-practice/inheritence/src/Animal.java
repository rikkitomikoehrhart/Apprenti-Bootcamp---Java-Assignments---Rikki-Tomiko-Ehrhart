public class Animal {
    // protected means only the parent and child classes
    // can see and access
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.printf("The %s makes a sound.", this.name);
    }
}


