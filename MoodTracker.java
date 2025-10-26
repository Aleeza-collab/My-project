package ProjectPhase1;

// This class is to record and display the user's moods

public class MoodTracker {

    private String[] moods;    // Array to store user moods
    private int moodCount;     // Keeps track of total moods recorded

    // Constructor: Initializes array and counter
    public MoodTracker(int size) {
        moods = new String[size];
        moodCount = 0;
    }

    // This method adds a new mood to the array
    public void addMood(String mood) {
        if (moodCount < moods.length) {
            moods[moodCount] = mood;
            moodCount++;
            System.out.println("Mood added successfully!");
        } else {
            System.out.println("Mood list is full. Cannot add more moods.");
        }
    }

    // This method displays all recorded moods
    public void viewMoods() {
        System.out.println("\n=== Your Recorded Moods ===");
        if (moodCount == 0) {
            System.out.println("No moods recorded yet.");
        } else {
            for (int i = 0; i < moodCount; i++) {
                System.out.println((i + 1) + ". " + moods[i]);
            }
        }
    }
}

