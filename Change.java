import java.util.Scanner;

public class Change{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("How much change is needed: ");
		int change = keyboard.nextInt();
		
		int twoonies = (change / 200);
		int remainderTwoonies = (change % 200);
		int loonies = (remainderTwoonies / 100);
		int remainderLoonies = (remainderTwoonies % 100);
		int quarters = (remainderLoonies / 25);
		int remainderQuarters = (remainderLoonies % 25);
		int dimes = (remainderQuarters / 10);
		int remainderDimes = (remainderQuarters % 10);
		int nickles = (remainderDimes / 5);
		int remainderNickles = (remainderDimes % 5);
		
		System.out.println("Twoonies: " + twoonies);
		System.out.println("Loonies: " + loonies);
		System.out.println("Quarters: " + quarters);
		System.out.println("Dimes: " + dimes);
		System.out.println("Nickels: " + nickles);
		System.out.println("Pennies: " + remainderNickles);
	}
}
