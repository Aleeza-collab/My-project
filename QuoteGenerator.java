package ProjectPhase1;
// ================================================
// Class Name: QuoteGenerator
// Purpose: Displays random motivational quotes
// Used in: Diary Application
// Note: Uses simple String array (no ArrayList)
// ================================================
import java.util.Random;
public class QuoteGenerator {

    private String[] quotes;  // Array to store quotes
    private Random random;    // Random object for selecting quotes

    // --------------------------------------------
    // Constructor: Initializes the quote list
    // --------------------------------------------
    public QuoteGenerator() {
        quotes = new String[10];
        random = new Random();

        // Fill array with sample motivational quotes
        quotes[0] = "Believe in yourself and all that you are.";
        quotes[1] = "Every day is a second chance.";
        quotes[2] = "Dream big, work hard, stay focused.";
        quotes[3] = "Difficult roads often lead to beautiful destinations.";
        quotes[4] = "Start where you are. Use what you have. Do what you can.";
        quotes[5] = "You are stronger than you think.";
        quotes[6] = "Happiness is not by chance, but by choice.";
        quotes[7] = "Be proud of how far you’ve come.";
        quotes[8] = "The best view comes after the hardest climb.";
        quotes[9] = "Stay positive. Work hard. Make it happen.";
    }

    // --------------------------------------------
    // Method: showRandomQuote
    // Purpose: Displays one random quote
    // --------------------------------------------
    public void showRandomQuote() {
        int index = random.nextInt(quotes.length);
        System.out.println("\n💬 Quote of the Day:");
        System.out.println("\"" + quotes[index] + "\"");
    }

    // --------------------------------------------
    // Method: showAllQuotes
    // Purpose: Displays all available quotes
    // --------------------------------------------
    public void showAllQuotes() {
        System.out.println("\n=== All Available Quotes ===");
        for (int i = 0; i < quotes.length; i++) {
            System.out.println((i + 1) + ". " + quotes[i]);
        }
    }
}

