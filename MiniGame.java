package ProjectPhase1;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

// this file contains abstract base class 'MiniGame' and three mini-games that extend it: GuessGame, TriviaGame, JokeGame

public abstract class MiniGame {
    // abstract method must be implemented by every game

    public abstract void playGame(Scanner input);
}

// Guess Game
class GuessGame extends MiniGame {
    @Override
    public void playGame(Scanner input) {
        Random rand = new Random();
        int number = rand.nextInt(10) + 1;  // Random number between 1–10

        System.out.println("Guess the number between 1 and 10!");
        System.out.print("Enter your guess: ");
        int guess = input.nextInt();

        if (guess == number) {
            System.out.println("Correct! You guessed it!");
        } else {
            System.out.println("Oops! The number was " + number);
        }
    }
}

// Trivia Game
class TriviaGame extends MiniGame {
    @Override
    public void playGame(Scanner input) {
        System.out.println("Trivia Time!");

        String[] questions = {
                "What is the capital of France?",
                "Who developed the Java programming language?",
                "What is 5 + 3?",
                "Which planet is known as the Red Planet?",
                "Who painted the Mona Lisa?",
                "Which language runs in a web browser?",
                "What is the national animal of Pakistan?",
                "Who wrote 'Romeo and Juliet'?",
                "What is H2O commonly known as?",
                "What is the largest ocean on Earth?",
                "Which company developed the Windows OS?",
                "In programming, what does 'OOP' stand for?",
                "Who was the first person to walk on the Moon?",
                "Which data type is used to store text in Java?",
                "What symbol is used for comments in Java?",
                "What is the shortcut for 'Copy' on Windows?",
                "Which planet has the most moons?",
                "What is the chemical symbol for Gold?",
                "Which keyword is used to create a subclass in Java?",
                "What device is used to measure temperature?",
                "Which animal is known as the 'Ship of the Desert'?",
                "What is the smallest prime number?",
                "Which continent is the Sahara Desert located on?",
                "Which company created the iPhone?",
                "What is the value of Pi (approx)?",
                "Who invented the light bulb?",
                "Which file extension is used for Java source files?",
                "What is the national flower of Pakistan?",
                "Which gas do humans exhale?",
                "Which country is famous for the Great Wall?"
        };

        String[][] options = {
                {"Paris", "Rome", "Berlin", "Madrid"},
                {"James Gosling", "Guido van Rossum", "Dennis Ritchie", "Bjarne Stroustrup"},
                {"6", "7", "8", "9"},
                {"Earth", "Mars", "Jupiter", "Venus"},
                {"Van Gogh", "Leonardo da Vinci", "Picasso", "Rembrandt"},
                {"Python", "C++", "JavaScript", "Kotlin"},
                {"Markhor", "Lion", "Eagle", "Tiger"},
                {"Shakespeare", "Charles Dickens", "Jane Austen", "Tolstoy"},
                {"Salt", "Water", "Oxygen", "Hydrogen"},
                {"Atlantic", "Indian", "Pacific", "Arctic"},
                {"Microsoft", "Apple", "IBM", "Google"},
                {"Object Oriented Programming", "Output Oriented Program", "Online Office Process", "Object Order Plan"},
                {"Neil Armstrong", "Yuri Gagarin", "Buzz Aldrin", "Michael Collins"},
                {"String", "int", "char", "boolean"},
                {"//", "/* */", "#", "!--"},
                {"Ctrl + X", "Ctrl + C", "Ctrl + V", "Ctrl + Z"},
                {"Saturn", "Jupiter", "Mars", "Neptune"},
                {"G", "Ag", "Au", "Go"},
                {"extends", "inherit", "super", "class"},
                {"Thermometer", "Barometer", "Hygrometer", "Speedometer"},
                {"Horse", "Camel", "Elephant", "Cow"},
                {"0", "1", "2", "3"},
                {"Asia", "Africa", "Europe", "Australia"},
                {"Apple", "Samsung", "Google", "Nokia"},
                {"3.14", "2.71", "1.61", "4.00"},
                {"Edison", "Newton", "Tesla", "Einstein"},
                {".class", ".java", ".exe", ".jar"},
                {"Rose", "Jasmine", "Lily", "Sunflower"},
                {"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"},
                {"Japan", "China", "India", "Korea"}
        };

        String[] correctAnswers = {
                "Paris", "James Gosling", "8", "Mars", "Leonardo da Vinci",
                "JavaScript", "Markhor", "Shakespeare", "Water", "Pacific",
                "Microsoft", "Object Oriented Programming", "Neil Armstrong", "String", "//",
                "Ctrl + C", "Saturn", "Au", "extends", "Thermometer",
                "Camel", "2", "Africa", "Apple", "3.14", "Edison", ".java", "Jasmine", "Carbon Dioxide", "China"
        };

        Random rand = new Random();
        int index = rand.nextInt(questions.length);

        System.out.println("Question: " + questions[index]);
        System.out.println("A) " + options[index][0] + "  B) " + options[index][1]);
        System.out.println("C) " + options[index][2] + "  D) " + options[index][3]);

        System.out.print("Your answer: ");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase(correctAnswers[index]) ||
                (answer.equalsIgnoreCase("A") && options[index][0].equalsIgnoreCase(correctAnswers[index])) ||
                (answer.equalsIgnoreCase("B") && options[index][1].equalsIgnoreCase(correctAnswers[index])) ||
                (answer.equalsIgnoreCase("C") && options[index][2].equalsIgnoreCase(correctAnswers[index])) ||
                (answer.equalsIgnoreCase("D") && options[index][3].equalsIgnoreCase(correctAnswers[index]))) {
            System.out.println("Correct! Well done!");
        } else {
            System.out.println("Wrong! The correct answer is " + correctAnswers[index] + ".");
        }
    }
}


//Joke Game

class JokeGame extends MiniGame {
    @Override
    public void playGame(Scanner input) {
        String[] jokes = {
                "💻 Why don't programmers like nature? It has too many bugs!",
                "🖥️ Why did the computer go to therapy? It had a hard drive!",
                "☕ Why do Java developers wear glasses? Because they can't C#!",
                "🐍 Why was the Python developer lonely? Because he was stuck in his shell!",
                "😂 Parallel lines have so much in common... It’s a shame they’ll never meet.",
                "📱 I told my phone it was being slow. It just hung up on me.",
                "👾 Why did the programmer quit his job? Because he didn’t get arrays!",
                "🤖 What do you call a robot that takes the long route? R2-detour!",
                "💡 How many programmers does it take to change a light bulb? None, that’s a hardware issue!",
                "🐛 Debugging: being the detective in a crime movie where you are also the murderer.",
                "🎮 Why did the gamer bring a broom? To sweep the competition!",
                "🧠 Artificial intelligence is no match for natural stupidity.",
                "🎓 Why was the math book sad? It had too many problems.",
                "🖨️ My printer is playing hide and seek… it’s still on ‘finding device’.",
                "📶 Why did the Wi-Fi break up with the router? Bad connection.",
                "💾 There are only 10 types of people in the world: those who understand binary and those who don’t.",
                "🧃 I would tell you a UDP joke… but you might not get it.",
                "🚀 Why don’t astronauts use Java? Too many exceptions in space.",
                "📊 Why do data analysts love nature? Because it’s full of natural logs.",
                "🧩 I told my computer I needed a break — it said 'You seem stressed. Would you like to close some tabs?'",
                "🎤 Why was the JavaScript developer sad? Because he didn’t know how to 'null' his feelings.",
                "🧃 Why was the function always calm? Because it had no arguments.",
                "🎬 In object-oriented programming, all life is a class struggle.",
                "🎩 I told my computer a joke… but it didn’t laugh. It just gave me a runtime error.",
                "💻 My computer science teacher told me to make a program that says 'Hello World!'... so I wrote 400 lines of code.",
                "🎯 Why did the developer get stuck in the shower? The instructions on the shampoo bottle said: Lather, Rinse, Repeat.",
                "🧀 Why do programmers prefer dark mode? Because light attracts bugs!",
                "⚡ I asked the compiler to go on a date. It said, 'I’m already linked!'",
                "🧩 Why was the developer broke? Because he used up all his cache.",
                "🕵️♂️ What’s a hacker’s favorite season? Phishing season!"
        };

        Random rand = new Random();
        int index = rand.nextInt(jokes.length);

        System.out.println("Here's a joke for you:");
        System.out.println(jokes[index]);
    }
}
