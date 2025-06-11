public abstract class Media {
    private String name;


    // GETS
    public String getName() {
        return name;
    }


    // SETS
    public void setName(String name) {
        this.name = name;
    }


    // ABSTRACTS
    abstract void play();
    abstract String getDescription();
}
