package lintCode;

public class Q35 {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
    	ListNode q = null;
    	ListNode p = head;
    	while (p != null) {
    		ListNode tmp = p;
    		p = p.next;
    		tmp.next = q;
    		q = tmp;
    	}
    	return q;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
