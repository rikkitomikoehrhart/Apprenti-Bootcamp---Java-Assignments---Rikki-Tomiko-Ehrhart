import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
         Scanner io = new Scanner(System.in);
         System.out.print("Welcome player! ");

         do {
             System.out.print("Would you like to enter the cave? (y/n) ");
             String enterCave = io.nextLine();

             if (enterCave.equals("y")) {
                 System.out.println("You've entered the cave!");
                 System.out.print("There are two paths ahead of you. Do you choose to go left (l) or right(r)? ");
                 String direction = io.nextLine();

                 if (direction.equals("l")) {
                     System.out.println("You traverse through a winding cave, squeezing in tight spaces and going deeper and deeper.");
                     System.out.println("You find a fork in your path. On the left you see a hooded figure groaning and slowly lumbering towards you.");
                     System.out.println("On your right all you see is darkness, but a darkness you could probably hide in.");

                     System.out.print("Would you rather fight the hooded figure and go left (l)? Or flee and go right (r)?");

                     String fightOrFlee = io.nextLine();

                     if (fightOrFlee.equals("l")){
                         System.out.println("You almost instantly die. Almost except for 2 seconds of regret.");
                         break;
                     } else if (fightOrFlee.equals("r")) {
                         System.out.println("The hooded figure doesn't seem to notice you and you are able to sneak by without issue.");
                         System.out.println("You find yourself in a large cavern and in the middle is a lamp with a golden light on it.");
                         System.out.println("You figure that since you're alone, there is no point in not trying it...");

                         System.out.println("You run the lamp and out pops a genie who offers you one wish, which do you choose: ");

                         System.out.println("1. Become a billionaire!");
                         System.out.println("2. Find true love!");
                         System.out.println("3. Be famous!");
                         System.out.println("4. Perfect body!");
                         System.out.println("5. Free the Genie");

                         System.out.print("What is your choice, mortal?: ");
                         String choice = io.nextLine();

                         switch(choice) {
                             case "1":
                                 System.out.println("Sure you become a billionaire... in Zimbabwean Dollars (Z$). Even if you went back in time to before 2009 when it was still around, you wouldn't be able to do anything with it...");
                                 break;
                             case "2":
                                 System.out.println("You do find true love... it's just not romantic love. You find it in a 16 year old chihuahua. You only have a few years with your beloved pet, but they were wonderful.");
                                 break;
                             case "3":
                                 System.out.println("You become famous the world over! Too bad its because when you went your favorite team's big game and the camera crew came over to interview you, you let out a huge fart and it was so stinky that several people sitting around you passed out. Everyone in the world knows you as the person with the stinkiest farts");
                                 break;
                             case "4":
                                 System.out.println("You morph and have the perfect body! Of course, you didn't specify the perfect body of what species, but you do end up winning the Westminster Dog Show 5 times!");
                                 break;
                             case "5":
                                 System.out.println("The Genies dabs you up and says \"Thanks, man\" and bamfs out.");
                                 break;
                             default:
                                 System.out.println("You tried to trick the genie?! He snaps his fingers and you disappear from existance.");
                                 break;
                         }
                     } else {
                         System.out.print("You didn't enter a valid answer (of l for left/fight or r for right/flee) so the ground beneath you opens up and swallows you hole. Sorry not sorry.");
                         break;
                     }

                 } else if (direction.equals("r")) {
                     System.out.println("You traverse the cave easily and painlessly. But you didn't find the treasure. Oh well.");
                     break;
                 } else {
                     System.out.println("You didn't enter a valid answer (of l for left or r of right) so your body explodes. Sorry not sorry.");
                     break;
                 }


             } else if (enterCave.equals("n")) {
                 break;
             } else {
                 System.out.println("Please enter a y for yes or an n for no. ");
             }


         } while (true);

         System.out.println("Thank you for playing. Have a nice day.");
    }
}