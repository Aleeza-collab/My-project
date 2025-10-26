package ProjectPhase1; // package keeps all related classes organized together

import java.util.Scanner; // importing Scanner class for user input
public class FinalDiaryApp {

    //  method that runs after successful login
    public static void runDiaryApp(User currentUser) {
        Scanner sc = new Scanner(System.in);
        Diary diary=new Diary(30);
        MoodTracker moodTracker = new MoodTracker(50);
        ReminderManager reminderManager = new ReminderManager();
        QuoteGenerator quoteGen = new QuoteGenerator();
        FunZoneManager funZone = new FunZoneManager();
        ToDoListManager todoManager=new ToDoListManager(50);

        int choice;
        do {
            System.out.println("\n=== SMART DIARY MAIN MENU ===");
            System.out.println("1.Diary (Play Game + Add/View Entries)");
            System.out.println("2.Mood Tracker");
            System.out.println("3.Reminders");
            System.out.println("4.Motivational Quotes");
            System.out.println("5.Fun Zone");
            System.out.println("6.To-Do List");
            System.out.println("7.Logout");
            System.out.print("Choose an option: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number!");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> diarySection(sc, diary);
                case 2 -> moodSection(sc, moodTracker);
                case 3 -> reminderSection(sc, reminderManager);
                case 4 -> quoteSection(sc, quoteGen);
                case 5 -> funZone.startFunZone(sc);
                case 6 -> todoSection(sc, todoManager);
                case 7 -> System.out.println("Logging out... Bye, " + currentUser.getUsername() + "!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    // Diary Section (play game to add/view entries)
    private static void diarySection(Scanner sc,Diary diary){
        int ch;
        do{
            System.out.println("\n=== DIARY MENU ===");
            System.out.println("1.Play Level + Add Entry");
            System.out.println("2.View Entries");
            System.out.println("3.Back");
            System.out.print("Enter choice: ");

            while(!sc.hasNextInt()){
                System.out.println("Enter a valid number!");
                sc.next();
            }
            ch=sc.nextInt();
            sc.nextLine();

            switch(ch){
                case 1 ->{
                    int levelToPlay=diary.getCount() + 1;
                    if (levelToPlay>GameManager.ALL_LEVEL_DATA.length) {
                        System.out.println("All levels complete!");
                    }
                    // Play level and if successful, allow diary entry
                    else if (GameManager.playLevel(levelToPlay, sc)) {
                        System.out.println("\n--- Add New Diary Entry ---");
                        System.out.print("Enter date (dd-MM-yyyy): ");
                        String date=sc.nextLine();
                        System.out.print("Enter title: ");
                        String title=sc.nextLine();
                        System.out.print("Enter content: ");
                        String content=sc.nextLine();
                        // Create new entry and add to diary
                        diary.addEntry(new DiaryEntry(title,content,date));
                    }
                    else {
                        System.out.println("Level not completed — entry locked.");
                    }
                }
                case 2 -> diary.viewEntries(); // Show all entries
                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option!");
            }
        } while (ch!=3);
    }

    //  To-Do List Section
    private static void todoSection(Scanner sc,ToDoListManager todoManager) {
        int ch;
        do {
            System.out.println("\n=== TO-DO LIST MENU ===");
            System.out.println("1.Add New Task");
            System.out.println("2.View All Tasks");
            System.out.println("3.Mark Task as Complete");
            System.out.println("4.Back");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Enter a valid number!");
                sc.next();
            }
            ch=sc.nextInt();
            sc.nextLine();

            switch(ch){
                case 1 -> todoManager.addTask(sc);
                case 2 -> todoManager.viewTasks();
                case 3 -> todoManager.markComplete(sc);
                case 4 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option!");
            }
        }while(ch!=4);
    }

    // Mood Tracker Section
    private static void moodSection(Scanner sc,MoodTracker moodTracker) {
        int ch;
        do {
            System.out.println("\n=== MOOD TRACKER ===");
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
                    System.out.print("Enter your mood: ");
                    String mood = sc.nextLine();
                    moodTracker.addMood(mood);
                }
                case 2 -> moodTracker.viewMoods();
                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option!");
            }
        } while (ch != 3);
    }

    // Reminder Section
    private static void reminderSection(Scanner sc, ReminderManager rm) {
        int ch;
        do {
            System.out.println("\n=== REMINDER MENU ===");
            System.out.println("1. Add Reminder");
            System.out.println("2. View Reminders");
            System.out.println("3. Back");
            System.out.println("4. Delete Reminder");
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


    // Quotes Section
    private static void quoteSection(Scanner sc, QuoteGenerator qg) {
        int ch;
        do {
            System.out.println("\n=== MOTIVATIONAL QUOTES ===");
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

    //Main method (handles login & registration)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] users = new User[30]; // Array to store users (max 30)
        int userCount = 0;

        // Default admin accounts
        users[userCount++] = new AdminUser("Aleeza", "1234");
        users[userCount++] = new AdminUser("Zainab", "5678");

        System.out.println("=== WELCOME TO SMART DIARY APP ===");

        int option = 0;
        while (option != 3) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            while (!sc.hasNextInt()) {
                System.out.print("Error.Enter a valid number: ");
                sc.next();
            }
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                // Register new user
                case 1 -> {
                    if (userCount < users.length) {
                        System.out.print("Enter username: ");
                        String uname = sc.nextLine();
                        System.out.print("Enter password: ");
                        String pass = sc.nextLine();
                        users[userCount++] = new NormalUser(uname, pass);
                        System.out.println("User registered successfully!");
                    } else {
                        System.out.println("User limit reached!");
                    }
                }

                // login existing user
                case 2 -> {
                    System.out.print("Username: ");
                    String u =sc.nextLine();
                    System.out.print("Password: ");
                    String p= sc.nextLine();
                    boolean found = false;

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
                    if (!found) System.out.println("Login failed!");
                }
                case 3 -> {
                    System.out.println(" Exiting... Goodbye!");
                }

                default -> System.out.println("Invalid option!");
            }
        }
    }
}

