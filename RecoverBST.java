import java.util.Stack;

//tc o(n)
//Morrisinorder traversal first check left side or root and locate its right most element ,create temporary link between root and rightmost element.
//if already established link then check rightside of root.for every check update values of previous and current and at the end swap both values
//Morris sc o(1) 
//recursive and iterative sc o(n)
public class RecoverBST {
	//class TreeNode
	public  class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			val = value;
		}
	}
	
	public void recoverTreeMorris(TreeNode root) {
		//Morris-traversal
		
	    TreeNode first = null;
	    TreeNode second = null;
	    
	    TreeNode pred = null; //rightmost node in left tree
	    TreeNode prev = null; 
	    
	    TreeNode curr = root;
	    
	    while(curr != null){
	        //for each node, we compare it with prev node as we did in in-order-traversal
	        if(prev != null && curr.val <= prev.val){
	            if(first == null) first = prev;
	            second = curr;
	        }
	        
	        if(curr.left != null){
	            //got left tree, then let's locate its rightmost node in left tree
	            pred = curr.left;
	            //we may have visited the left tree before, and connect the rightmost node with curr node (root node)
	            while(pred.right != null && pred.right != curr){
	                pred = pred.right;
	            }
	            
	            if(pred.right == curr){
	                //if this left tree has been visited before, then we are done with it
	                //cut the connection with currNode and start visit curr's right tree
	                pred.right = null;
	                prev = curr;
	                curr = curr.right;
	            }else{
	                //if this left tree has not been visited before, then we create a back edge from rightmost node
	                // to curr node, so we can return to the start point after done the left tree
	                pred.right = curr;
	                curr = curr.left;
	            }
	            
	        }else{
	            //no left tree, then just visit its right tree
	            prev = curr;
	            curr = curr.right;
	        }
	    }
	    
	    int temp = first.val;
	    first.val = second.val;
	    second.val = temp;
	}
	
	
	//iterative with stack
	public void recoverTreeIterative(TreeNode root) {
	    TreeNode first = null;
	    TreeNode second = null;
	    
	    TreeNode curr = root;
	    TreeNode prev = null;
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    
	    while(!stack.isEmpty() ||  curr != null){
	        if(curr != null){
	            //visit curr's left subtree
	            stack.push(curr);
	            curr = curr.left;
	        }else{
	            //done left subtree of curr Node
	            curr = stack.pop();
	            
	            //compare curr.val with prev.val if we have one
	            if(prev != null && curr.val <= prev.val){
	                //incorrect smaller node is always found as prev node
	                if(first == null) first = prev;
	                //incorrect larger node is always found as curr node
	                second = curr;         
	            }  
	            
	            //visit curr's right subtree
	            prev = curr;
	            curr = curr.right;
	        }
	    }
	    
	    //recover swapped nodes
	    int temp = first.val;
	    first.val = second.val;
	    second.val = temp;
	}
	
	//recursive
	
	public void recoverTreeRecursive(TreeNode root) {
	    //use inorder traversal to detect incorrect node
	    
	    inOrder(root);
	    

	    int temp = first.val;
	    first.val = second.val;
	    second.val = temp;
	}

	TreeNode prev = null;
	TreeNode first = null;
	TreeNode second = null;

	public void inOrder(TreeNode root){
	    if(root == null) return;
	    //search left tree
	    inOrder(root.left);
	    
	    //in inorder traversal of BST, prev should always have smaller value than current value
	    if(prev != null && prev.val >= root.val){
	        //incorrect smaller node is always found as prev node
	        if(first == null) first = prev;
	      //incorrect larger node is always found as curr(root) node
	        second = root;
	    }
	    
	    
	    //update prev node
	    prev = root;

	    //search right tree
	    inOrder(root.right);
	}

}
