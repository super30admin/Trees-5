import java.util.LinkedList;
import java.util.Queue;

//Time Complexity : O(n)
//Space Complexity : O(1); 
public class PopulateNextRightPointers_BT {		
	/**Definition for a node.**/
	static class Node {
		int val;
		Node left;
		Node right;
		Node next; 
		Node() {}
		Node(int val) {this.val = val;}
		Node(int val, Node left, Node right, Node next) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.next = next;
		}
	}
	
	 /**Approach1: Optimized BFS | Time O(n) | Space O(1)**/
	 public Node connect(Node root) {
        if(root == null) return root;
        //Optimized BFS
        Node level=root;
        Node curr;        
        while(level.left!=null){
            curr= level;
            while(curr!=null){
                curr.left.next= curr.right;
                if(curr.next!=null)
                    curr.right.next=curr.next.left;
                curr=curr.next;   
            }
            level=level.left;
        }
        return root;
	 }	 

	/**Approach2: Optimized DFS | Time O(n) | Space O(log n)**/
	/*public Node connect(Node root) {
		if (root == null || root.left == null || root.right == null) return root;
		// Optimized DFS
		dfs(root);
		return root;
	}
	private void dfs(Node root) {
		// base
		if (root.left == null)	return;
		// logic
		root.left.next = root.right;
		if (root.next != null)
			root.right.next = root.next.left;
		dfs(root.left);
		dfs(root.right);
	}*/
	
	// Driver code to test above
	public static void main (String[] args) {
		PopulateNextRightPointers_BT ob= new PopulateNextRightPointers_BT();
		Node t1= new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, new Node(6), new Node(7), null),	null);		
		
		System.out.println("Populating Next pointers in Tree");
		ob.connect(t1);				
	}	
}
