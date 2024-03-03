package com.github.zipcodewilmington.sample;

// Shaily Modi

import java.util.*;
import java.util.Scanner;

public class Wordguess
{
    public static void main(String[] args)
    {
        Wordguess game = new Wordguess();
        game.runGame();
    }
    public void runGame() {

        String[] word_list = {"cat", "dog", "bog", "cut", "ruby", "python", "java", "tootsie", "chairlift", "kittens",
                "computer", "complete" ,"geeks",  "for", "geeks", "a", "portal", "to", "learn", "can", "be", "computer",
                "science", "zoom", "yup", "fire", "in", "be", "data" };
        String rand_word;
        char[] hidden_word;
        //Create Scanner input
        Scanner input = new Scanner(System.in);
        String user_guess;
        int miss_chance;
        char[] missed;
        boolean letter_found = false, solved = false;

        while (true)
        {
            rand_word = "";
            user_guess = "";
            miss_chance = 0;
            rand_word = word_list[(int) (Math.random() * word_list.length)];
            hidden_word = new char[rand_word.length()];
            missed = new char[rand_word.length()];

            for (int i = 0; i < rand_word.length(); i++) {
                hidden_word[i] = '_';
            }

            while (miss_chance < rand_word.length()) {
                System.out.println("Let's Play Wordguess version 1.0");
                System.out.println("You have " + (rand_word.length() - miss_chance) + " turns left.");
                System.out.print("Word:\t " + "Enter a single letter");

                System.out.print("\nGuess: ");
                user_guess = input.next();
                letter_found = false;

                for (int i = 0; i < rand_word.length(); i++) {
                    if (user_guess.charAt(0) == rand_word.charAt(i)) {
                        hidden_word[i] = rand_word.charAt(i);
                        letter_found = true;
                    }
                }
                if (!letter_found) {
                    missed[miss_chance] = user_guess.charAt(0);
                }

                int hidden_count = 0;
                for (int i = 0; i < rand_word.length(); i++) {
                    if ('_' == hidden_word[i])
                        hidden_count++;
                }
                if (hidden_count > 0)
                    solved = false;
                else
                    solved = true;

                System.out.print("Word:\t");
                for (int i = 0; i < rand_word.length(); i++) {
                    System.out.print(hidden_word[i] + " ");
                }
                System.out.println();
                miss_chance++;
            }

            if (solved)
                System.out.println("You did it!");
            else
            {
                System.out.println("\nYou failed...The word was..." + rand_word + "\nGame Over");
                break;
            }

            System.out.println("Press 1 to continue playing or Press 2 to exit the game");

            String line = input.next();
            if ("2".equalsIgnoreCase(line)) {
                System.out.println("Goodbye...");
                break;
            }
            else if ("1".equalsIgnoreCase(line))
            {
                System.out.println("Let's play ...");
            }
        }

    }
}