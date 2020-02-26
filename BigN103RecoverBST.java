//Time complexity is O(n)
//Space complexity is O(h)
//This solution is submitted on leetcode

public class BigN103RecoverBST {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		TreeNode first;
		TreeNode middle;
		TreeNode last;
		TreeNode prev;

		public void recoverTree(TreeNode root) {
			// edge case
			if(last!=null) return; // for breaking recursion
			if (root == null)
				return;
			inorder(root);
			if (first != null && last != null) {
				int temp = first.val;
				first.val = last.val;
				last.val = temp;
			} else if (first != null && middle != null) {
				int temp = first.val;
				first.val = middle.val;
				middle.val = temp;
			}
		}
		private void inorder(TreeNode root) {
			// base case
			if (root == null)
				return;
			// logic
			inorder(root.left);
			if (prev != null && prev.val > root.val) {
				if (first == null) { 
					first = prev;
					middle = root;
				} else { 
					last = root;
				}
			}
			prev = root;
			inorder(root.right);
		}
	}
}