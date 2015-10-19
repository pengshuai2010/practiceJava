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
		try {
			Class<?> cls = Class.forName("practiceJava.TryReflection");
			// invoking a method with parameters
//			Class<?>[] parameterTypes = new Class[]{int.class, double.class};
//			Method method = cls.getMethod("sumUp", parameterTypes);
			Method method = cls.getMethod("sumUp", int.class, double.class);
			Object t = cls.newInstance();
			Object res = method.invoke(t, 1, 1.2);// you need an object of that class to invoke a non-static method on it
			System.out.println((double)res);
			// invoking a private method with getDeclaredMethod() instead of getMethod()
			// you may need "method.setAccessible(true);"
			method = cls.getDeclaredMethod("printHello");
			method.invoke(null);// when invoking a static method, first argument is null
			
			method = cls.getDeclaredMethod("printMsg", String.class);
			method.invoke(null, "koniqiwa");
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
	private static void printMsg(String msg) {
		System.out.println(msg);
	}
	private static void printHello() {
		System.out.println("hello");
	}
	
	public double sumUp(int a, double b) {
		return a + b;
	}
}
