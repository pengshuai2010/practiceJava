package lintCode;

public class TreeNode {
	public int val;
	public TreeNode left, right;
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
	
	static void preorderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + ", ");
		preorderTraverse(root.left);
		preorderTraverse(root.right);
	}
	
	static void inorderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraverse(root.left);
		System.out.print(root.val + ", ");
		inorderTraverse(root.right);
	}
}
