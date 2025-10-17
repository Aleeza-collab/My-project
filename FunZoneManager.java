package ProjectPhase1;
import java.util.Scanner;

public class FunZoneManager {
    private MiniGame[] games;

    // Constructor initializes available games
    public FunZoneManager() {
        games = new MiniGame[3];
        games[0] = new GuessGame();
        games[1] = new TriviaGame();
        games[2] = new JokeGame();
    }

    // Displays menu and runs the selected game
    public void startFunZone(Scanner input) {
        int choice;
        do {
            System.out.println("\n🎮 === FUN ZONE MENU ===");
            System.out.println("1. Guess the Number");
            System.out.println("2. Trivia Game");
            System.out.println("3. Joke of the Day");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    games[0].playGame(input);
                    break;
                case 2:
                    games[1].playGame(input);
                    break;
                case 3:
                    games[2].playGame(input);
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 4);
    }
}

