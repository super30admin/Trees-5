import java.util.Queue;
import java.util.LinkedList;

//Time : O(N) level order , traversing all nodes
// Space: O(N) leaf nodes that could be asymptotically O(N)

public class PopulateNextPointer {
	 public Node connect(Node root) {
	      if(root==null)
	          return root;
	        
	        Queue<Node> q = new LinkedList<>();
	        q.add(root);
	        while(!q.isEmpty()){
	            int len = q.size();
	            for(int i=0;i<len;i++){
	                Node temp = q.poll();
	                 if(i!=len-1){
	                     temp.next = q.peek();
	                 }
	                if(temp.left!=null)
	                    q.add(temp.left);
	                if(temp.right!=null)
	                    q.add(temp.right);
	            }
	        }
	       return root; 
	    }
	//Time : O(N) level order , traversing all nodes
	//Space: O(1)
	 public Node connect2(Node root) {
	      if(root==null)
	          return root;

	        Node level = root;
	        
	        while(level!=null){
	            Node curr = level;
	            while(curr!=null && curr.left!=null && curr.right!=null){
	               curr.left.next = curr.right;
	               if(curr.next!=null){
	                   curr.right.next = curr.next.left;
	               } 
	                curr = curr.next;
	            }
	            level = level.left;
	        }  
	       return root; 
	    }
	 
}
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