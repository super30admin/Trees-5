package trees5;

public class PopulatingNextRightPointersInEachNode {

	
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	

	//TC : O(n)
	//SC : O(1) 
	
	class Solution {
	    public Node connect(Node root) {
	        Node start = root;
	        
	        while(start != null) {
	            Node curr = start;
	            
	            while(curr != null) {
	                if(curr.left != null) curr.left.next = curr.right;
	                if(curr.right != null && curr.next != null) curr.right.next = curr.next.left;
	            
	                curr = curr.next;
	            }
	            start = start.left;
	        }
	       return root;
	    }
	}
	
}
