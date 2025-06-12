public class Main {
    public static void main(String[] args) {
        int numberOfExhibits = 3;
        Exhibit[] exhibits = new Exhibit[numberOfExhibits];

        Pond myPond = new Pond("Front Pond", 27.0, "Catfish", true);
        Aquarium myAquarium = new Aquarium("100 Gallon Tank", 23.0, "Oscar", "Floating Water Moss");
        Terrarium myTerrarium = new Terrarium("Little Turtle Tank", 27.0, 22.0, "Ornate Box Turtle");

        exhibits[0] = myPond;
        exhibits[1] = myAquarium;
        exhibits[2] = myTerrarium;

        for (Exhibit e : exhibits) {
            System.out.println(e.getDescription());
        }
    }
}