


public class Main {
    public static void main(String[] args) {
        Person wSmith = new Person("Wyoming", "Smith", "Archaeologist and Adventure");
        Person mBlodsky = new Person("Mark", "Blodsky", "Nebbishy Academioc");

        Artifact arkCovenent = new Artifact("The Ark of the Covenent", 1936, wSmith, mBlodsky);

        System.out.println(arkCovenent.toString());
    }
}