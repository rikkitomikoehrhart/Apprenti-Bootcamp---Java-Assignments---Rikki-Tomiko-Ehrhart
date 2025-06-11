public abstract class Media {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void play();
    abstract String getDescription();
}
