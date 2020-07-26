//TC - O(N)
//SC - O(H)
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

class Solution2 {
	TreeNode first;
	TreeNode last;
	TreeNode prev;
	boolean flag;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		inorder(root);
		int temp = first.val;
		first.val = last.val;
		last.val = temp;
	}

	public void inorder(TreeNode root) {
		// base
		if (root == null)
			return;

		// logic
		inorder(root.left);
		if (prev != null && prev.val > root.val) {
			if (!flag) {
				flag = true;
				first = prev;
				last = root;
			} else {
				last = root;
			}
		}
		prev = root;
		inorder(root.right);
	}
}