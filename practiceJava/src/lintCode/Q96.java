package lintCode;

public class Q96 {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition1(ListNode head, int x) {
    	ListNode l1 = null;
    	ListNode l2 = null;
    	ListNode p = head;
    	while (p != null) {
    		ListNode tmp = p;
    		p = p.next;
    		if (tmp.val < x) {
    			tmp.next = l1;
    			l1 = tmp;
    		} else {
    			tmp.next = l2;
    			l2 = tmp;
    		}
    	}
    	if (l1 == null)
    		return l2;
    	ListNode p1 = l1;
    	while (p1.next != null)
    		p1 = p1.next;
    	p1.next = l2;
    	return l1;
    }

    public ListNode partition(ListNode head, int x) {
    	ListNode l1 = new ListNode(0);
    	ListNode t1 = l1;
    	ListNode l2 = new ListNode(0);
    	ListNode t2 = l2;
    	ListNode p = head;
    	while (p != null) {
    		ListNode tmp = p;
    		p = p.next;
    		tmp.next = null;
    		if (tmp.val < x) {
    			t1.next = tmp;
    			t1 = t1.next;
    		} else {
    			t2.next = tmp;
    			t2 = t2.next;
    		}
    	}
    	l1 = l1.next;
    	l2 = l2.next;
    	if (l1 == null)
    		return l2;
    	t1.next = l2;
    	return l1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
