/**
 * 
 */
package practiceJava;
import java.util.Stack;
/**
 * @author speng
 */
public class HanoiTower {


	public static void main(String[] args) {
//		Stack s = new Stack ();
//		s.push("a");
//		s.push("b");
//		System.out.println(s);
		Integer[] elements = {4, 3, 2, 1};
		Tower a = new Tower("a", elements);
		Tower b = new Tower("b");
		Tower c = new Tower("c");
		System.out.println(a);
		move(a, c, b, a.size());
	}

	public static void move(Tower source, Tower dest, Tower cache, long n){
		if(n == 1){
			Object item = source.pop();
			dest.push(item);
			String s = String.format("move %s from %s to %s", item, source.name, dest.name);
			System.out.println(s);
		}else{
			move(source, cache, dest, n-1);
			move(source, dest, cache, 1);
			move(cache, dest, source, n-1);
		}
	}
	
}

class Tower extends Stack{
	String name;
	Tower(String name, Object[] elements){
		this.name = name;
		if(elements != null){
			for(Object e: elements){
				push(e);
			}
		}
	}
	
	Tower(String name){
		this(name, null);
	}
}
