public class Animal {
    private String name;            // the name of the species
    private int populationCount;    // total animal count within the species
    private String sound;           // the sound the animal makes


    // CONSTRUCTORS
    public Animal() {
        // Defining a blank constructor, so Java
        // won't automatically make a default.
    }

    public Animal(String name, int populationCount, String sound) {
        this.name = name;
        this.populationCount = populationCount;
        this.sound = sound;
    }


    // GETTERS
    public String getName() {
        return this.name;
    }

    public int getPopulationCount() {
        return this.populationCount;
    }

    public String getSound() {
        return this.sound;
    }


    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPopulationCount(int populationCount) {
        this.populationCount = populationCount;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

}
