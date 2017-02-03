import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
The 'for' loop in the GuessingGameTest.java file acts as the outer loop. Inside the getGuess 
method is a 'while' loop, which acts as the inner loop. The 'for' loop calls the method in the 
GuessingGame.java file called getGuess that contains a 'while' loop which is why it is a 
nested loop.
*/

public class GuessingGame {
    public int numToGuess = new Random().nextInt(10);
    public ArrayList<String> guesses = new ArrayList<String>();
    
    public void getGuess() { // this method gets guesses from the user
        System.out.print("What is your guess? ");
        Scanner keyboard = new Scanner(System.in);
        
        boolean validGuess = false;
        while (!validGuess) { //this loop checks for valid input and adds it to the ArrayList "guesses"
            String userGuess = keyboard.nextLine();
            
            try { // makes sure input is an integer
                int numGuess = Integer.parseInt(userGuess);
                if (numGuess >= 10 || numGuess <= -1) { // makes sure input is between 0 and 9
                    System.out.print("That is invalid, enter a number between 0 and 9: ");
                }
                else {
                    validGuess = true;
                    guesses.add(userGuess); // add guess to the ArrayList "guesses"
                }
            }
            catch (NumberFormatException e) {
                System.out.print("That is invalid, enter an integer: ");
            }
        }
    }
    public void printGuesses() { // this method prints the contents of the guesses ArrayList
        System.out.print("Your guesses: ");
        int size = guesses.size();
        for (int listPostition = 0; listPostition < size; listPostition++) {
            System.out.print(guesses.get(listPostition) + " ");
        }
    }
	
	public boolean checkLastGuess() {
		String lastGuessString = guesses.get(guesses.size() - 1);
		int lastGuess = Integer.parseInt(lastGuessString);
		
		if(lastGuess > numToGuess){
			System.out.println("Guess is too high.");
			return false;
		}
		else if(lastGuess < numToGuess){
			System.out.println("Guess is too low.");
			return false;
		}
		else if(lastGuess == numToGuess){
			System.out.println("Correct.");
		}
		return true;
	}
}