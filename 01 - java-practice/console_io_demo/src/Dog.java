public class Dog {
    // If you want to keep the data around, you must declare it at the
    // class level
    private String name;
    private int age;
    private String breed;

    // because parameters are transient, they are destroyed when the
    // function ends
    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public void Bark() {
        System.out.println("Woof woof!");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
