package practiceJava;
import java.util.Arrays;
import java.io.PrintWriter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class HelloWorld {

	public static void main(String[] args) throws Exception{
		String s1 = "Hello World";
		System.out.println(s1.charAt(0));
		System.out.println(s1.substring(0, 5));
		String[] strArray = s1.split(" ");
		for(int i = 0; i < strArray.length; i++){
			System.out.println(strArray[i]);
		}
		
		String s2 = "aaaaab";
		String pat = "a+b";
		Pattern pattern = Pattern.compile(pat);
		Matcher m = pattern.matcher(s2);
		System.out.println("matches():\t" + m.matches());
		System.out.println("start():\t" + m.start());
		System.out.println("end():\t" + m.end());
		
		System.out.println(String.valueOf(Math.PI));
		System.out.println(String.format("my name is %s, I'm %d years old", "ps", 25));
		
		System.out.println(Math.sin(Math.PI/2));
		System.out.println(Math.random());
		int[] a;
		a = new int[10];
		System.out.println(a.length);
		printArray(a);
		
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		printArray(b);
		double[] c = {1, 1.5, 0, 2, -1, 6.3};
		printDoubles(c);
		java.util.Arrays.sort(c);
		printDoubles(c);
		
		java.util.Date date = new java.util.Date();
		System.out.println(date.toString());
		
		PrintWriter output = new PrintWriter("t.txt");
		output.print("\n\n\n");
		output.printf("1 + 2 equals %d\n", 3);
		output.close();
		
		int[] l1 = {1, 2, 3, 4};
		int[] l2 = l1;
		int[] l3 = l1.clone();
		System.out.println("l1 == l2 " + (l1 == l2));
		System.out.println("l1 == l3 " + (l1 == l3));
		printArray(l1);
		printArray(l3);
		
		System.out.println("g".compareTo("l"));
		
		Double d = new Double("2.3");
		System.out.println(Double.valueOf("2.5").intValue()); 
		
		Double[] doubleList = {new Double(1.2), new Double(-1), new Double(2), new Double(-3)};
		GenericSort.sort(doubleList);
		GenericSort.printArray(doubleList);
		int i = Integer.MAX_VALUE-1;
		System.out.println(i);
		System.out.println(i*10);
	}
	public static void printArray(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + "\t");
		}
		System.out.print('\n');
	}
	public static void printDoubles(double... a){
		System.out.println(a.length);
		for(int i = 0; i < a.length; i++){
			//be careful of implicit conversion of java
			//1.0 + '\t' equals 1.0 + double('\t')
			//1.0 + "\t" equals "1.0\t"
			System.out.print(a[i] + "\t");
		}
		System.out.print('\n');
	}
	
}
