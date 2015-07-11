/**
 * 
 */
package practiceJava;
import java.util.LinkedList;

/**
 * @author speng
 *
 */
public class SinglyLinkedList {
	private ListNode head = null;
	private long size = 0;
	//private ListNode tail = null;
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		// TODO Auto-generated method stub
		ListNode n = new ListNode("a", null);
		n.insertAfter("b");
		System.out.println(n.getElement());
		System.out.println(n.getNext().getElement());
		
		SinglyLinkedList l = new SinglyLinkedList();
//		l.head = new ListNode("a", null);
//		l.head.insertAfter("b");
//		l.head.insertAfter("c");
		
//		l.addFirst("a");
//		l.addFirst("b");
//		l.addFirst("c");
		
//		l.add(0, "a");
//		l.add(1, "b");
//		l.add(0, "c");
//		l.add(3, "d");
		
		l.add("a");
		l.add("b");
		l.add("c");
		l.removeFirst();
//		l.removeFirst();
//		l.removeFirst();
//		l.removeFirst();
		System.out.println(l);
	}
	
	public String toString(){
		String s = "size: " + size() + " [";
		ListNode p = head;
		while(p != null){
			s += p.getElement().toString() + "\t";
			p = p.getNext();
		}
		s += "]";
		return s;
	}
	
	public void addFirst(Object e){
		ListNode newNode = new ListNode(e, head);
		head = newNode;
		size++;
	}
	
	public boolean add(long index, Object e){
		if(index > size() || index < 0){
			return false;
		}
		ListNode q = null, p = head;
		for(int i = 0; i < index; i++){
			q = p;
			p = p.getNext();
		}
		if(q == null){
			addFirst(e);
		}else{
			q.insertAfter(e);
			size++;
		}
		return true;
	}
	
	public boolean addLast(Object e){
		return add(size(), e);
	}
	
	public void add(Object e){
		addFirst(e);
	}
	
	public Object removeFirst(){
		if(head == null){
			throw new java.util.NoSuchElementException("linked list is empty");
		}
		ListNode p = head;
		head = head.getNext();
		size--;
		p.setNext(null);//don't forget!!!
		return p;
	}
	
	public long size(){
		return size;
	}
}

class ListNode{
	private Object element = null;
	private ListNode next = null;
	
	public ListNode(Object element, ListNode next){
		setElement(element);
		setNext(next);
	}
	
	public Object getElement(){
		return element;
	}
	
	public void setElement(Object element){
		this.element = element;
	}
	
	public ListNode getNext(){
		return next;
	}
	
	public void setNext(ListNode next){
		this.next = next;
	}
	
	public void insertAfter(Object element){
		next = new ListNode(element, this.next);
	}
}