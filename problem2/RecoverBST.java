// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(log n), log n -> Size of recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class RecoverBST {

	/********************* Inorder - Recursive *********************/
	TreeNode prev;
	boolean flag;
	TreeNode first;
	TreeNode last;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}

		prev = null;
		inorder(root);

		int temp = first.val;
		first.val = last.val;
		last.val = temp;
	}

	private void inorder(TreeNode root) {
		// Base
		if (root == null) {
			return;
		}
		// Logic
		inorder(root.left);
		if (prev != null && prev.val > root.val) {
			if (!flag) {
				// First Breach
				first = prev;
				last = root;
				flag = true;
			} else {
				// Second Breach
				last = root;
			}
		}
		prev = root;
		inorder(root.right);
	}

	private void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}

		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		RecoverBST obj = new RecoverBST();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);

		System.out.println("Inorder traversal of tree before swap: ");
		obj.printInorder(root);
		System.out.println();
		obj.recoverTree(root);
		System.out.println("Inorder traversal of tree after swap: ");
		obj.printInorder(root);
	}

}
