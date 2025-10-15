package ProjectPhase1;
import java.util.Scanner;

// ================= MAIN APPLICATION =================
public class DiaryApp {

    // Menu after login
    public static void runDiaryApp(User currentUser) {
        Scanner sc = new Scanner(System.in);
        Diary diary = new Diary(30); // 30 levels = 30 entries
        int choice=0;

        do {
            System.out.println("\n=== Diary Menu ===");
            System.out.println("1. Add Entry (after winning game)");
            System.out.println("2. View Entries");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    int levelToPlay = diary.getCount() + 1;
                    if (levelToPlay > GameManager.ALL_LEVEL_DATA.length) {
                        System.out.println("All levels complete!");
                    } else if (GameManager.playLevel(levelToPlay, sc)) {
                        System.out.println("\n--- Add New Diary Entry ---");
                        System.out.print("Enter date: ");
                        String date = sc.nextLine();
                        System.out.print("Enter title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter content: ");
                        String content = sc.nextLine();
                        diary.addEntry(new DiaryEntry(content, title, date));
                    } else {
                        System.out.println("Level not completed — entry locked.");
                    }
                }
                case 2 -> diary.viewEntries();
                case 3 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 3);
    }

    // ======= MAIN METHOD =======
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] users = new User[6];
        int userCount = 0;

        // Default admins
        users[userCount++] = new AdminUser("Aleeza", "1234");
        users[userCount++] = new AdminUser("Zainab", "5678");

        System.out.println("=== Smart Diary App ===");
        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            if (!sc.hasNextInt()) {
                System.out.println("Enter a valid number!");
                sc.next();
                continue;
            }
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
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
                case 2 -> {
                    System.out.print("Username: ");
                    String u = sc.nextLine();
                    System.out.print("Password: ");
                    String p = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < userCount; i++) {
                        if (users[i].login(u, p)) {
                            found = true;
                            if (users[i] instanceof AdminUser admin) admin.adminMessage();
                            else if (users[i] instanceof NormalUser normal) normal.userMessage();
                            runDiaryApp(users[i]);
                            break;
                        }
                    }
                    if (!found) System.out.println("Login failed!");
                }
                case 3 -> {
                    System.out.println("Exiting... Bye!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}

