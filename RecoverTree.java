package week8.day3;
//TC - O(n)
//SC - O(h)
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	TreeNode first;
	TreeNode second;
	TreeNode prev;

	public void recoverTree(TreeNode root) {
		first = second = prev = null;
		helper(root);
		// swap
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	private void helper(TreeNode root) {
		if (root == null)
			return;
		// prev
		helper(root.left);
		if (prev != null && prev.val > root.val) {
			if (first == null) {
				first = prev;
			}
			second = root;
		}
		prev = root;
		helper(root.right);
	}
}

public class RecoverTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
