import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(20) + 1;
        int numberOfTries = 0;
        int guess;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 20.");
        System.out.println("You have 5 attempts to guess it.");

        while (numberOfTries < 5 && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numberOfTries++;

            if (guess < numberToGuess) {
                System.out.println("Your guess is too low. Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
        }

        int score = (hasGuessedCorrectly ? 100 : 0) - (numberOfTries * 20);
        score = Math.max(score, 0); // Ensure the score is not negative
        System.out.println("Your score: " + score + "%");

        scanner.close();
    }
}
