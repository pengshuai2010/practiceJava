package lintCode;

public class Q165 {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null)
    		return l2;
    	if (l2 == null)
    		return l1;
    	ListNode l = new ListNode(0);
    	ListNode t = l;
    	ListNode p1 = l1;
    	ListNode p2 = l2;
    	while (p1 != null && p2 != null) {
    		ListNode tmp = null;
    		if (p1.val < p2.val) {
    			tmp = p1;
    			p1 = p1.next;
    		} else {
    			tmp = p2;
    			p2 = p2.next;
    		}
    		tmp.next = null;
    		t.next = tmp;
    		t = t.next;
    	}
    	if (p1 != null)
    		t.next = p1;
    	else 
    		t.next = p2;
    	ListNode tmp = l;
    	l = l.next;
    	tmp.next = null;
    	return l;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
