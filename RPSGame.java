import java.util.Scanner;

public class RPSGame{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Rock-Paper-Scissors!");
    System.out.print("Player 1, please make your choice: ");
    String player1 = keyboard.next();
    System.out.print("Player 2, please make your choice: ");
    String player2 = keyboard.next();

    int rock = 1;
    int paper = 2;
    int scissors = 3;
    int player1Choice = 0;
    int player2Choice = 5;

  if(player1.equals("r") || player1.equals("R") ){
		player1Choice = 1;}
	else if(player1.equals("p") || player1.equals("P")){
		player1Choice = 2;}
	else if(player1.equals("s") || player1.equals("S")){
		player1Choice = 3;}

  if(player2.equals("r") || player2.equals("R")){
  	player2Choice = 1;}
  else if(player2.equals("p") || player2.equals("P")){
  	player2Choice = 2;}
  else if(player2.equals("s") || player2.equals("S")){
  	player2Choice = 3;}

  if(player1Choice == rock && player2Choice == paper){
    System.out.println("Player 2 wins!");}
  else if(player1Choice == paper && player2Choice == rock){
    System.out.println("Player 1 wins!");}
  else if(player1Choice == scissors && player2Choice == rock){
    System.out.println("Player 2 wins!");}
  else if(player1Choice == rock && player2Choice == scissors){
    System.out.println("Player 1 wins!");}
  else if(player1Choice == scissors && player2Choice == paper){
    System.out.println("Player 1 wins!");}
  else if(player1Choice == paper && player2Choice == scissors){
    System.out.println("Player 2 wins!");}
  else if(player1Choice == player2Choice){
    System.out.println("Draw!");}
  else{
    System.out.println("That is not valid, please enter either R, P, or S!");}
  }
}

