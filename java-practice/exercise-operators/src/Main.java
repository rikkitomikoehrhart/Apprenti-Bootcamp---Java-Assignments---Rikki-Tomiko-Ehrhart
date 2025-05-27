//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double loanAmount = 25000.00; // in dollars
        double annualInterestRate = 5.5; // as a percentage
        int loanTermYears = 5;
        double monthlyPayment;

        monthlyPayment = (loanAmount * (annualInterestRate/100)/12);

        loanAmount += 5000;
        annualInterestRate -= 1;
        loanTermYears++;

        System.out.println("Does loan amount exceed $30,000?: " + (loanAmount > 30000) + " (" + loanAmount + ")");
        System.out.println("Is the monthly payment more than $500?: " + (monthlyPayment > 500) + " (" + monthlyPayment + ")");

        boolean affordable = false;
        boolean expensive = false;

        if (monthlyPayment < 500 && loanTermYears > 5) {
            affordable = true;
        }

        if (monthlyPayment > 700 && annualInterestRate > 6) {
            expensive = true;
        }

        System.out.println("Is the loan affordable?: " + affordable);
        System.out.println("Is the loan expensive?: " + expensive);


        // Weather - Temperature Conversion & Forecast Analysis
        double temperatureCelsius = 25.0; // Current temperature in Celsius
        boolean isRaining = false;
        int windSpeedKmh = 10;

        double fahrenheit = (temperatureCelsius * (9/5)) + 32;

        fahrenheit += 5;
        windSpeedKmh += 5;

        System.out.println("Does the temperature exceed 85F?: " + (fahrenheit > 85) + " (" + fahrenheit + ")");
        System.out.println("Is Wind Speed greater than 20 km/h?: " + (windSpeedKmh > 20) + " (" + windSpeedKmh + ")");

        boolean goodDay = false;
        boolean weatherWarning = false;

        if (!isRaining && (fahrenheit >= 60 && fahrenheit <= 85)) {
            goodDay = true;
        }

        if (windSpeedKmh > 30 || fahrenheit < 0) {
            weatherWarning = true;
        }

        System.out.println("Is it a good day to go outside?: " + goodDay);
        System.out.println("Is there a weather warning?: " + weatherWarning);


        // Gaming - Player Score and Level Up System
        int currentXP = 1200;
        int level = 5;
        int xpToNextLevel = 1500;
        boolean levelUp;

        currentXP += 300;
        xpToNextLevel -= 300;
        currentXP *= 1;

        System.out.println("Is player close to leveling up? " + (currentXP >= xpToNextLevel));
        System.out.println("Has the player reached level 10? " + (level == 10));

        levelUp = false;

        if (xpToNextLevel <= 0 && level < 10) {
            levelUp = true;
        }

        boolean isAPro = false;

        if (level > 7 || currentXP > 5000) {
            isAPro = true;
        }

        System.out.println("Is the player leveling up now? " + levelUp);
        System.out.println("Is the player a pro? " + isAPro);


    }
}