package ProjectPhase1; // 📦 Package name – keeps all related classes organized together

import java.util.Scanner; // 🔢 Importing Scanner class for user input
public class DiaryApp {

    // --------------------------------------------------------
    // 🌼 Method that runs after successful login
    // --------------------------------------------------------
    public static void runDiaryApp(User currentUser) {
        Scanner sc = new Scanner(System.in); // 👩‍💻 Scanner for input
        Diary diary = new Diary(30); // 🗒️ Create a Diary object (max 30 entries)
        MoodTracker moodTracker = new MoodTracker(50); // 😊 Mood tracker with 50 moods
        ReminderManager reminderManager = new ReminderManager(); // ⏰ Manages reminders
        QuoteGenerator quoteGen = new QuoteGenerator(); // 💬 Handles motivational quotes
        FunZoneManager funZone = new FunZoneManager(); // 🎮 Mini games and fun section

        int choice; // 📍 Store user’s menu choice
        do {
            // 🏠 MAIN MENU DISPLAY
            System.out.println("\n🌸 === SMART DIARY MAIN MENU ===");
            System.out.println("1. Diary (Play Game + Add/View Entries)");
            System.out.println("2. Mood Tracker");
            System.out.println("3. Reminders");
            System.out.println("4. Motivational Quotes");
            System.out.println("5. Fun Zone 🎮");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");

            // ✅ Input validation (must be a number)
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number!");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            // 🎯 Perform action according to choice
            switch (choice) {
                case 1 -> diarySection(sc, diary); // go to diary section
                case 2 -> moodSection(sc, moodTracker); // go to mood tracker
                case 3 -> reminderSection(sc, reminderManager); // go to reminders
                case 4 -> quoteSection(sc, quoteGen); // go to quotes
                case 5 -> funZone.startFunZone(sc); // open fun zone (mini-games)
                case 6 -> System.out.println("Logging out... Bye, " + currentUser.getUsername() + "!");
                default -> System.out.println("Invalid choice!"); // invalid input
            }

        } while (choice != 6); // 🔁 Repeat until user logs out
    }

    // --------------------------------------------------------
    // 📖 Diary Section (play game → add/view entries)
    // --------------------------------------------------------
    private static void diarySection(Scanner sc, Diary diary) {
        int ch;
        do {
            // Display diary menu
            System.out.println("\n📖 === DIARY MENU ===");
            System.out.println("1. Play Level + Add Entry");
            System.out.println("2. View Entries");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            // Validate numeric input
            while (!sc.hasNextInt()) {
                System.out.println("Enter a valid number!");
                sc.next();
            }
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> {
                    // Determine next game level
                    int levelToPlay = diary.getCount() + 1;
                    if (levelToPlay > GameManager.ALL_LEVEL_DATA.length) {
                        // All levels finished
                        System.out.println("🎉 All levels complete!");
                    }
                    // Play level and if successful, allow diary entry
                    else if (GameManager.playLevel(levelToPlay, sc)) {
                        System.out.println("\n--- Add New Diary Entry ---");
                        System.out.print("Enter date (dd-MM-yyyy): ");
                        String date = sc.nextLine();
                        System.out.print("Enter title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter content: ");
                        String content = sc.nextLine();
                        // Create new entry and add to diary
                        diary.addEntry(new DiaryEntry(title, content, date));
                    }
                    else {
                        System.out.println("Level not completed — entry locked.");
                    }
                }
                case 2 -> diary.viewEntries(); // Show all entries
                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option!");
            }
        } while (ch != 3); // Loop until Back
    }

    // --------------------------------------------------------
    // 😊 Mood Tracker Section
    // --------------------------------------------------------
    private static void moodSection(Scanner sc, MoodTracker moodTracker) {
        int ch;
        do {
            System.out.println("\n😊 === MOOD TRACKER ===");
            System.out.println("1. Add Mood");
            System.out.println("2. View Moods");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Enter a valid number!");
                sc.next();
            }
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> {
                    // Ask user to type their mood
                    System.out.print("Enter your mood: ");
                    String mood = sc.nextLine();
                    moodTracker.addMood(mood); // Save it
                }
                case 2 -> moodTracker.viewMoods(); // Show mood list
                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option!");
            }
        } while (ch != 3);
    }

    // --------------------------------------------------------
    // ⏰ Reminder Section
    // --------------------------------------------------------
    private static void reminderSection(Scanner sc, ReminderManager rm) {
        int ch;
        do {
            System.out.println("\n⏰ === REMINDER MENU ===");
            System.out.println("1. Add Reminder");
            System.out.println("2. View Reminders");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Enter a valid number!");
                sc.next();
            }
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> rm.addReminder(); // Add new reminder
                case 2 -> rm.viewReminders(); // Show all reminders
                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option!");
            }
        } while (ch != 3);
    }

    // --------------------------------------------------------
    // 💬 Quotes Section
    // --------------------------------------------------------
    private static void quoteSection(Scanner sc, QuoteGenerator qg) {
        int ch;
        do {
            System.out.println("\n💬 === MOTIVATIONAL QUOTES ===");
            System.out.println("1. Show Random Quote");
            System.out.println("2. Show All Quotes");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Enter a valid number!");
                sc.next();
            }
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> qg.showRandomQuote(); // Display one random quote
                case 2 -> qg.showAllQuotes(); // Display all quotes
                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option!");
            }
        } while (ch != 3);
    }

    // --------------------------------------------------------
    // 🚀 Main method (handles login & registration)
    // --------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] users = new User[6]; // Array to store users (max 6)
        int userCount = 0;

        // 👑 Default admin accounts
        users[userCount++] = new AdminUser("Aleeza", "1234");
        users[userCount++] = new AdminUser("Zainab", "5678");

        System.out.println("🌟 === WELCOME TO SMART DIARY APP ===");
        while (true) {
            // Display login/register menu
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            // Validate number input
            while (!sc.hasNextInt()) {
                System.out.println("Enter a valid number!");
                sc.next();
            }
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                // ✨ Register new user
                case 1 -> {
                    if (userCount < users.length) {
                        System.out.print("Enter username: ");
                        String uname = sc.nextLine();
                        System.out.print("Enter password: ");
                        String pass = sc.nextLine();
                        users[userCount++] = new NormalUser(uname, pass);
                        System.out.println("✅ User registered successfully!");
                    } else {
                        System.out.println("User limit reached!");
                    }
                }

                // 🔑 Login existing user
                case 2 -> {
                    System.out.print("Username: ");
                    String u = sc.nextLine();
                    System.out.print("Password: ");
                    String p = sc.nextLine();
                    boolean found = false;

                    // Loop through users and check login
                    for (int i = 0; i < userCount; i++) {
                        if (users[i].login(u, p)) {
                            found = true;
                            // Check type of user and show greeting
                            if (users[i] instanceof AdminUser admin) admin.adminMessage();
                            else if (users[i] instanceof NormalUser normal) normal.userMessage();

                            // Run the main diary app
                            runDiaryApp(users[i]);
                            break;
                        }
                    }
                    if (!found) System.out.println("❌ Login failed!");
                }

                // 🚪 Exit the app
                case 3 -> {
                    System.out.println("👋 Exiting... Goodbye!");
                    return; // End program
                }

                default -> System.out.println("Invalid option!");
            }
        }
    }
}
