public class Dog extends Animal {
    String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }


    public String getBreed() {
        return this.breed;
    }

    @Override
    public void makeSound() {
        System.out.printf("The %s says Bark!", this.name);
    }

}
