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
    	int length = getLength(head);
    	k = k % length;
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
    	ListNode newList = slow.next;
    	slow.next = null;
    	fast.next = head;
    	head = newList;
    	return head;
    }
    
    int getLength(ListNode head) {
    	int length = 0;
    	while(head != null) {
    		length++;
    		head = head.next;
    	}
    	return length;
    }
    
	public static void main(String[] args) {
		ListNode list = ListNode.createList(new int[] {1, 2, 3, 4, 5});
		ListNode.printList(list);
		list = new Q170().rotateRight(list, 7);
		ListNode.printList(list);
	}

}
