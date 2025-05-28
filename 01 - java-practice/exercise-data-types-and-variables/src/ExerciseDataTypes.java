public class ExerciseDataTypes {
    public static void main(String[] args) {
        // Player Information
        String playerName = "Megan Rapinoe";
        byte jerseyNumber = 15;
        String position = "Forward";
        boolean isStarter = true;
        String teamName = "US Women's National Team";


        // Movie Information
        String movieTitle = "Drop Dead Gorgeous";
        int releaseYear = 1999;
        String rating = "PG-13";
        boolean isSequel = false;
        String leadActor = "Kirsten Dunst";


        // Weather Report
        String cityName = "Austin";
        byte temperature = 89;
        boolean isRaining = false;
        byte humidity = 54;
        String weatherCondition = "Mostly Sunny";


        // Flight Information
        String flightNumber = "AA256";
        String departureCity = "New York";
        String arrivalCity = "Los Angeles";
        byte gateNumber = 13;
        char terminal = 'D';
        boolean isDelayed = false;


        // PRINT
        // Player
        System.out.println("Soccer Player: " + playerName + " wears jersey number " + jerseyNumber + " and plays as a " + position + " for " + teamName + ".");

        // Movie
        System.out.println("The movie " + movieTitle + " was released in " + releaseYear + " and stars " + leadActor + ".");

        // Weather
        System.out.println("Weather Report: " + cityName + " has a temperature of " + temperature + "F with " + weatherCondition + ".");

        // Flight
        System.out.println("Ticket: Flight " + flightNumber + " " + departureCity + " to " + arrivalCity + " please meet at Terminal: " + terminal + ", Gate: " + gateNumber + ".");


        // Update values
        jerseyNumber = 13;
        isStarter = false;

        rating = "R";
        isSequel = true;

        temperature = 95;
        weatherCondition = "Very Sunny";

        gateNumber = 14;
        isDelayed = true;


        // RE-PRINT
        // Player
        System.out.println("Soccer Player: " + playerName + " wears jersey number " + jerseyNumber + " and plays as a " + position + " for " + teamName + ".");

        // Movie
        System.out.println("The movie " + movieTitle + " was released in " + releaseYear + " and stars " + leadActor + ".");

        // Weather
        System.out.println("Weather Report: " + cityName + " has a temperature of " + temperature + "F with " + weatherCondition + ".");

        // Flight
        System.out.println("Ticket: Flight " + flightNumber + " " + departureCity + " to " + arrivalCity + " please meet at Terminal: " + terminal + ", Gate: " + gateNumber + ".");



        // Working with Boolean Variables
        boolean hasHomework = true;
        boolean isWeekend = false;
        boolean attendedClass = true;

        // PRINT
        System.out.println("Do I have homework? " + hasHomework);
        System.out.println("Is it the weekend? " + isWeekend);
        System.out.println("Did I attend class today? " + attendedClass);


        // The char Data Type
        char firstInitial = 'R';
        char lastInitial = 'E';
        char favoriteGrade = 'A';

        System.out.println("I am " + firstInitial + ". " + lastInitial + ". and my favorite grade is " + favoriteGrade);


    }
}