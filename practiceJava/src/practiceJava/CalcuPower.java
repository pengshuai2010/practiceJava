/**
 * 
 */
package practiceJava;

/**
 * @author speng
 * created on Jul 12, 2015
 */
public class CalcuPower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(2,11));
		
	}
	
	/**
	 * Calculate integer power using an O(log(n)) algorithm
	 * exponent must be positive
	 * @param base
	 * @param ex
	 * @return
	 */
	public static double power(double base, long ex){
		
		if(ex == 1){
			return base;
		}else if(ex == 0){
			return 1;
		}else if(ex%2 == 0){
			double tmp = power(base, ex/2);
			return tmp*tmp;
		}else{
			double tmp = power(base, (ex -1)/2);
			return base*tmp*tmp;
		}
		
	}
}
