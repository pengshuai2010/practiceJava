package practiceJava;
import java.util.Scanner;
public class Quotient {
	public static void main(String[] args){
		int a;
		int b;
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		do{
			try {
				a = input.nextInt();
				b = input.nextInt();
				System.out.println(quotient(a, b));
				continueInput = false;
			}
			catch (ArithmeticException ex) {
				System.out.println(ex.getMessage());
				System.out.println("please re-input:");
			}
		}while(continueInput);
		System.out.println("continue executing...");
	}
	public static int quotient(int a, int b) throws ArithmeticException{
		if(b == 0){
			throw new ArithmeticException("divisor cannot be zero");
		}
		return a/b;
	}

}
