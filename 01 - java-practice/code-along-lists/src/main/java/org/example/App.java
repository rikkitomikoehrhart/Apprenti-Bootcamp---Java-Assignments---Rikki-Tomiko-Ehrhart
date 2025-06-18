package org.example;


public class App 
{
    public static void main( String[] args ) {
        List<Exhibit> myExhibits = new ArrayList<Exhibit>();
        myExhibits[0].add(new Pond("Front Pond", 27.0, "Catfish", true));
        myExhibits[1].add(new Aquarium("100 Gallon Tank", 23.0, "Oscar", "Floating Water Moss"));
        myExhibits[2].add(new Terrarium("Little Turtle Tank", 27.0, 22.0, "Ornate Box Turtle"));


        System.out.println("Welcome to the Aquarium Manager!");

        System.out.println("Here are the current exhibits: ");
        for(Exhibit e : myExhibits) {
            System.out.println(e.getDescription());
        }

    }
}
