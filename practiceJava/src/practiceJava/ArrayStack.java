/**
 * 
 */
package practiceJava;
import java.util.EmptyStackException;

import java.util.Stack;
/**
 * @author speng
 * created on Jul 12, 2015
 */
public class ArrayStack<E> implements StackInterface<E> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();
		ArrayStack<String> s1 = new ArrayStack<String>();
		s1.push("a");
		s1.push("b");
		s1.push("c");
		System.out.println(s1);
		System.out.println(s1.peek());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1);
//		System.out.println(s1.peek());
	}
	
	private E[] array = null;
	private int top = -1;
	private final int INIT_CAP = 100;

	@SuppressWarnings("unchecked")
	public ArrayStack(){
		array = (E[])new Object[INIT_CAP];
	}
	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public void push(E e) {
		if(size() == array.length){
			throw new FullStackException();
		}
		top++;
		array[top] = e;
	}

	@Override
	public E pop() throws EmptyStackException {
		if(isEmpty()){
			throw new EmptyStackException();
		}
		E e = array[top];
		array[top] = null;//for sake of garbage collection
		top--;
		return e;
	}

	@Override
	public E peek() throws EmptyStackException {
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return top < 0;
	}
	
	public String toString(){
		String s = "[";
		if(size() > 0){
			s += array[0];
		}
		for(int i = 1; i < size(); i++){
			s += ", " + array[i];
		}
		s += "]";
		return s;		
	}

}
