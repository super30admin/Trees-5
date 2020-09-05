import java.util.*;
// Definition for a Node.
class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

/**********************************Approach 1*******************************************/
//Time Complexity : O(n), number of nodes
//Space Complexity : O(n), n/2 leaf nodes worst case in queue
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no


class Populating_Next_Right_Pointers_in_Each_Node_Queue {
	public Node connect(Node root) {
		if(root == null)
			return null;

		Queue<Node> q = new LinkedList<>();
		q.add(root);    //inserting root to queue
		while(!q.isEmpty()){
			int size = q.size();    //to process level by level
			for(int i=0; i<size; i++){
				Node curr = q.poll();   //get the topmost node from queue
				if(i != size-1){    //if its not last node
					Node next = q.peek();   //get the next node
					curr.next = next;
				}

				//adding the left and right child of the node to queue
				if(curr.left != null)
					q.add(curr.left);
				if(curr.right != null)
					q.add(curr.right);
			}
		}
		return root;
	}
}

/**********************************Approach 2*******************************************/
//Time Complexity : O(n), number of nodes
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

/**By Traversing level wise, next level pointing to left node of current element
 * In each level, assign left node's next pointer of parent node to right node and assign right node's next pointer to parent node's next node's left node
 * ***/

public class Populating_Next_Right_Pointers_in_Each_Node {
	public Node connect(Node root) {
		if(root == null)
			return null;

		Node level = root;  //to traverse level wise

		while(level.left != null){  // till we have not reached last level
			Node curr = level;  //to traverse all element in the level

			while(curr != null){    // till we don't reach null
				curr.left.next = curr.right;    //point the left child next to right child

				if(curr.next != null){  //if we have another node in the level
					curr.right.next = curr.next.left;   //point the next of right child to currents next's left
				}

				curr = curr.next; // move curr
			}
			level = level.left;   // move level
		}
		return root;
	}
}

/**********************************Approach 3*******************************************/
//Time Complexity : O(n), number of nodes
//Space Complexity : O(1), assuming implicit stack space does not count as extra space for this problem
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

class Populating_Next_Right_Pointers_in_Each_Node_DFS {
	public Node connect(Node root) {
		if(root == null)
			return null;

		dfs(root, null);
		return root;
	}

	private void dfs(Node left, Node right){
		//base
		if(left == null)
			return;
		//logic
		left.next = right;
		dfs(left.left, left.right);

		if(right != null){
			dfs(left.right, right.left);
			dfs(right.left, right.right);
		}
	}
}