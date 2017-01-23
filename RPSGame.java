import java.util.Scanner;

public class RPSGame{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Rock-Paper-Scissors!");
    System.out.print("Player 1, please make your choice: ");
    String player1 = keyboard.next();
    System.out.print("Player 2, make your choice: ");
    String player2 = keyboard.next();
    
    int rock = 1;
    int paper = 2;
    int scissors = 3;
    
    if(player1.equals("r") || player1.equals("R")){
		int player1Choice = 1;
		System.out.println(player1Choice);}
	else if(player1.equals("p") || player1.equals("P")){
		int player1Choice = 2;}
	else if(player1.equals("s") || player1.equals("s")){
		int player1Choice = 3;
    
	System.out.println(player1Choice);}
  }
}
