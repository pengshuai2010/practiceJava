/**
 * 
 */
package practiceJava;

/**
 * @author speng
 *
 */
public class FileAccess {
	private int sum;
	private int max;
	
	public FileAccess(int max) {
		this.sum = 0;
		this.max = max;
	}
	
	public synchronized void startAccess(int id) {
		while(!this.testCondition(id)) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.sum += id;
	}
	
	public synchronized void endAccess(int id) {
		this.sum -= id;
		this.notifyAll();
	}
	
	private boolean testCondition(int id) {
		return (id + this.sum <= this.max);
	}
}
