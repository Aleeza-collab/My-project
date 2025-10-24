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
        quotes = new String[30];
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
        quotes[10] = "Don’t watch the clock; do what it does. Keep going.";
        quotes[11] = "Success is not final, failure is not fatal: it is the courage to continue that counts.";
        quotes[12] = "Push yourself, because no one else is going to do it for you.";
        quotes[13] = "Small steps every day lead to big results.";
        quotes[14] = "You don’t have to be perfect to be amazing.";
        quotes[15] = "The harder you work for something, the greater you’ll feel when you achieve it.";
        quotes[16] = "Don’t stop until you’re proud.";
        quotes[17] = "Doubt kills more dreams than failure ever will.";
        quotes[18] = "Be stronger than your excuses.";
        quotes[19] = "It always seems impossible until it’s done.";
        quotes[20] = "Discipline is the bridge between goals and accomplishment.";
        quotes[21] = "Work in silence, let your success make the noise.";
        quotes[22] = "You were born to do great things.";
        quotes[23] = "Progress, not perfection.";
        quotes[24] = "Success doesn’t come from what you do occasionally, it comes from what you do consistently.";
        quotes[25] = "Your limitation—it’s only your imagination.";
        quotes[26] = "Wake up with determination, go to bed with satisfaction.";
        quotes[27] = "If it doesn’t challenge you, it won’t change you.";
        quotes[28] = "Don’t limit your challenges—challenge your limits.";
        quotes[29] = "Stay humble, work hard, be kind.";
    }
     // --------------------------------------------
     // Method: getRandomQuote
     // Purpose: Returns one random quote as String
     // --------------------------------------------
    public String getRandomQuote() {
    int index = random.nextInt(quotes.length);
    return quotes[index];
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


