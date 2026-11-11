import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class WordleGame {

    final private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        Set<String> allowedGuesses = new HashSet<>(
            Files.readAllLines(Paths.get("solutions.txt"))
        );

        allowedGuesses.addAll(
            Files.readAllLines(Paths.get("nonsolutions.txt"))
        );

        List<String> answers = Files.readAllLines(Paths.get("solutions.txt"));

        final String TARGET = answers.get(new Random().nextInt(answers.size())).toLowerCase();

        System.out.println("Welcome to offbrand Wordle!");
        System.out.println("You have 5 guesses to find the correct 5-letter word.");
        System.out.println("🟩 means the letter is in the correct position.");
        System.out.println("🟨 means the letter is in the word but in the wrong position.");
        System.out.println("⬛ means the letter is not in the word.");
        System.out.println("Have fun and good luck!");
        for (int i = 1; i < 6; i++)
            Guess(i, allowedGuesses, TARGET, args);
        
    }

    public static void Guess(int guessnum, Set<String> allowedGuesses, String TARGET, String[] args) throws IOException {
        String guess = "";
        while (true)
        {
            System.out.println("Guess " + guessnum);
            guess = scanner.nextLine().trim().toLowerCase();
            if (guess.equals("giveanswer"))
            {
                System.out.println("The answer is: " + TARGET);
            } else if (allowedGuesses.contains(guess)) {
                break;
            } else {
                System.out.println("Invalid guess. Please try again.");
            }

            
            
        }

        if (guess.equals(TARGET))
        {
            System.out.println("Congratulations! You've guessed the correct word: " + TARGET);
            System.out.println("Do you want to play again? (y/n)");
            String playAgain = scanner.nextLine().trim().toLowerCase();  

            if (playAgain.equals("y") || playAgain.equals("yes")) {
                main(args);
            } else {
                System.out.println("Thanks for playing!");
                System.exit(0); 
            }
            // System.exit(0);
  
        } else {
            checkGuess(guess, TARGET);
            if (guessnum == 5) {
                    System.out.println("Sorry, you've used all your guesses. The correct word was: " + TARGET);
                }  
            else {
                System.out.println("Incorrect guess. Please try again.");
            }
            
        }
    }

    public static void checkGuess(String guess, String TARGET) {
        String result = "";
        // String guessCopy = "";

         for (int i = 0; i <=4; i++)
            {
                if (guess.charAt(i) == TARGET.charAt(i))
                {   
                    result += "\n" + guess.charAt(i) + " ";
                    result += "🟩";
                }
                else if (TARGET.contains(String.valueOf(guess.charAt(i))))
                {
                    result += "\n" + guess.charAt(i) + " ";
                    result += "🟨" ;
                }
                else
                {
                    result += "\n" + guess.charAt(i) + " ";
                    result += "⬛";
                }
            }
        System.out.println(result);
        
    }
}