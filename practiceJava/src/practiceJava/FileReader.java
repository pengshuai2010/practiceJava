/**
 * 
 */
package practiceJava;

import java.util.Random;

/**
 * @author speng
 *
 */
public class FileReader implements Runnable {
	private int id;
	private FileAccess monitor;
	private int iterations;
	private Random rn;
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.printf("Thread %d starting up.\n", this.id);
		for(int i = 0; i < this.iterations; i++) {
			this.monitor.startAccess(this.id);
			System.out.printf("Thread %d starting file access.\n", id);
			int millis = rn.nextInt(1000);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.monitor.endAccess(id);
			System.out.printf("Thread %d ended file access.\n", id);
			millis = rn.nextInt(1000);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public FileReader(int id, FileAccess monitor, int iterations) {
		this.id = id;
		this.monitor = monitor;
		this.iterations = iterations;
		this.rn = new Random();
	}

}
