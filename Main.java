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
        File introduction = new File("rules.txt"); //opens file rules.txt
        Scanner reader = new Scanner(introduction);
        
        while(reader.hasNextLine())
        {
            String line = reader.nextLine();
            System.out.println(line);
        }
        reader.close();
        
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
