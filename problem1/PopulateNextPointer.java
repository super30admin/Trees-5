// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulateNextPointer {
	/********************* Optimized Approach *********************/
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}

		Node node = root;

		while (node.left != null) {
			Node head = node;
			while (head != null) {
				head.left.next = head.right;
				if (head.next != null) {
					head.right.next = head.next.left;
				}

				head = head.next;
			}
			node = node.left;
		}

		return root;
	}

	/********************* Iterative Level Order Traversal *********************/
	// Time Complexity : O(n), n -> Number of nodes in the tree
	// Space Complexity : O(n), n -> Size of queue
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public Node connectLevelOrder(Node root) {
		if (root == null) {
			return null;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (i < size - 1) {
					node.next = queue.peek();
				}

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				node = node.next;
			}
		}
		return root;
	}

	/********************* DFS *********************/
	// Time Complexity : O(n), n -> Number of nodes in the tree
	// Space Complexity : O(log n), log n -> Size of recursion stack
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public Node connectDFS(Node root) {
		if (root == null) {
			return null;
		}

		dfs(root.left, root.right);

		return root;
	}

	private void dfs(Node left, Node right) {
		// Base
		if (left == null && right == null) {
			return;
		}
		// Logic
		left.next = right;
		dfs(left.left, left.right);
		dfs(left.right, right.left);
		dfs(right.left, right.right);
	}

	private void printTree(Node root) {
		if (root == null) {
			return;
		}

		List<Character> tree = new ArrayList<Character>();

		Node node = root;
		while (node != null) {
			Node currNode = node;
			while (currNode != null) {
				tree.add(Character.forDigit(currNode.val, 10));
				currNode = currNode.next;
			}
			tree.add('#');
			node = node.left;
		}

		for (Character ch : tree) {
			System.out.print(ch + " ");
		}
	}

	public static void main(String[] args) {
		PopulateNextPointer obj = new PopulateNextPointer();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		Node linkedRoot = obj.connect(root);

		obj.printTree(linkedRoot);
	}

}
