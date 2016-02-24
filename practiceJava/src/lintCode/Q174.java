package lintCode;

public class Q174 {



	/**
	 * @param head:
	 *            The first node of linked list.
	 * @param n:
	 *            An integer.
	 * @return: The head of linked list.
	 */
	ListNode removeNthFromEnd1(ListNode head, int n) {
		if (n == 0 || head == null)
			return head;
		int len = 0;
		ListNode node = head;
		while (node != null) {
			node = node.next;
			len++;
		}
		if (len == n) {
			ListNode tmp = head;
			head = head.next;
			tmp.next = null;
			return head;
		}
		node = head;
		for (int i = 0; i < len - n - 1; i++) {
			node = node.next;
		}
		ListNode tmp = node.next;
		node.next = node.next.next;
		tmp.next = null;
		return head;
	}
	
	
	ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0 || head == null)
			return head;
		ListNode p = head;
		ListNode q = head;
		int i = 0;
		for (i = 0; i < n; i++)
			p = p.next;
		if (p == null) {
			ListNode tmp = head;
			head = head.next;
			tmp.next = null;
			return head;
		}
		while (p.next != null) {
			p = p.next;
			q = q.next;
		}
		ListNode tmp = q.next;
		q.next = q.next.next;
		tmp.next = null;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
