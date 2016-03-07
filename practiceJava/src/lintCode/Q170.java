package lintCode;

public class Q170 {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
    	if (head == null || head.next == null)
    		return head;
    	if (k == 0)
    		return head;
    	ListNode fast = head;
    	ListNode slow = head;
    	for (int i = 0; i < k; i++)
    		fast = fast.next;
    	while (fast.next != null) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    	while (slow.next != null) {
    		ListNode tmp = slow.next;
    		slow.next = slow.next.next;
    		tmp.next = head;
    		head = tmp;
    	}
    	return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
