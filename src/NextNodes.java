//Time Complexity : O(N) 
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * This is similar to Level order traversal. In each level until root is not
 * null, get the make the root.left.next = root.right and then if root.right is
 * not null and root.next is not null, then put root.right.next =
 * root.next.left. then move the current node to node.next in the same level.
 * once one level is done, move the root to root.left.
 *
 */
class Solution {
	public Node connect(Node root) {
		if (root == null)
			return null;
		Node node = root;
		while (node != null) {
			Node temp = node;
			while (temp != null) {
				if (temp.left != null)
					temp.left.next = temp.right;

				if (temp.right != null && temp.next != null)
					temp.right.next = temp.next.left;
				temp = temp.next;
			}
			node = node.left;
		}
		return root;
	}
}