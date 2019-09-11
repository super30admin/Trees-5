
//time complexity is O(n) n is no of elements in trees
//space complexity is o(n) recursive stack
//idea is to use recursive apprach and pass left and right node to recursive method.
//base condition is if root is null then return null.

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
public class PoppulateNextRightPointer {
	     public Node connect(Node root) {
	      if(root == null) return null;    
	      helper(root.left, root.right); 
	      return root;
	    }
	    
	   public  void helper(Node node1, Node node2){
	      if(node1 == null) return;    
	      node1.next = node2;
	      helper(node1.left, node1.right);
	      helper(node2.left, node2.right);
	      helper(node1.right, node2.left);
	    }
}
