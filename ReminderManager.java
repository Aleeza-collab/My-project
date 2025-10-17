package ProjectPhase1;
// ============================================
// Class: ReminderManager
// Purpose: To allow user to set and view reminders
// Note:    This version uses simple arrays (no file handling).
// ============================================
import java.util.Scanner;
public class ReminderManager {

    // Array to store reminders
    String[] reminders = new String[50]; // maximum 50 reminders
    String[] dates = new String[50];     // stores date or time info
    int reminderCount = 0;               // keeps track of how many reminders are added

    Scanner input = new Scanner(System.in);

    // ------------------------------
    // Method: addReminder()
    // Purpose: Allows user to add a new reminder
    // ------------------------------
    public void addReminder() {
        if (reminderCount < reminders.length) {
            System.out.print("\nEnter reminder date (e.g. 17 Oct 2025): ");
            dates[reminderCount] = input.nextLine();

            System.out.print("Enter reminder message: ");
            reminders[reminderCount] = input.nextLine();

            System.out.println("Reminder added successfully!");

            reminderCount++;
        } else {
            System.out.println("Reminder list is full! Cannot add more.");
        }

        // TODO (Deliverable 2): Save new reminder to file here.
    }

    // ------------------------------
    // Method: viewReminders()
    // Purpose: Displays all added reminders to the user
    // ------------------------------
    public void viewReminders() {
        if (reminderCount == 0) {
            System.out.println("\nNo reminders found!");
        } else {
            System.out.println("\n=== Your Reminders ===");
            for (int i = 0; i < reminderCount; i++) {
                System.out.println((i + 1) + ". [" + dates[i] + "] - " + reminders[i]);
            }
        }

        // TODO (Deliverable 2): Load reminders from file before displaying.
    }
}

