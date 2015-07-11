package practiceJava;

public class DoublyLinkedList {
	private DNode header = null;
	private DNode tailer = null;
	private long size = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.LinkedList list = new java.util.LinkedList();
		DNode n = new DNode("a", null, null);
		n.insertAfter("b");
		n.insertAfter("c");
		System.out.println(n);
		
		DoublyLinkedList l = new DoublyLinkedList();
//		l.addFirst("a");
//		l.addFirst("b");
//		l.addLast("c");
//		l.addLast("d");
//		System.out.println(l.getDNode(0));
//		System.out.println(l.getDNode(3));
////		System.out.println(l.getDNode(4));
//		l.removeFirst();
//		l.removeFirst();
//		l.removeLast();
//		l.remove(0);
////		l.removeFirst();
		l.add(0, "a");
		l.add(1, "b");
		l.add(0, "c");
		l.add(0, "d");
		System.out.println(l);
		System.out.println(l.getFirst());
		System.out.println(l.getLast());
		System.out.println(l.get(1));
	}
	
	public DoublyLinkedList(){
		header = new DNode(null, null, null);
		tailer = new DNode(null, header, null);
		header.setNext(tailer);
	}
	
	public long size(){
		return size;
	}
	
	public String toString(){
		String s = "size: " + size() + " [";
		DNode p = header;
		while(p.getNext() != tailer){
			p = p.getNext();
			s += p.getElement().toString() + "\t";
		}
		s += "]";
		return s;
	}
	
	private DNode getDNode(long index){
		if(index < 0 || index > size - 1){
			throw new java.util.NoSuchElementException("index out of bound");
		}
		DNode p = header.getNext();
		for(int i = 0; i < index; i++){
			p = p.getNext();
		}
		return p;
	}
	
	public Object get(long index){
		return getDNode(index).getElement();
	}
	
	public Object getFirst(){
		return get(0);
	}
	
	public Object getLast(){
		return get(size-1);
	}
	
	public void addFirst(Object e){
		header.insertAfter(e);
		size++;
	}
	
	public void addLast(Object e){
		tailer.insertBefore(e);
		size++;
	}
	
	public void add(long index, Object e){
		if(index == size){
			addLast(e);
		}else{
			getDNode(index).insertBefore(e);
			size++;
		}
		
	}
	
	public DNode removeFirst(){
		if(size == 0){
			throw new java.util.NoSuchElementException("list is empty");
		}
		return removeDNode(header.getNext());
	}
	
	public DNode removeLast(){
		if(size == 0){
			throw new java.util.NoSuchElementException("list is empty");
		}
		return removeDNode(tailer.getPrev());
	}
	
	private DNode removeDNode(DNode p){
		DNode u = p.getPrev();
		DNode v = p.getNext();
		u.setNext(v);
		v.setPrev(u);
		p.setPrev(null);
		p.setNext(null);
		size--;
		return p;
	}
	
	public DNode remove(long index){
		return removeDNode(getDNode(index));
	}
}

class DNode{
	private Object element = null;
	private DNode next = null;
	private DNode prev = null;
	
	public DNode(Object element,  DNode prev, DNode next){
		setElement(element);
		setNext(next);
		setPrev(prev);
	}
	
	public Object getElement(){
		return element;
	}
	
	public void setElement(Object element){
		this.element = element;
	}
	
	public DNode getNext(){
		return next;
	}

	public void setNext(DNode next){
		this.next = next;
	}
	
	public DNode getPrev(){
		return prev;
	}
	
	public void setPrev(DNode prev){
		this.prev = prev;
	}
	
	public void insertAfter(Object e){
		DNode n = new DNode(e, this, this.next);
		this.next = n;
		if(n.next != null){
			n.next.prev = n;
		}
	}
	
	public void insertBefore(Object e){
		DNode n = new DNode(e, this.prev, this);
		this.prev = n;
		if(n.prev != null){
			n.prev.next = n;
		}
	}
	public String toString(){
		return element.toString();
	}
}