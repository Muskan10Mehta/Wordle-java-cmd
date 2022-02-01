/*
 * Class to return a random word from the list of words in words.txt file
 * Compilation: javac GameWord.java
 * 
 * Coded by : Muskan
 * Date: 01-02-2022
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class GameWord
{
    public String getGameWord()
    {
        int min = 0;
        int max = 0;
        int randomIndex = 0;

        ArrayList<String> allWords = new ArrayList<String>(); // list to store all the words from the words.txt file

        try
        {
            File words = new File("words.txt"); //open words.txt file
            Scanner reader = new Scanner(words);

            while(reader.hasNextLine())
            {
                String word = reader.nextLine();
                allWords.add(word);  // add the words to allWords list
            }

            reader.close();

        } catch(FileNotFoundException e)
        {
            System.out.println("An error occurred. Please try again.");
            System.exit(1);
        }

        // generating a random index number
        min = 0;
        max = allWords.size() - 1;
        randomIndex = (int) ( Math.random() * (max - min + 1) + min);

        // return the word at the random index
        return allWords.get(randomIndex);
    }
}
