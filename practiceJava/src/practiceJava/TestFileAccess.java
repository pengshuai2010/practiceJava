/**
 * 
 */
package practiceJava;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * @author speng
 *
 */
public class TestFileAccess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length < 3) {
//			System.err.printf("Usage: java %s <numThreads> <max sum> <iterations>", TestFileAccess.class.getName());
			System.err.println("Usage: java TestFileAccess <numThreads> <max sum> <iterations>");
			System.exit(1);
		}
		Timer timer = new Timer();
		long timeoutMilliseconds = (long) (30*1e3);
		timer.schedule(new TimeoutTask(), timeoutMilliseconds);
		
		int numThreads = Integer.parseInt(args[0]);
		int max = Integer.parseInt(args[1]);
		int iterations = Integer.parseInt(args[2]);
		FileAccess monitor = new FileAccess(max);
		List<Thread> list = new ArrayList<Thread>();
		for(int i = 0; i < numThreads; i++) {
			Thread thread = new Thread(new MyFileReader(i + 1, monitor, iterations));
			list.add(thread);
			thread.start();
		}
		for(Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.err.println("failed to join");
				e.printStackTrace();
			}
		}
		System.exit(0);
	}

}
