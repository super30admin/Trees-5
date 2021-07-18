//Time Complexity : O(n) 
//Space Complexity :O(1) 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
 * 1. It can be solved using BST by linking next node at each level level by level.
 * 2. this approach without Queue is optimal.
 */
class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}

class PerfectBTPopulateNext {
	public Node connect(Node root) {
		if (root == null)
			return null;
		Node level = root;

		while (level.left != null) {
			Node cur = level;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			level = level.left;
		}
		return root;
	}
}