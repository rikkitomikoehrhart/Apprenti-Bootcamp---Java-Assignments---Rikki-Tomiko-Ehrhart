public class Zoo {
    private String name;            // the name of the zoo
    private Animal[] population;    // an array of animals in the Zoo


    // CONSTRUCTORS
    public Zoo(String name) {
        this.name = name;
    }


    // GETTERS
    public String getName() {
        return this.name;
    }

    public Animal[] getPopulation() {
        return this.population;
    }


    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(Animal[] population) {
        this.population = population;
    }


    // REPORTS
    public void printPopulationReport() {
        System.out.println("Population Report: " + name);
        System.out.println("==========================================================");
        System.out.println();
        for (int i = 0; i < population.length; i++) {
            Animal a = population[i];
            System.out.println(a.getName() + ": " + a.getPopulationCount());
        }
        System.out.println("==========================================================");
    }

    public void printAnimalSounds() {
        System.out.println("The Sounds of: " + name);
        System.out.println("==========================================================");
        System.out.println();
        for (int i = 0; i < population.length; i++) {
            Animal a = population[i];
            System.out.println(a.getSound());
        }
        System.out.println("==========================================================");
    }

}
