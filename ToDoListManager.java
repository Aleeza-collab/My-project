package ProjectPhase1;

import java.util.Scanner;
import java.util.Arrays;


//this class allows users to manage a list of tasks

public class ToDoListManager{

    private final String [] tasks;
    private final boolean[]isComplete;
    private int taskCount;
    private final int MAX_TASKS;


    public ToDoListManager(int size){
        MAX_TASKS=size;
        tasks=new String[MAX_TASKS];
        isComplete=new boolean[MAX_TASKS];
        taskCount=0;
        Arrays.fill(isComplete,false); //initialize all tasks as incomplete
    }


    //this method adds a new task to the list

    public void addTask(Scanner input){
        if(taskCount < MAX_TASKS){
            System.out.print("Enter new task description: ");
            String task =input.nextLine().trim();
            if(task.isEmpty()){
                System.out.println("Task cannot be empty.");
                return;
            }

            tasks[taskCount]=task;
            isComplete[taskCount]=false;
            taskCount++;
            System.out.println("Task added: " + task);
        } else{
            System.out.println("To-Do list is full. Cannot add more tasks.");
        }
    }

    //this method displays all tasks and their status

    public void viewTasks(){
        System.out.println("\n=== Your To-Do List ===");
        if(taskCount==0){
            System.out.println("No tasks recorded yet. Time to add one!");
        } else {
            for(int i=0;i<taskCount;i++){
                String status=isComplete[i] ? "✅" : "❌";
                System.out.printf("%s %d. %s\n", status, (i + 1), tasks[i]);
            }
        }
    }

    //this method allows user to mark a task as complete
    public void markComplete(Scanner input) {
        if(taskCount==0) {
            System.out.println("No tasks to mark complete.");
            return;
        }

        viewTasks();
        System.out.print("\nEnter the number of the task to mark complete: ");

        // Input validation and processing
        if(input.hasNextInt()){
            int taskNumber=input.nextInt();
            input.nextLine();

            int index=taskNumber - 1;

            if(index>=0 && index<taskCount) {
                if(isComplete[index]){
                    System.out.println("Task is already marked complete.");
                }else{
                    isComplete[index]=true;
                    System.out.println("Task marked complete: " + tasks[index]);
                }
            }else{
                System.out.println("Invalid task number.");
            }
        } else{
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
        }
    }
}

