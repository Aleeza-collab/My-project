package ProjectPhase1;

import java.util.Random;
import java.util.Scanner;

/*
 * =======================================================
 *                   MiniGame.java
 * =======================================================
 * This file contains the abstract base class `MiniGame`
 * and three mini-games that extend it:
 *   1. GuessGame   → Number guessing game
 *   2. TriviaGame  → Simple quiz question
 *   3. JokeGame    → Displays a random programming joke
 *
 * Note:
 *  - Only one class (MiniGame) is declared public.
 *  - All three game classes are package-private (non-public)
 *    and can be accessed from other classes in the same package,
 *    e.g., FunZoneManager.
 */

public abstract class MiniGame {

    // ===================================================
    // Abstract method: must be implemented by every game
    // ===================================================
    public abstract void playGame(Scanner input);
}

/* ---------------------------------------------------
 * 1️⃣  GuessGame
 * ---------------------------------------------------
 * A simple number guessing game between 1 and 10.
 * The player wins if their guess matches the random number.
 */
class GuessGame extends MiniGame {
    @Override
    public void playGame(Scanner input) {
        Random rand = new Random();
        int number = rand.nextInt(10) + 1;  // Random number between 1–10

        System.out.println("🎯 Guess the number between 1 and 10!");
        System.out.print("Enter your guess: ");
        int guess = input.nextInt();

        if (guess == number) {
            System.out.println("✅ Correct! You guessed it!");
        } else {
            System.out.println("❌ Oops! The number was " + number);
        }
    }
}

/* ---------------------------------------------------
 * 2️⃣  TriviaGame
 * ---------------------------------------------------
 * Asks one general-knowledge question.
 * The player types an answer and receives feedback.
 */
class TriviaGame extends MiniGame {
    @Override
    public void playGame(Scanner input) {
        System.out.println("🧠 Trivia Time! Answer this question:");
        System.out.println("What is the capital of France?");
        System.out.println("A) Paris  B) Rome  C) Berlin  D) Madrid");
        System.out.print("Your answer: ");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("Paris")) {
            System.out.println("✅ Correct! Well done!");
        } else {
            System.out.println("❌ Wrong! The correct answer is Paris.");
        }
    }
}

/* ---------------------------------------------------
 * 3️⃣  JokeGame
 * ---------------------------------------------------
 * Displays a random programming-related joke.
 * Adds a fun element to the diary’s Fun Zone section.
 */
class JokeGame extends MiniGame {
    @Override
    public void playGame(Scanner input) {
        String[] jokes = {
                "💻 Why don't programmers like nature? It has too many bugs!",
                "🖥️ Why did the computer go to therapy? It had a hard drive!",
                "☕ Why did Java developers wear glasses? Because they can't C#!"
        };

        Random rand = new Random();
        int index = rand.nextInt(jokes.length);

        System.out.println("😂 Here's a joke for you:");
        System.out.println(jokes[index]);
    }
}
