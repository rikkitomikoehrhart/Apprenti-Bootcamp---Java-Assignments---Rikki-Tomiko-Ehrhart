public class App {
    public static void main(String[] args) {
        Enclosure myEnclosure = new Enclosure();

        myEnclosure.setName("Turtle Exhibit");
        myEnclosure.setTemp(31.0);


        myEnclosure.setResident(new Inhabitant());
        myEnclosure.getResident().setName("Box turtle");
        myEnclosure.getResident().setFood("Lettuce");

        System.out.println("Our enclosure name is: " + myEnclosure.getName());
        System.out.println("Our enclosure resident is name: " + myEnclosure.getResident().getName());

    }
}
