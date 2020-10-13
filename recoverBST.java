// TC: O(1) in best case and O(N) in worst case where we will iterate entire tree
// SC: O(H) where H is hieght of the tree

public class recoverBST {

	public void recoverBst(TreeNode root) {
		TreeNode prev = null, x = null, y = null;
		// perform inorder traversal and check which are the 2 elements which have been swapped
		inorder(root, prev, x, y);
		// swap those 2 elements in tree
		swap(x, y);
	}
	public void inorder(TreeNode root, TreeNode prev,  TreeNode x, TreeNode y) {
		
		if(root == null)
			return;
		// recurse over the left tree
		inorder(root.left, prev, x, y);
		// if the previous is not null, check if the current node val is greater than prev, else, this is place where the 2 nodes are
		// swapped because we know that the inorder traversal of BST always gives the values in ascending order
		if(prev != null && root.val < prev.val) {
			y = root; // y will have next swap value
			// check if we have not already assigned the previous value to x 
			if(x == null)
				x = prev; // x will have the previous swap value
			else // if wehvae already assigned the previous value, return 
				return;
		}
		// store the previous value so that we can check it later
		prev = root;
		// recurse over the right subtree
		inorder(root.right, prev,x,y);
	}
	
	public void swap(TreeNode x, TreeNode y) {
		// we have stored the 2 values which are swapped, now we will swap those 2 to their values to obtain our BST
		int temp = x.val;
		x.val = y.val;
		y.val = temp;
	}
	
	public static void main(String[] args) {
		
	}
}
