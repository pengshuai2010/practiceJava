/**
 * 
 */
package practiceJava;

import java.util.TimerTask;

/**
 * @author speng
 *
 */
public class TimeoutTask extends TimerTask {

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Aieeeeeee...received an alarm. Timeout!");
		System.exit(0);
	}

}
