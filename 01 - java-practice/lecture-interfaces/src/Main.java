import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GuessResult guessResult = GuessResult.HIGHER;
        // dependency injection : constructor injection
        GameService gameService = new GameService(10, new AlwaysPicksOne());
        Scanner scanner = new Scanner(System.in);

        gameService.startGame();

        do {
            System.out.print("Enter a guess: ");
            int guess = Integer.parseInt(scanner.nextLine());
            guessResult = gameService.guess(guess);

            System.out.println(guessResult);
        } while (guessResult != GuessResult.WIN);
    }
}