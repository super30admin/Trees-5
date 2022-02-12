package trees5;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
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
	
	//DFS
	//Time Complexity : O(n), where n is the number of elements in root
	//Space Complexity : O(log n), for recursion stack of a perfect BST
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public Node connect(Node root) {
        if(root == null)
            return root;
        dfs(root);
        return root;
    }
    
    private void dfs(Node root) {
        // base
        if(root.left == null)
            return;
        
        root.left.next = root.right;
        dfs(root.left);
        if(root.next != null)
            root.right.next = root.next.left;
        dfs(root.right);
    }
	
	//DFS
	//Time Complexity : O(n), where n is the number of elements in root
	//Space Complexity : O(log n), for recursion stack of a perfect BST
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public Node connect1(Node root) {
        if(root == null)
            return root;
        conn(root.left, root.right);
        return root;
    }
    
    private void conn(Node left, Node right) {
        if(left == null)
            return;
        
        left.next = right;
        conn(left.left, left. right);
        conn(left.right, right.left);
        conn(right.left, right.right);
    }
	
    //BFS
	//Time Complexity : O(n), where n is the number of elements in root
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public Node connect2(Node root) {
        if(root == null)
            return root;
        
        Node level = root;
        while(level.left != null) {
            Node curr = level;
            while(curr != null) {
                curr.left.next = curr.right;
                if(curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }

	//BFS using Queue
	//Time Complexity : O(n), where n is the number of elements in root
	//Space Complexity : O(n), for queue
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public Node connect3(Node root) {
		if(root == null)
			return root;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty()) {
			int size = q.size();
			Node prev = q.poll();
			if(prev.left != null) {
				q.offer(prev.left);
				q.offer(prev.right);
			}
			for(int i=1; i<size; i++) {
				Node curr = q.poll();
				prev.next = curr;
				if(curr.left != null) {
					q.offer(curr.left);
					q.offer(curr.right);
				}
				prev = curr;
			}
		}
		return root;
	}
}
