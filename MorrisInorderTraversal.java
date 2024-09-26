package week10.day2;

import java.util.ArrayList;
import java.util.List;

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

// TC - O(nh)
// SC - O(1)
class Solution30 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left == null) { // at leaf
				list.add(curr.val);
				curr = curr.right;
			} else {
				TreeNode predecessor = curr.left;
				while (predecessor.right != null && predecessor.right != curr) { // predecessor move to right most node
					predecessor = predecessor.right;
				}
				if (predecessor.right == null) { // at leaf, first visit, make it point to successor
					predecessor.right = curr;
					curr = curr.left;
				} else if (predecessor.right == curr) { // second visit
					predecessor.right = null; // upward - make the pointer to null
					list.add(curr.val); // add curr to list or print
					curr = curr.right;
				}
			}
		}
		return list;
	}
}

public class MorrisInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
