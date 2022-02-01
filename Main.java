/*
 * The Popular Wordle game coded in java, can be played through command line.
 * Compilation: javac Main.java
 * Execution: java Main
 *
 * Coded by: Muskan
 * Date: 31-01-2022
 */

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Introduction text   
        System.out.println("Welcome to Wordle Java Command Line Version");
        System.out.println("*******************************************");
        System.out.println("How to play: \nWordle originally created by Josh Wardle, is a game where the player gets 6 chances to guess a 5-letter word, \nthe player can try guessing the word by trying different 5-letter words,\nwhen the player enters a guess, they will be given a hint about how close the word is to the game word. \n If the game word is: h e l l o \n and Player guesses h o l e s \nthe game will give the following hint \n h at 1 is at the right place\n l at 3 is at the right place\n e is not at the right place, but present in the game word\n o is not at the right place but present in the game word. \nJust like that keep guessing and remember you only get 6 chances.\n");
        
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
