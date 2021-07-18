//Time Complexity : O(n) 
//Space Complexity :O(h) 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
 * 1. Do inorder traversal and compare previous node value with current root.
 * 2. for first breach prev and current node as nodes to correct.
 * 3. if second breach found then update second node to replace. 
 */
class RecoverBST {
	TreeNode first;
	TreeNode second;
	TreeNode prev;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		inorder(root);
		if (first != null && second != null) {
			int val = first.val;
			first.val = second.val;
			second.val = val;
		}
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev != null && prev.val > root.val) {
			if (second==null) {
				first = prev;
				second = root;
			} else {
				second = root;
				return;
			}
		}
		prev = root;
		inorder(root.right);
	}

	public class TreeNode {
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

}