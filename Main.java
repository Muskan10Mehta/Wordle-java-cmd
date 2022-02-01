/*
 * The Popular Wordle game coded in java, can be played through command line.
 * Compilation: javac Main.java
 * Execution: java Main
 *
 * Coded by: Muskan
 * Date: 31-01-2022
 */

import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        // Introduction text   
        try
        {
            File introduction = new File("rules.txt"); //opens file rules.txt
            Scanner reader = new Scanner(introduction);

            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
            
        } catch(FileNotFoundException e)
        {
            System.out.println("Welcome to Wordle Java Command Line Version");
            System.out.println("*******************************************\n");
            System.out.println("How to play: \nWordle originally created by Josh Wardle, is a game where the player gets 6 chances to guess a 5-letter word,\nthe player can try guessing the word by trying different 5-letter words,\nwhen the player enters a guess, they will be given a hint about how close the word is to the game word. \nIf the game word is: h e l l o \nand Player guesses h o l e s \nthe game will give the following hint \nh at 1 is at the right place\nl at 3 is at the right place\ne is not at the right place, but present in the game word\no is not at the right place but present in the game word. \nJust like that keep guessing and remember you only get 6 chances.\nPlease enter all words in lowercase and they should be a 5-letter word. Enjoy!");
        }

        Scanner sc = new Scanner(System.in);

        int choice = 0;

        while(true)
        {
            // initial choice 
            System.out.println("Enter choice: \n 1 -> Start new Game \n 2 -> Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: StartNewGame game = new StartNewGame(); // start new game class object
                        game.startNewGame(); // initializes a new game
                        break;
                        
                case 2: System.exit(1);
                        break;
            }
        }
    }
}
~
