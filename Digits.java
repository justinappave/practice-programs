import java.util.Scanner;

public class Digits{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a five digit number: ");
		String number = keyboard.next();
		
		for(char ch:number.toCharArray()){
			System.out.println(ch);
		}
	}
}
