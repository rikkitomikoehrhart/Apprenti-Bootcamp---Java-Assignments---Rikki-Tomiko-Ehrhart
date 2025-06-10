

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Kalama Zoo");

        Animal lion = new Animal("Lion", 5, "Grrr");
        Animal tiger = new Animal("Tiger", 2, "ROAR");
        Animal bear = new Animal("Bear", 2, "growlsplash");

        Animal[] population = new Animal[3];

        population[0] = lion;
        population[1] = tiger;
        population[2] = bear;

        zoo.setPopulation(population);


        // Zookeeper Report
        zoo.printPopulationReport();

        // Visitor gets to hear the animals
        zoo.printAnimalSounds();
    }
}