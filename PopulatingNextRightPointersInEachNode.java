package s30Coding;

//Time Complexity :- O(n) where n is number of nodes in the tree
//Space Complexity :- O(1) 
//LeetCode :- Yes

public class PopulatingNextRightPointersInEachNode {
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
	}
	public Node connect(Node root) {
        if(root == null) return null;
        Node level = root;
        while(level.left !=null){
            Node curr = level;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null)
                { 
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}
