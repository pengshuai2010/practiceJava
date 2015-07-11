package practiceJava;
import java.util.ArrayList;
public class MyStack {
	public static void main(String[] args){
		MyStack s = new MyStack();
		System.out.println(s.isEmpty());
		s.push("hello");
		s.push("ohayo");
		s.peek();
		s.pop();
		s.pop();
		System.out.println(s.isEmpty());
		s.peek();
	}
	public MyStack(){
		list = new ArrayList();
	}
	
	public boolean isEmpty(){
		return 0 == list.size();
	}
	
	public Object pop(){
		assert list.size() != 0;
		Object o = list.get(list.size()-1);
		list.remove(list.size()-1);
		System.out.println("pop " + o);
		return o;
	}
	
	public void push(Object o){
		list.add(o);
		System.out.println("push " + o);
	}
	
	public Object peek(){
		assert list.size() != 0;//note that assert is disable by default
		return list.get(list.size()-1);
	}
	
	private ArrayList list;
}
