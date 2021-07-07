// Time Complexity : O(N) for Both Level and InOrder Traversal
// Space Complexity : O(log N) for Level Order Traversal,O(1) for Inorder Traversal
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode prev, first, middle, last;

	public void recoverTree(TreeNode root) {
		if (root != null) {
			inorderTraversal(root);
			if (first != null && last != null) {
				int temp = first.val;
				first.val = last.val;
				last.val = temp;
			}
			// Adjacent nodes swapped
			else if (first != null && middle != null) {
				int temp = first.val;
				first.val = middle.val;
				middle.val = temp;
			}
		}
	}

	public void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}

	public void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		if (prev != null && root.val < prev.val) {
			if (first == null) {
				first = prev;
				middle = root;
			} else {
				last = root;
			}
		}
		prev = root;
		inorderTraversal(root.right);
	}


}