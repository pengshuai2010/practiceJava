/**
 * 
 */
package practiceJava;
/**
 * @author speng
 *
 */
public class CircularlyLinkedList {

	private ListNode cursor = null;
	private long size = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularlyLinkedList l = new CircularlyLinkedList();
		l.add("a");
		l.add("b");
		l.add("c");
		System.out.println(l);
//		l.remove();
//		System.out.println(l);
//		l.remove();
//		l.remove();
//		System.out.println(l);
		
		System.out.println(l.get());
		l.advance();
		System.out.println(l.get());
		l.advance();
		System.out.println(l.get());
		l.advance();
		System.out.println(l.get());
		l.advance();
		
	}
	
	public long size(){
		return size;
	}
	
	public void add(Object e){
		if(cursor == null){
			cursor = new ListNode(e, null);
			cursor.setNext(cursor);
		}else{
			cursor.insertAfter(e);
		}
		size++;
	}
	
	public ListNode remove(){
		if(cursor == null){
			throw new java.util.NoSuchElementException("list is empty");
		}
		ListNode p = null;
		if(cursor == cursor.getNext()){
			p = cursor;
			cursor = null;
		}else{
			p = cursor.getNext();
			cursor.setNext(p.getNext());
		}
		p.setNext(null);
		size--;
		return p;
	}

	public String toString(){
		String s = "size: " + size() + " [";
		ListNode p = cursor;
		while(p != null){
			s += p.getElement().toString() + "\t";
			p = p.getNext();
			if(p == cursor){
				break;
			}
		}
		s += "]";
		return s;
	}
	
	public void advance(){
		if(cursor == null){
			throw new java.util.NoSuchElementException("list is empty");
		}
		cursor = cursor.getNext();
	}
	
	public Object get(){
		if(cursor == null){
			throw new java.util.NoSuchElementException("list is empty");
		}
		return cursor.getElement();
	}
}
