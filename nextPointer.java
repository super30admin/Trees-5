// TC: O(N) where N is number of nodes in tree
// SC: O(1) constant space complexity
import java.util.*;
public class nextPointer {

	public Node connect(Node root) {
		
		if(root == null)
			return null;
		
		Node leftmost = root;
		
		while(leftmost.left != null) {
			
			Node head = leftmost;  // assign the leftmost value in Tree
			
			while(head != null) { // loop until all the values in the level are assigned to next pointers
				
				head.left.next = head.right; // assign left of next pointer to right pointer
				if(head.next!=null) { // if the next pointer is not null, we know that we have not reached end of the level
					// we have already assigned left pointer to right pointer, we are left with assigning right root of left subtree to left root of right subtree
					head.right.next = head.next.left;
				}
				// move ahead in the same level
				head = head.next;
			}
			// move ahead in the left tree since we are checking from left and assigning next pointer to the left in same level
			leftmost = leftmost.left;
		}
		
		return root;
	}
	
	// BFS approach, TC: O(N) n is number of nodes in tree
	// SC: O(logN) because we are storing only height of tree on to the queue which is also number of nodes in each level
	
	public Node connectII(Node root) {
		
		if(root == null)
			return null;
		
		Deque<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
		
			int size = q.size();
			// loop over the length of the level in BT
			for(int i=0;i<size;i++) {
				// retrieve the first node in the tree which is left
				Node curr = q.poll();
				if(i < size-1) // assign the next pointer to first element in the queue
					curr.next = q.peek();
				// Queue will always maintain FIFO, so assignment will go from left to right in each level
				// if the left node is not null, add it to queue so that we can assign it to next pointer
				if(curr.left != null)
					q.add(curr.left);
				// if the right node is not null, add it to queue so that we can assign it to next pointer
				if(curr.right != null)
					q.add(curr.right);
			}
		}
		// return the root node since its reference to curr and queue
		return root;
	}
	
}
