/**
 * 
 */
package practiceJava;

/**
 * @author speng created on Jul 12, 2015
 */
public interface StackInterface<E> {
	public int size();

	public void push(E e);
	
	public E pop() throws java.util.EmptyStackException;
	
	public E peek() throws java.util.EmptyStackException;
	
	public boolean isEmpty();

}
