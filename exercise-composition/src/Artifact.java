public class Artifact {
    private String name;
    private int yearOfDiscovery;
    private Person discoverer;
    private Person curator;

    public Artifact(String name, int yearOfDiscovery, Person discoverer, Person curator) {
        this.name = name;
        this.yearOfDiscovery = yearOfDiscovery;
        this.discoverer = discoverer;
        this.curator = curator;
    }

    public String getName() {
        return name;
    }

    public int getYearOfDiscovery() {
        return yearOfDiscovery;
    }

    public Person getDiscoverer() {
        return discoverer;
    }

    public Person getCurator() {
        return curator;
    }

    @Override
    public String toString() {
        return String.format("Artifact:\t\t%s (%d)%nDiscoverer:\t\t%s%nCurator:\t\t%s", this.name, this.yearOfDiscovery, this.discoverer.toString(), this.curator.toString());
    }
}
