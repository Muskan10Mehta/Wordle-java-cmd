/*
 * Class to initialize a new game. 
 * Compilation: javac StartNewGame.java
 * 
 * Coded by: Muskan
 * Date: 31-01-2022
 */

import java.util.*;

public class StartNewGame
{
    private String gameWord; // stores the random word selected as the correct word/ game word
    private int countOfTries = 0; // keeps the count of guesses player has entered so far
    private int numberOfGames = 0; // keeps count of number of games player has played so far
    private int numberOfWins = 0;  // keeps count of number of wins player has had so far
    private ArrayList<String> currentGuesses = new ArrayList<String>(6); // list of guesses player has made in a game

     /*
     * Method to initialize a new game, it gets the a random word as the game word and takes guess inputs from the player,
     * compares the guess inputs to the game word and keep counts of number of valid tries, number of games and number of wins for the current game session.
     */

    public void startNewGame()
    {
        String guess; // stores the current guess made by player
        boolean result = false; // stores the final result
      
        GameWord word = new GameWord();
        gameWord = word.getGameWord(); // returns a random word from the list of words in words.txt file
      
        numberOfGames++;

        while(countOfTries < 6) 
        {
            guess = getGuess(); // gets the current guess of player
          
            if(validGuess(guess))
            {
                countOfTries++;
                currentGuesses.add(guess);
                result = compareGuess(guess);

                if(result == true)
                {
                    System.out.println("You Win! Took you only " + countOfTries + " tries.\n");

                    printGrid(); // prints all guesses by the player
                    numberOfWins++;

                    break;

                } else
                {
                    printSimilar(guess); // prints the difference between the guess and the game word
                }

            } else
            {
                System.out.println("The word entered is invalid, please enter a 5-letter word in all lowercase letters");
            }
        }

        if(result == false)
        {
            System.out.println("\nYou lose. Try again! \nCorrect Answer is " + gameWord);
        }

        System.out.println("\nNumber Of games played : " + numberOfGames + "\n" + "Number of games won : " + numberOfWins+ "\n" );
    }
  
    /* 
     * This method take guess input from the player.
     *
     * Returns the input string guess
     */
  
    public String getGuess()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print('\n');
        System.out.println("Guess " + (countOfTries + 1));

        String guess = sc.next();

        return guess;
    }

    /* 
     * This method checks if the guess is valid or not, i.e all letters of input string are in lowercas, are of length 5 and all are alphabets.
     * Parameters: String guess (input string by the player)
     * Return boolean: true or false
     */
  
    public boolean validGuess(String guess)
    {
        boolean valid = false;

        if(guess.length() == 5)
        {
            valid = true;
            for(int i = 0; i < guess.length(); i++)
            {
                if(!((guess.charAt(i) >= 'a') && (guess.charAt(i) <= 'z')))
                {
                     valid = false;
                     break;
                }
            }
        }

        return valid;
    }
  
    /* 
     * This methods checks if the input string(guess) is same as the game word or not
     * Parameter: String guess (input string by the player)
     * Returns boolean: true or false
     */
  
    public boolean compareGuess(String guess)
    {
        return guess.equals(gameWord);
    }

    /*
     * This method prints all the words guessed by the player when the player wins i.e guesses the correct word
     */
    public void printGrid()
    {
        for(String s: currentGuesses)
        {
            System.out.println("----------");
            System.out.println(s);
            System.out.println("----------");
        }
    }
    
    /* 
     * This methods prints the similar characters between the input string(guess) to the game word i.e 
     * which characters are at the right place or which are present in the game word but not at the right place
     * 
     * Parameter: String Guess (input string by the player)
     */
   
    public void printSimilar(String guess)
    {
        HashSet<Character> distinctGuess = new HashSet<Character>(); // stores distinct characters from the guess string
        HashSet<Character> distinctGameWord = new HashSet<Character>(); // stores distinct characters from the guess string
        HashSet<Character> rightPlaceCharacter = new HashSet<Character>(); // stores characters that are already in the right place

        char[] guessCh = guess.toCharArray();
        char[] gameWordCh = gameWord.toCharArray();

        boolean similarity = false; // keeps a check of difference found or not

        // to check which characters are at the right place
        for(int i = 0; i < guess.length(); i++)
        {
            if(guess.charAt(i) == gameWord.charAt(i))
            {
                System.out.println(guess.charAt(i) + " at "+ (i + 1) + " place is at the right place.");
                rightPlaceCharacter.add(guess.charAt(i));

                similarity = true;
            }
        }


        // to check which characters are there, but not in the right place
        for(char c: guessCh)
            distinctGuess.add(c);

        for(char c: gameWordCh)
            distinctGameWord.add(c);

        Iterator<Character> i = distinctGuess.iterator();

        while(i.hasNext())
        {
            char c = i.next();
          
            // check for characters that are in the game word but not at the right place, ignore characters that are already in the right place
            if(distinctGameWord.contains(c) && (!(rightPlaceCharacter.contains(c))))
            {
                System.out.println(c + " is in the Game Word, but not in the right place.");
                similarity = true;
            }
        }
  
        // when the string is completely different
        if(similarity == false)
        {
            System.out.println("No characters match with the Game Word");
        }
    }



  

}
