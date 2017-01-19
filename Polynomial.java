import java.util.Scanner;

public class Polynomial{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter a value for x: ");
    Double value = keyboard.nextDouble();
    Double x1 = Math.pow(value, 2);
    Double x2 = (2-x1);
    Double x3 = (x2 * (3+value));
    Double x4 = Math.pow(x3, 2);
    Integer x = x4.intValue();

    System.out.println("((2-x^2)*(3+x))^2 = " + x);
  }
}
