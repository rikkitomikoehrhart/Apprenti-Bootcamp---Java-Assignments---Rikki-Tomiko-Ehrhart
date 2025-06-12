public class Cat implements Pet {
    private String name;
    private String breed;
    private int age;

    public Cat (String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String makeSound() {
        return "Meooow";
    }

    @Override
    public String doAction() {
        return String.format("%s stares at you, judgingly.");
    }
}
