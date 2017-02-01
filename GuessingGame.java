import java.util.*;

public class GuessingGame
{
	public ArrayList guesses = new ArrayList();
	public int numToGuess = new Random().nextInt(10);
	public void getGuess()
	{
		boolean loop = false;
		while(!loop)
		{
			try
			{
				Scanner keyboard = new Scanner(System.in);
				System.out.print("Enter your guess: ");
				int userGuess = keyboard.nextInt();
				guesses.add(userGuess);
				loop = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
			}
		}
	}
}