import java.util.Scanner;

public class Converter{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("What is the amount? ");
    double amount = keyboard.nextDouble();
    System.out.print("Is that in USD (U) or CAD (C)? ");
    String currencyType = keyboard.next();

    if(currencyType.equals("C") || currencyType.equals("c")){
      double val_USD = (amount / 1.33);
      int newUSD = (int) val_USD;
      System.out.printf("That is " + newUSD + " USD.");}
    else if(currencyType.equals("U") || currencyType.equals("u")){
      double val_CAD = (amount * 1.33);
      int newCAD = (int) val_CAD;
      System.out.println("That is "+ newCAD + " CAD.");}
    else{
      System.out.println("That is not valid, please enter either U or C.");}
  }
}
