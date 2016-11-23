package lintCode;

import basicAlgorithms.ListNode;
import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q106 {

	public static void main(String[] args) {
		ListNode list = ListNode.createList(new int[]{1, 2, 3, 4});
		ListNode.printList(list);
		TreeNode root = new Q106().sortedListToBST(list);
		TreeNode.preorderTraverse(root);
		System.out.println();
		TreeNode.inorderTraverse(root);
	}

    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
	public TreeNode sortedListToBST(ListNode head) {
		List<TreeNode> list = new ArrayList<TreeNode>();
    	ListNode p = head;
    	while(p != null) {
    		list.add(new TreeNode(p.val));
    		p = p.next;
    	}
    	TreeNode root = constructBalancedBST(list, 0, list.size());
    	return root;
    }

	TreeNode constructBalancedBST(List<TreeNode> list, int start, int end) {
		if (end - start < 1)
			return null;
		int mid = start + (end - start)/2;
		TreeNode root = list.get(mid);
		root.left = constructBalancedBST(list, start, mid);
		root.right = constructBalancedBST(list, mid + 1, end);
		return root;
	}

}
