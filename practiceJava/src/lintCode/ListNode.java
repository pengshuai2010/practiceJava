package lintCode;


// Definition for ListNode.
public class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}

	static ListNode createList(int[] array) {
		if (array == null || array.length == 0)
			return null;
		ListNode head = new ListNode(0);
		ListNode tail = head;
		for (int element: array) {
			tail.next = new ListNode(element);
			tail = tail.next;
		}
		return head.next;
	}

	static void printList(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while(head != null) {
			sb.append(head.val + " -> ");
			head = head.next;
		}
		sb.append("null" + System.lineSeparator());
		System.out.print(sb.toString());
	}
	
    static int getLength(ListNode head) {
    	int length = 0;
    	while(head != null) {
    		length++;
    		head = head.next;
    	}
    	return length;
    }

	ListNode setNext(ListNode node) {
		this.next = node;
		return this;
	}
}