package ProjectPhase1;

import java.util.Scanner;
import java.util.Arrays; // Needed for Arrays.fill


//To allow users to manage a list of tasks (To-Dos).

public class ToDoListManager {

    private final String[] tasks;     // Array to store task descriptions
    private final boolean[] isComplete; // Array to store completion status
    private int taskCount;            // Keeps track of the number of active tasks
    private final int MAX_TASKS;


    public ToDoListManager(int size) {
        MAX_TASKS = size;
        tasks = new String[MAX_TASKS];
        isComplete = new boolean[MAX_TASKS];
        taskCount = 0;
        Arrays.fill(isComplete, false); //initialize all tasks as incomplete
    }


    //Adds a new task to the list

    public void addTask(Scanner input) {
        if (taskCount < MAX_TASKS) {
            System.out.print("Enter new task description: ");
            String task = input.nextLine().trim();
            if (task.isEmpty()) {
                System.out.println("⚠️ Task cannot be empty.");
                return;
            }

            tasks[taskCount] = task;
            isComplete[taskCount] = false; // Ensure it's marked false
            taskCount++;
            System.out.println("✅ Task added: " + task);
        } else {
            System.out.println("⚠️ To-Do list is full. Cannot add more tasks.");
        }
    }

    //Displays all tasks and their status

    public void viewTasks() {
        System.out.println("\n=== Your To-Do List ===");
        if (taskCount == 0) {
            System.out.println("No tasks recorded yet. Time to add one!");
        } else {
            for (int i = 0; i < taskCount; i++) {
                String status = isComplete[i] ? "✅" : "❌";
                // Display (index + 1) for user-friendly numbering
                System.out.printf("%s %d. %s\n", status, (i + 1), tasks[i]);
            }
        }
    }


    //Allows user to mark a task as complete

    public void markComplete(Scanner input) {
        if (taskCount == 0) {
            System.out.println("No tasks to mark complete.");
            return;
        }

        viewTasks();
        System.out.print("\nEnter the number of the task to mark complete: ");

        // Input validation and processing
        if (input.hasNextInt()) {
            int taskNumber = input.nextInt();
            input.nextLine(); // consume newline

            int index = taskNumber - 1;

            if (index >= 0 && index < taskCount) {
                if (isComplete[index]) {
                    System.out.println("⚠️ Task is already marked complete.");
                } else {
                    isComplete[index] = true;
                    System.out.println("🥳 Task marked complete: " + tasks[index]);
                }
            } else {
                System.out.println("❌ Invalid task number.");
            }
        } else {
            System.out.println("❌ Invalid input. Please enter a number.");
            input.nextLine(); // consume invalid input
        }
    }
}
