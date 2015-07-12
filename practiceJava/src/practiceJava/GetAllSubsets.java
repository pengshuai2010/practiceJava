/**
 * 
 */
package practiceJava;
import java.util.ArrayList;
/**
 * @author speng
 * created on Jul 11, 2015
 */
public class GetAllSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"a", "b", "c", "d"};
		boolean[] f = new boolean[a.length];
		build(a, f, 0);
		
	}

	static void build(Object[] array, boolean[] flag, int n){
		if(n < array.length){
			boolean[] choices = {true, false};
			for(boolean c: choices){
				flag[n] = c;
				build(array, flag, n+1);
			}
		}else{
			ArrayList tmpList = new ArrayList();
			for(int i = 0; i < array.length; i++){
				if(flag[i]){
					tmpList.add(array[i]);
				}
			}
			System.out.println(tmpList);
		}
	}
}
