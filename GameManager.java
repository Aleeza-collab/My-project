package ProjectPhase1;
import java.util.Scanner;

// ================= GAME MANAGER CLASS =================
public class GameManager {

    // All level data (letters + valid words)
    protected static final String[][] ALL_LEVEL_DATA = {
            {"SERU", "sure", "sue", "use", "rue", "user"},
            {"SLTA", "salt", "last", "sat", "at"},
            {"ITDE", "tide", "tie", "diet", "edit", "tied", "die"},
            {"ASLNO", "also", "son", "loan", "loans", "salon"},
            {"EMRST", "terms", "term", "stem", "rest", "set", "met"},
            {"KLCAB", "black", "lack", "back", "lab", "cab"},
            {"ELAD", "deal", "lead", "led", "lad", "ale"},
            {"SOWNK", "know", "knows", "own", "son", "now", "snow", "won", "owns"},
            {"ERLA", "real", "earl", "ear", "are", "ale"},
            {"DSKAE", "ask", "asked", "ads", "desk", "sake", "sad", "sea"},
            {"VERNE", "never", "ever", "nerve", "even", "eve"},
            {"ETAB", "beat", "eat", "bat", "tab", "beta", "bet", "ate"},
            {"NOTO", "onto", "ton", "not", "too", "to"},
            {"ZIESD", "side", "die", "dies", "sized", "size"},
            {"MYETP", "empty", "yet", "pet", "met", "type", "temp"},
            {"GEMA", "mega", "game", "age", "meg", "gem"},
            {"EMTI", "item", "met", "tie", "time", "emit"},
            {"HERET", "thee", "three", "tree", "the", "tee", "her", "here", "there"},
            {"ELVOS", "love", "loves", "lose", "solve", "sole"},
            {"RNTEE", "enter", "net", "ten", "tree", "teen", "rent", "tee"},
            {"TEWS", "stew", "set", "west", "wet", "sew"},
            {"ETADD", "date", "dated", "eat", "ate", "tea", "add", "dad"},
            {"EEHST", "sheet", "tee", "the", "set", "these", "she", "see", "thee"},
            {"EIDDR", "red", "die", "dried", "ride", "rid", "did", "died"},
            {"PTSO", "top", "stop", "spot", "tops", "post", "pot", "opt"},
            {"SIHTR", "shirt", "his", "hit", "sit", "sir", "stir", "this", "its", "hits"},
            {"WNOT", "own", "tow", "won", "not", "town", "ton", "now", "two"},
            {"HKASE", "shake", "ash", "ask", "sake", "sea", "she", "has"},
            {"OUTHC", "thou", "touch", "hut", "hot", "out", "cut"},
            {"DENDE", "end", "ended", "den", "need", "deed"}

    };

    // ======= Inner Level Class =======
    protected static class Level {
        private final String availableLetters;
        private final String[] targetWords;
        private final boolean[] foundStatus;

        public Level(String letters, String[] words) {
            this.availableLetters = letters.toUpperCase();
            this.targetWords = words;
            this.foundStatus = new boolean[words.length];
        }

        // Check if user-entered word is correct
        public int checkWord(String word) {
            String upperWord = word.toUpperCase();

            if (!isValidComposition(upperWord))
                return 3;

            for (int i = 0; i < targetWords.length; i++) {
                if (targetWords[i].toUpperCase().equals(upperWord)) {
                    if (foundStatus[i]) return 1;
                    foundStatus[i] = true;
                    return 0;
                }
            }
            return 2;
        }

        // Check valid letter usage
        private boolean isValidComposition(String word) {
            int[] available = getLetterCounts(availableLetters);
            int[] used = getLetterCounts(word);
            for (int i = 0; i < 26; i++) {
                if (used[i] > available[i]) return false;
            }
            return true;
        }

        private int[] getLetterCounts(String word) {
            int[] counts = new int[26];
            for (char c : word.toCharArray())
                if (c >= 'A' && c <= 'Z') counts[c - 'A']++;
            return counts;
        }

        public int getFoundCount() {
            int count = 0;
            for (boolean f : foundStatus) if (f) count++;
            return count;
        }

        public int getTotalCount() {
            return targetWords.length;
        }

        public boolean isComplete() {
            return getFoundCount() == targetWords.length;
        }

        public void displayLetters() {
            System.out.print("Available Letters: ");
            for (char c : availableLetters.toCharArray())
                System.out.print("[" + c + "] ");
            System.out.println();
        }

        public void displayProgress(int levelNum) {
            System.out.println("\n--- Level " + levelNum + " Progress ---");
            for (int i = 0; i < targetWords.length; i++) {
                String word = targetWords[i].toUpperCase();
                if (foundStatus[i]) System.out.print("[" + word + "] ");
                else System.out.print("[" + "_".repeat(word.length()) + "] ");
            }
            System.out.println("\n--------------------------\n");
        }
    }

    // Run one game level
    public static boolean playLevel(int levelIndex, Scanner sc) {
        if (levelIndex < 1 || levelIndex > ALL_LEVEL_DATA.length) return true;

        String[] data = ALL_LEVEL_DATA[levelIndex - 1];
        String letters = data[0];
        String[] words = new String[data.length - 1];
        for (int i = 0; i < words.length; i++) words[i] = data[i + 1];

        Level current = new Level(letters, words);

        while (true) {
            current.displayProgress(levelIndex);
            current.displayLetters();
            System.out.printf("Level %d | Words Found: %d / %d\n",
                    levelIndex, current.getFoundCount(), current.getTotalCount());
            System.out.println("\nEnter a word, or 'BACK' to exit this level.");
            System.out.print("Your word > ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("BACK")) {
                System.out.println("Returning to Diary Menu...");
                return false;
            }

            int result = current.checkWord(input);

            switch (result) {
                case 0 -> {
                    System.out.println("✅ Correct word: " + input);
                    if (current.isComplete()) {
                        System.out.println("*** LEVEL COMPLETE! ***");
                        return true;
                    }
                }
                case 1 -> System.out.println("⚠️ Already found that word!");
                case 2 -> System.out.println("❌ Not a target word.");
                case 3 -> System.out.println("🚫 Invalid letters used!");
            }
        }
    }
}

