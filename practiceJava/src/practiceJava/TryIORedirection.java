/**
 * 
 */
package practiceJava;

import java.io.*;

/**
 * @author speng
 *
 */
public class TryIORedirection {

	  // Throw exceptions to console:
	  public static void main(String[] args)
	  throws IOException {
		    String current = System.getProperty("user.dir");
	        System.out.println("Current working directory in Java : " + current);
	        
		    PrintStream console = System.out;
		    String inFileName = "src//practiceJava//TryIORedirection.java";
		    BufferedInputStream in = new BufferedInputStream(
		      new FileInputStream(inFileName));
		    PrintStream out = new PrintStream(
		      new BufferedOutputStream(
		        new FileOutputStream("test.out")));
		    System.setIn(in);
		    System.setOut(out);
		    System.setErr(out);
		    BufferedReader br = new BufferedReader(
		      new InputStreamReader(System.in));
		    String s;
		    while((s = br.readLine()) != null)
		      System.out.println(s);
		    out.close(); // Remember this!
		    System.setOut(console);
	  }

}
