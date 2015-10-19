/**
 * 
 */
package practiceJava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shuaipeng
 *
 */
public class TryReflection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CalcuPower cal = new CalcuPower();
//		Class<?> cls = cal.getClass();
//		Class[] parameterTypes = new Class[]{double.class, long.class};
//		try {
//			Method method = cls.getDeclaredMethod("power", parameterTypes);
//			method.invoke(null, );
//		} catch (NoSuchMethodException | SecurityException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			Class<?> cls = Class.forName("practiceJava.TryReflection");
			// invoking a method with parameters
//			Class<?>[] parameterTypes = new Class[]{int.class, double.class};
//			Method method = cls.getMethod("sumUp", parameterTypes);
			Method method = cls.getMethod("sumUp", int.class, double.class);
			Object t = cls.newInstance();
			Object res = method.invoke(t, 1, 1.2);
			System.out.println((double)res);
			// invoking a private method with getDeclaredMethod() instead of getMethod()
			// you may need "method.setAccessible(true);"
			method = cls.getDeclaredMethod("printHello");
			method.invoke(null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void printHello() {
		System.out.println("hello");
	}
	
	public double sumUp(int a, double b) {
		return a + b;
	}
}
