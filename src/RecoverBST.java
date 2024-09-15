//Time Complexity : O(N) 
//Space Complexity : O(log N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take three nodes first, second and prev. First is used for
 * storing the first mismatch and second for the second mismatch.
 * Apply inorder traversal. After left traversal, make the prev as
 * root and apply right traversal. After left traversal check if
 * prev is not null and violating the bst properties. If so,
 * store the prev is first if first not null and root in second.
 * Finally swap first and second.
 *
 */
class Solution {
	TreeNode first;
	TreeNode second;
	TreeNode prev;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		inOrder(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		if (prev != null && prev.val >= root.val) {
			if (first == null) {
				first = prev;
				second = root;
			} else {
				second = root;
			}
		}
		prev = root;
		inOrder(root.right);
	}
}