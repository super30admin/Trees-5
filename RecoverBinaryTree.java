	// Time O(N)
	// Space O(H)

public class RecoverBinaryTree {

	    TreeNode first;
	    TreeNode second;
	    TreeNode prev;
	    
	    public void recoverTree(TreeNode root) {
	       
	        inOrder(root);
	        
	        int firstVal = first.val;
	        first.val = second.val;
	        second.val = firstVal;
	        
	    }
	    
	    public void inOrder(TreeNode root){
	        // base 
	        if(root==null)
	            return;
	       
	        inOrder(root.left);
	        // stack.pop()
	         if(prev != null && root.val<=prev.val){
	            if(first==null){
	                first = root;
	                second = prev;
	            }else{
	                first = root;
	            }
	        }
	        prev = root;
	        inOrder(root.right); 
	    }
	    
	}
